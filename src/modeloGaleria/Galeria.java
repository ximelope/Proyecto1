package modeloGaleria;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Galeria {
	private HashMap<String, Escultura> esculturas = new HashMap<>();
	private HashMap<String, Pintura> pinturas = new HashMap<>();
	private HashMap<String, Video> videos  = new HashMap<>();
	private HashMap<String, Fotografia> fotografias = new HashMap<>();
	private HashMap<String, Impresion> impresiones = new HashMap<>();
	private static HashMap<String, Pieza> piezas = new HashMap<>();
	private HashMap<String, Subasta> subastas = new HashMap<>();
	private HashMap<String, Registro> registros = new HashMap<>();
	private HashMap<String, String> usuarios = new HashMap<>();
	private HashMap<String, Comprador> clientes = new HashMap<>();
	private HashMap<String, Venta> ventas = new HashMap<>();
	private HashMap<String, Artista> artistas = new HashMap<>();
	private HashMap<String, Propietario> propietarios = new HashMap<>();
	private  Administrador administrador;
	
	public HashMap<String, Escultura> getEsculturas() {
		return esculturas;
	}
	public HashMap<String, Pintura> getPinturas() {
		return pinturas;
	}
	public HashMap<String, Video> getVideos() {
		return videos;
	}
	public HashMap<String, Fotografia> getFotografias() {
		return fotografias;
	}
	public HashMap<String, Impresion> getImpresiones() {
		return impresiones;
	}
	public static HashMap<String, Pieza> getPiezas() {
		return piezas;
	}
	public HashMap<String, Subasta> getSubastas() {
		return subastas;
	}
	public HashMap<String, Registro> getRegistros() {
		return registros;
	}
	public HashMap<String, String> getUsuarios() {
		return usuarios;
	}
	public HashMap<String, Comprador> getClientes() {
		return clientes;
	}
	public HashMap<String, Venta> getVentas() {
		return ventas;
	}
	public HashMap<String, Propietario> getPropietarios() {
		return propietarios;
	}
	public Administrador getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador= administrador;
	}
	public HashMap<String, Artista> getArtistas() {
		return artistas;
	}
	
	 public void cargarInformacion() {
	        try {

	            cargarUsuarios();
	            cargarPieza();
	            cargarPropietario();
	            cargarComprador();
	            cargarArtista();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	 public void cargarPropietario() {
		 File archivo = new File(
	         		"../proyecto/src/data/Propietario.txt");
		 System.out.println("Cargando propietarios desde Archivo");
		 try {
	            BufferedReader br = new BufferedReader(new FileReader(archivo));
	            String linea;
	            linea = br.readLine();
	            while (linea != null) {
	                String[] partes = linea.split(";");
	                String login = partes[0];
	                String contrasena = partes[1];
	                String correo = partes[2];
	                int numeroDeTelefono= Integer.valueOf(partes[3]);
	                Propietario propietario = crearPropietario(login,contrasena,correo, numeroDeTelefono);
	                propietarios.put(login,propietario);
	            }

                linea = br.readLine();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
	 public void cargarComprador() {
		 File archivo = new File(
	         		"../proyecto/src/data/Comprador.txt");
		 System.out.println("Cargando compradores desde Archivo");
		 try {
	            BufferedReader br = new BufferedReader(new FileReader(archivo));
	            String linea;
	            linea = br.readLine();
	            while (linea != null) {
	                String[] partes = linea.split(";");
	                String login = partes[0];
	                String contrasena = partes[1];
	                String correo = partes[2];
	                int numeroDeTelefono= Integer.valueOf(partes[3]);
	                int valorMax = Integer.valueOf(partes[4]);
	                Comprador comprador = crearComprador(login,contrasena,correo, numeroDeTelefono, valorMax);
	                clientes.put(login,comprador);
	            }

                linea = br.readLine();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
	 
	 public void cargarArtista() {
		 File archivo = new File(
	         		"../proyecto/src/data/Artista.txt");
		 System.out.println("Cargando artistas desde Archivo");
		 try {
	            BufferedReader br = new BufferedReader(new FileReader(archivo));
	            String linea;
	            linea = br.readLine();
	            while (linea != null) {
	                String[] partes = linea.split(";");
	                String nombre = partes[0];
	                String piezas = partes[1];
	                Artista artista = crearArtista(nombre, piezas);
	                artistas.put(nombre,artista);
	            }

                linea = br.readLine();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
		 
	 public  void cargarPieza() {
		    File archivo = new File(
         		"../proyecto/src/data/Piezas.txt");
	        System.out.println("Cargando piezas desde Archivo");
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(archivo));
	            String linea;
	            linea = br.readLine();
	            while (linea != null) {
	                String[] partes = linea.split(";");
	                String tipo = partes[0];
	                String titulo = partes[1];
	                if (piezas.get(titulo)== null) {
	                	int ano= Integer.valueOf(partes[2]);
	                    String lugarCreacion = partes[3];
	                    String autor = partes[4];
	                    boolean exhibida = Boolean.valueOf(partes[5]);
	                    boolean permisoVenta = Boolean.valueOf(partes[6]);
	                    int valorFijo= Integer.valueOf(partes[7]);
	                    int valorMinimoSubasta = Integer.valueOf(partes[8]);
	                    String loginPropietario= partes[9];
	                    String contrasenaPropietario = partes[10];
	                    String correo = partes[11];
	                    int numeroDeTelefono= Integer.valueOf(partes[12]);
	                    
	                    if (tipo.equals("Escultura")) {
	                    	float alto = Float.parseFloat(partes[14]);
	                    	float ancho = Float.parseFloat(partes[15]);
	                    	float profundidad = Float.parseFloat(partes[16]);
	                    	String materialEscultura = partes[17];
	                    	float peso = Float.parseFloat(partes[18]);
	                    	boolean necesidadElectricidad = Boolean.valueOf(partes[19]);
	                    	String detallesInstalacion = partes [20];
	                    	Pieza pieza= crearPiezaEscultura(esculturas, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
	                    			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,alto,ancho, profundidad, materialEscultura, peso, necesidadElectricidad, detallesInstalacion);
	                    	añadirPieza(pieza, piezas);
	                    	
	                    } else if (tipo.equals("Pintura")) {
	                    	float alto = Float.parseFloat(partes[14]);
	                    	float ancho = Float.parseFloat(partes[15]);
	                    	String materialBase = partes[16];
	                    	String tipoPintura = partes[17];
	                    	Pieza pieza = crearPiezaPintura(pinturas, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,alto,ancho, materialBase, tipoPintura);
	                    	añadirPieza(pieza, piezas);

	                    }else if (tipo.equals("Video")) {
	                    	float duracion = Float.parseFloat(partes[14]);
	                    	boolean necesidadElectricidad = Boolean.valueOf(partes[15]);
	                    	Pieza pieza = crearPiezaVideo(videos, tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
	                    			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,duracion,necesidadElectricidad);
	                    	añadirPieza(pieza, piezas);

	                    }else if (tipo.equals("Fotografia")) {
	                    	float resolucion = Float.parseFloat(partes[14]);
	                    	String tecnica = partes[15];
	                    	float ancho = Float.parseFloat(partes[16]);
	                    	float alto = Float.parseFloat(partes[17]);
	                    	Pieza pieza= crearPiezaFotografia(fotografias,tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
	                    			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,resolucion, tecnica, ancho, alto);
	                    	añadirPieza(pieza, piezas);
	                    }else if (tipo.equals("Impresion")) {
	                    	float resolucion = Float.parseFloat(partes[14]);
	                    	String tecnica = partes[15];
	                    	float ancho = Float.parseFloat(partes[16]);
	                    	float alto = Float.parseFloat(partes[17]);
	                    	Pieza pieza= crearPiezaImpresion( impresiones,tipo, titulo,ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta,
	                    			loginPropietario, contrasenaPropietario, correo, numeroDeTelefono,resolucion, tecnica, ancho, alto);
	                    	añadirPieza(pieza, piezas);
	                    }
	                }

	                linea = br.readLine();
	            }
	            br.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	    }
	 
	 protected Pieza crearPiezaEscultura(HashMap<String, Escultura> esculturas, String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
				int valorFijo, int valorMinimoSubasta, String loginPropietario, String contraseñaPropietario,
				String correo, int numeroDeTelefono, float alto, float ancho, float profundidad, String material, float peso, boolean electricidad, 
				String otros) {
			Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
			Pieza pieza= new Escultura(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,
					valorFijo, valorMinimoSubasta, propietario,  alto, ancho, profundidad, material, peso, electricidad, otros);
			Escultura pie= new Escultura(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,
					valorFijo, valorMinimoSubasta, propietario,  alto, ancho, profundidad, material, peso, electricidad, otros);
			
			
			esculturas.put(pie.getTitulo(), pie);
			return(pieza);
			}
			
		protected Pieza crearPiezaPintura(HashMap<String, Pintura> pinturas,String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
				int  valorFijo, int valorMinimoSubasta, String loginPropietario, String contraseñaPropietario,
				String correo, int numeroDeTelefono, float alto, float ancho, String materialBase, String tipoPinturas) {
			Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
			Pieza pieza = new Pintura(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, alto, ancho, materialBase,
					tipoPinturas);
			Pintura pintura = new Pintura(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario,alto, ancho, materialBase,
					tipoPinturas);
			pinturas.put(pintura.getTitulo(), pintura);
			return pieza;
			
		}
		protected Pieza crearPiezaVideo(HashMap<String, Video> videos,String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
				int valorFijo, int valorMinimoSubasta, String loginPropietario, String contraseñaPropietario,
				String correo, int numeroDeTelefono, float duracion, boolean necesidadElectricidad) {
			Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
			Pieza pieza = new Video(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, duracion, necesidadElectricidad);
			Video pie = new Video(tipo,titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, duracion, necesidadElectricidad);
			videos.put(pie.getTitulo(), pie);
			return pieza;
			
		}
		protected Pieza crearPiezaFotografia(HashMap<String, Fotografia> fotografias,String tipo, String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
				int valorFijo, int valorMinimoSubasta, String loginPropietario, String contraseñaPropietario,
				String correo, int numeroDeTelefono, float resolucion,String metodo, float ancho, float alto) {
			Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
			Pieza pieza = new Fotografia(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, resolucion, metodo, ancho,alto);
			Fotografia pie = new Fotografia(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, resolucion, metodo, ancho,alto);
			fotografias.put(pie.getTitulo(), pie);
			return pieza;

			
		}
		protected Pieza crearPiezaImpresion(HashMap<String, Impresion> impresiones,String tipo, String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
				int valorFijo, int valorMinimoSubasta, String loginPropietario, String contraseñaPropietario,
				String correo, int numeroDeTelefono, float resolucion,String metodo, float ancho, float alto) {
			Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
			Pieza pieza = new Impresion(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, resolucion, metodo, ancho,alto);
			Impresion pie = new Impresion(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario, resolucion, metodo, ancho,alto);
			impresiones.put(pie.getTitulo(), pie);
			return pieza;
		}
				
		private Propietario crearPropietario(String loginPropietario, String contraseñaPropietario,
				String correo, int numeroDeTelefono) {
			Propietario propietario = new Propietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
			return propietario;
		}
		private Comprador crearComprador (String loginPropietario, String contraseñaPropietario, String correo, int numeroDeTelefono, int valorMax) {
			Comprador comprador = new Comprador(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono, valorMax);
			return comprador;
		}
		
		private Artista crearArtista (String nombre, String piezas) {
			Artista artista = new Artista(nombre, piezas);
			return artista;
		}
		
		private void añadirPieza (Pieza pieza,HashMap<String, Pieza> piezas) {
			piezas.put(pieza.getTitulo(), pieza);
			
		}

	public boolean login(String usuario, String contrasena) {

        if (contrasena.equals(usuarios.get(usuario))) {
            return true;
        } else {
            System.out.println("Usuario o contraseña incorrecta");
            return false;
        }

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
	                        "./src/data/Subastas.txt");
	                operador.cargarSubastas(archivoSubastas,piezas, subastas);
	            } else if (opcion == 2) {
	                operador.crearSubasta_pedir(piezas, subastas);
	                
	            } else if (opcion == 3) {
	            	File archivoRegistros= new File(
	                        "./src/data/Registros.txt");
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
	                        "./src/data/Ventas.txt");
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
	                    "./src/data/Usuarios.txt")));
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
	 
	 public void almacenarRegistros() {
		 try (
	                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
	                		"./src/data/Registros.txt")))) {
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
	                		"./src/data/Ventas.txt")))) {
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
	 public void almacenarPropietarios() {
		 try (
	                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
	                		"./src/data/Propietarios.txt")))) {
	            String textos = "";
				for(Propietario propietario : propietarios.values()) {
					String login= propietario.getLogin();
	                String contrasena=  propietario.getContrasena();
	                String correo = propietario.getCorreoElectronico();
	                int numero= propietario.getNumeroDeTelefono();
					
					textos+= login+ ";"+ contrasena+";"+correo+";"+ numero+"\n";
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
	                		"./src/data/Subastas.txt")))) {
	            String textos = "";
				for(Subasta pieza : subastas.values()) {
					String id = pieza.getId();
	                Date fechaInicial= pieza.getFechaInicial();
	                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	                String fecha= sdf.format(fechaInicial);
	      
	                Date fechaFinal = pieza.getFechaFinal();
	                String fechaF= sdf.format(fechaFinal);
	                String titulo= pieza.getPieza().getTitulo();
					
					textos+= id + ";"+ fecha+";"+fechaF+";"+ titulo +"\n";
				}
				bw.write(textos);
	            bw.close();
	        } catch (IOException e) {

	            e.printStackTrace();
	        }

	    }



}
