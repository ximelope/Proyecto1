package modeloGaleria;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Galeria {
	public HashMap<String, Escultura> esculturas = new HashMap<>();
	public HashMap<String, Pintura> pinturas = new HashMap<>();
	public HashMap<String, Video> videos  = new HashMap<>();
	public HashMap<String, Fotografia> fotografias = new HashMap<>();
	public HashMap<String, Impresion> impresiones = new HashMap<>();
	public HashMap<String, Pieza> piezas = new HashMap<>();
	public HashMap<String, Subasta> subastas = new HashMap<>();
	public HashMap<String, Registro> registros = new HashMap<>();
	public HashMap<String, String> usuarios = new HashMap<>();
	public HashMap<String, Comprador> clientes = new HashMap<>();
	public HashMap<String, Venta> ventas = new HashMap<>();
	public Administrador administrador;
	
	 public void cargarInformacion() {
	        try {

	            cargarUsuarios();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	
	public void login(String usuario, String contrasena) {

        System.out.println(usuarios.get(usuario));
        if (contrasena.equals(usuarios.get(usuario))) {
        	System.out.println("1) Propietario");
        	System.out.println("2) Operador");
        	System.out.println("3) Cajero");
        	int rol = Integer.parseInt(input("\nSeleccione su rol"));
            if (rol==1) {
                infoAdmin(usuario, contrasena);
            } else if (rol==2) {
                infoOperador(usuario, contrasena);
            } else if (rol== 3){
                infoCajero(usuario, contrasena);
            }
        } else {
            System.out.println("Usuario o contraseña incorrecta");
        }

    }
	 public void infoAdmin(String usuario, String contrasena) {
	        int opcion;
	        Administrador admin = new Administrador(usuario, contrasena);
	        this.administrador= admin;
	        do {
	            System.out.println("Opciones Administrador");
	            System.out.println("1.) Cargar Piezas al inventario ");
	            System.out.println("2.) Crear Pieza y añadir al inventario");
	            System.out.println("3.) Mostrar los titulos que se encuentran en el inventario");
	            System.out.println("4.) Cerrar Sesión ");
	            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
	            if (opcion == 1) {
	            	System.out.println(opcion);
	                File archivoPiezas = new File(
	                		"../proyecto/src/data/Piezas.txt");
	                admin.cargarPieza(archivoPiezas,piezas,  esculturas,pinturas, fotografias, videos, impresiones );
	                System.out.println(opcion);
	            } else if (opcion == 2) {
	                admin.pedir_crearPieza(piezas,  esculturas,pinturas, fotografias, videos, impresiones);
	                }
	            else if (opcion == 3) {
	            	System.out.println(piezas.keySet());
	            	
	                
	            } else if (opcion == 4) {
	                almacenarEsculturas();
	                almacenarPinturas();
	                almacenarFotografias();
	                almacenarImpresiones();
	                almacenarVideos();
	                
	            } else {
	                System.out.println("Opcion Inválida");
	            }
	        } while (opcion != 4);
	    }
	 public void infoOperador(String usuario, String contrasena) {
	        int opcion;
	        Operador operador = new Operador(usuario, contrasena);
	        do {
	            System.out.println("Opciones Operador");
	            System.out.println("1.) Cargar Subasta");
	            System.out.println("2.) Crear Subasta");
	            System.out.println("3.) Cargar Registros ");
	            System.out.println("4.) Crear Registros ");
	            System.out.println("5.) Cerrar Subasta (mostar el nuevo dueño) ");
	            System.out.println("6.) Cerrar Sesión ");
	            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
	            if (opcion == 1) {
	                File archivoSubastas= new File(
	                        "../proyecto/src/data/Subastas.txt");
	                operador.cargarSubastas(archivoSubastas,piezas, subastas);
	            } else if (opcion == 2) {
	                operador.crearSubasta_pedir(piezas, subastas);
	                
	            } else if (opcion == 3) {
	            	File archivoRegistros= new File(
	                        "../proyecto/src/data/Registros.txt");
	                operador.cargarRegistros(archivoRegistros,piezas, registros,clientes, administrador);
	            }else if (opcion == 4) {
	                operador.crearRegistro_pedir(piezas, registros, clientes, administrador);
	            }else if (opcion == 5) {
	            	String id = input("Ingrese el id de la subasta a finalizar(00aa, 00bb)");
	            	System.out.println(operador.ganador(id));
	            }else if (opcion == 6) {
	                almacenarRegistros();
	                almacenarSubastas();
	            } else {
	                System.out.println("Opcion Inválida");
	            }
	        } while (opcion != 6);
	    }
	 public void infoCajero(String usuario, String contrasena) {
	        int opcion;
	        Cajero admin = new Cajero(usuario, contrasena);
	        do {
	            System.out.println("Opciones Cajero");
	            System.out.println("1.) Crear Venta");
	            System.out.println("2.) Cargar Venta");
	            System.out.println("3.) Confirmar pago-Dar factura ");
	            System.out.println("4.) Cerrar sesión ");
	            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
	            if (opcion == 2) {
	                File archivoCajero= new File(
	                        "../proyecto/src/data/Ventas.txt");
	                admin.cargarVenta(archivoCajero,piezas, clientes, ventas);
	            } else if (opcion == 1) {
	                admin.pedirVenta(piezas, clientes, ventas);
	                
	            } else if (opcion == 3) {
	            	String titulo= input("Ingrese el titulo de la pieza: ");
	                int factura = admin.darFactura(titulo,ventas);
	                System.out.println("La factura es: " + factura);
	            }else if (opcion == 4) {
	                almacenarVentas();
	            } else {
	                System.out.println("Opcion Inválida");
	            }
	        } while (opcion != 4);
	    }
	 public String input (String mensaje) {
	        try {
	            System.out.print(mensaje + ": ");
	            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	            return reader.readLine();
	        } catch (IOException e) {
	            return null;
	        }
	    }
	 private void cargarUsuarios() {
	        System.out.println("Cargando base de datos de Usuarios");
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(new File(
	                    "../proyecto/src/data/Usuarios.txt")));
	            String linea;
	            linea = br.readLine();
	            while (linea != null) {
	                String[] partes = linea.split(";");
	                String usuario = partes[0];
	                String contrasena = partes[1];

	                usuarios.put(usuario, contrasena);

	                linea = br.readLine();
	                System.out.println(linea);
	            }
	            br.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 public void almacenarEsculturas() {
		 try (
	                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
	                		"../proyecto/src/data/Piezas.txt")))) {
	            String textos = "";
				for(Escultura pieza : esculturas.values()) {
					String login =  (pieza.getPropietario()).getLogin() ;
					String contrasena =  (pieza.getPropietario()).getContrasena() ;
					String correo =  (pieza.getPropietario()).getCorreoElectronico() ;
					int numero =  (pieza.getPropietario()).getNumeroDeTelefono() ;
					String tipo = pieza.getTipo();
					
					textos+=tipo + ";" + pieza.getTitulo() + ";" + pieza.getAno() + ";" + pieza.getLugarCreacion() + ";" + pieza.getAutor()+ ";" + pieza.isExhibida() + ";" 
					+ pieza.isPermisoVenta() + ";" + pieza.getValorFijo() + ";" + pieza.getValorMinimoSubasta()  + ";" + login  + ";" + contrasena + ";" + correo  + ";" + numero  + ";" + pieza.getEstadoDePieza()+
					";" + pieza.getAlto() + ";" + pieza.getAncho() + ";" + pieza.getProfundidad() + ";" + pieza.getMaterialEscultura() + ";" + pieza.getPeso() + ";" + pieza.getNecesidadElectricidad()+ ";" + pieza.getDetallesInstalacion()+"\n";
			}
			bw.write(textos);
            bw.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
	 public void almacenarPinturas() {
		 try (
	                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
	                		"../proyecto/src/data/Piezas.txt")))) {
	            String textos = "";
				for(Pintura pieza : pinturas.values()) {
					String login =  (pieza.getPropietario()).getLogin() ;
					String contrasena =  (pieza.getPropietario()).getContrasena() ;
					String correo =  (pieza.getPropietario()).getCorreoElectronico() ;
					int numero =  (pieza.getPropietario()).getNumeroDeTelefono() ;
					String tipo = pieza.getTipo();
					
					textos+= tipo + ";" + pieza.getTitulo() + ";" + pieza.getAno() + ";" + pieza.getLugarCreacion() + ";" + pieza.getAutor()+ ";" + pieza.isExhibida() + ";" 
					+ pieza.isPermisoVenta() + ";" + pieza.getValorFijo() + ";" + pieza.getValorMinimoSubasta()  + ";" + login  + ";" + contrasena + ";" + correo  + ";" + numero  + ";" + pieza.getEstadoDePieza()+
					";" + pieza.getAlto() + ";" + pieza.getAncho() + ";" + pieza.getMaterialBase() + ";" + pieza.getTipoPinturas() +"\n";
				}
				bw.write(textos);
	            bw.close();
	        } catch (IOException e) {

	            e.printStackTrace();
	        }

	    }
	 public void almacenarFotografias() {
		 try (
	                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
	                		"../proyecto/src/data/Piezas.txt")))) {
	            String textos = "";
				for(Fotografia pieza : fotografias.values()) {
					String login =  (pieza.getPropietario()).getLogin() ;
					String contrasena =  (pieza.getPropietario()).getContrasena() ;
					String correo =  (pieza.getPropietario()).getCorreoElectronico() ;
					int numero =  (pieza.getPropietario()).getNumeroDeTelefono() ;
					String tipo = pieza.getTipo();
					
					textos+= tipo + ";" + pieza.getTitulo() + ";" + pieza.getAno() + ";" + pieza.getLugarCreacion() + ";" + pieza.getAutor()+ ";" + pieza.isExhibida() + ";" 
					+ pieza.isPermisoVenta() + ";" + pieza.getValorFijo() + ";" + pieza.getValorMinimoSubasta()  + ";" + login  + ";" + contrasena + ";" + correo  + ";" + numero  + ";" + pieza.getEstadoDePieza()+
					";" + pieza.getResolucion() + ";" + pieza.getTecnica() + ";" + pieza.getAncho() + ";" + pieza.getAlto() +"\n";
				}
				bw.write(textos);
	            bw.close();
	        } catch (IOException e) {

	            e.printStackTrace();
	        }

	    }
	 public void almacenarImpresiones() {
		 try (
	                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
	                		"../proyecto/src/data/Piezas.txt")))) {
	            String textos = "";

				for(Impresion pieza : impresiones.values()) {
					String login =  (pieza.getPropietario()).getLogin() ;
					String contrasena =  (pieza.getPropietario()).getContrasena() ;
					String correo =  (pieza.getPropietario()).getCorreoElectronico() ;
					int numero =  (pieza.getPropietario()).getNumeroDeTelefono() ;
					String tipo = pieza.getTipo();
					textos += tipo + ";" + pieza.getTitulo() + ";" + pieza.getAno() + ";" + pieza.getLugarCreacion() + ";" + pieza.getAutor()+ ";" + pieza.isExhibida() + ";" + pieza.isPermisoVenta() + ";" + pieza.getValorFijo() + ";" + pieza.getValorMinimoSubasta()  + ";" + login  + ";" + contrasena + ";" + correo  + ";" + numero  + ";" + pieza.getEstadoDePieza()+ ";" + pieza.getResolucion() + ";" + pieza.getTecnica() + ";" + pieza.getAncho() + ";" + pieza.getAlto() +"\n";
				 }
	            bw.write(textos);
	            bw.close();
	        } catch (IOException e) {

	            e.printStackTrace();
	        }

	    }

	 public void almacenarVideos() {
		 try (
	                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
	                		"../proyecto/src/data/Piezas.txt")))) {
	            String textos = "";
				for(Video pieza : this.videos.values()) {
					String login =  (pieza.getPropietario()).getLogin() ;
					String contrasena =  (pieza.getPropietario()).getContrasena() ;
					String correo =  (pieza.getPropietario()).getCorreoElectronico() ;
					int numero =  (pieza.getPropietario()).getNumeroDeTelefono() ;
					String tipo = pieza.getTipo();
					
					textos+= tipo + ";" + pieza.getTitulo() + ";" + pieza.getAno() + ";" + pieza.getLugarCreacion() + ";" + pieza.getAutor()+ ";" + pieza.isExhibida() + ";" 
				+ pieza.isPermisoVenta() + ";" + pieza.getValorFijo() + ";" + pieza.getValorMinimoSubasta()  + ";" + login  + ";" + contrasena + ";" + correo  + ";" + numero  + ";" + pieza.getEstadoDePieza()+
				";" + pieza.getDuracion() + ";" + pieza.getNecesidadElectricidad()  + "\n";
				}
				bw.write(textos);
	            bw.close();
	        } catch (IOException e) {

	            e.printStackTrace();
	        }

	    }
	 public void almacenarRegistros() {
		 try (
	                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
	                		"../proyecto/src/data/Registros.txt")))) {
	            String textos = "";
				for(Registro pieza : registros.values()) {
	                Date fecha = pieza.getFecha();
	                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Define el formato de fecha que deseas
	                String fechaString = sdf.format(fecha);
	                float monto= pieza.getMonto();
	                String login = pieza.getCliente().getLogin();
	                String contrasena= pieza.getCliente().getContrasena();
	                String correo= pieza.getCliente().getCorreoElectronico();
	                int numero= pieza.getCliente().getNumeroDeTelefono();
	                int valorMax = pieza.getCliente().getValorMax();
	                String titulo= pieza.getPieza().getTitulo();
	                String idSubasta= pieza.getSubasta().getId();
					
	                
					textos+= fechaString +";"+ monto + ";"+ login+";"+ contrasena+";"+correo +";"+ numero+ ";"+valorMax+";"+titulo+";"+idSubasta+"\n";
				}
				bw.write(textos);
	            bw.close();
	        } catch (IOException e) {

	            e.printStackTrace();
	        }

	    }
	 public void almacenarVentas() {
		 try (
	                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
	                		"../proyecto/src/data/Ventas.txt")))) {
	            String textos = "";
				for(Venta pieza : ventas.values()) {
					String titulo= pieza.getPieza().getTitulo();
	                String fecha=  pieza.getFechaVenta();
	                String login= "Nicolas";
					
					textos+= titulo+ ";"+ fecha+";"+login+"\n";
				}
				bw.write(textos);
	            bw.close();
	        } catch (IOException e) {

	            e.printStackTrace();
	        }

	    }
		 
	 public void almacenarSubastas() {
		 try (
	                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
	                		"../proyecto/src/data/Subastas.txt")))) {
	            String textos = "";
				for(Subasta pieza : subastas.values()) {
					String id = pieza.getId();
	                Date fechaInicial= pieza.getFechaInicial();
	                Date fechaFinal = pieza.getFechaFinal();
	                String titulo= pieza.getPieza().getTitulo();
					
					textos+= id + ";"+ fechaInicial+";"+fechaFinal+";"+ titulo +"\n";
				}
				bw.write(textos);
	            bw.close();
	        } catch (IOException e) {

	            e.printStackTrace();
	        }

	    }



}
