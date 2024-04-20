package modeloGaleria;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Galeria {
	private HashMap<String, Escultura> esculturas = new HashMap<>();
	private HashMap<String, Pintura> pinturas = new HashMap<>();
	private HashMap<String, Video> videos  = new HashMap<>();
	private HashMap<String, Fotografia> fotografias = new HashMap<>();
	private HashMap<String, Impresion> impresiones = new HashMap<>();
	private Administrador administrador;
	public HashMap<String, String> usuarios = new HashMap<>();
	
	 public void cargarInformacion() {
	        try {

	            cargarUsuarios();

	            cargarTarifa(new File(
	                    "../proyecto1/entrega3/proyecto1_hotel/data/tarifa.txt"), tarifasEstandar);
	            cargarTarifa(new File(
	                    "../proyecto1/entrega3/proyecto1_hotel/data/tarifa2.txt"), tarifasSuite);
	            cargarTarifa(new File(
	                    "../proyecto1/entrega3/proyecto1_hotel/data/tarifa3.txt"), tarifasSuite2);

	            cargarHabitaciones();

	            cargarPlatos();

	            cargarHuespedes();

	            cargarGrupos();

	            cargarReservas();

	            cargarServicios();

	            cargarConsumos();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	
	public void login(String usuario, String contrasena, String rol) {

        System.out.println(usuarios.get(usuario));
        if (contrasena.equals(usuarios.get(usuario))) {
            if (rol=="Administrador") {
                infoAdmin(usuario, contrasena);
            } else if (rol=="Operador") {
                infoOperador(usuario, contrasena);
            } else {
                infoCajero(usuario, contrasena);
            }
        } else {
            System.out.println("Usuario o contraseña incorrecta");
        }

    }
	 private void infoAdmin(String usuario, String contrasena) {
	        int opcion;
	        Administrador admin = new Administrador(usuario, contrasena);
	        do {
	            System.out.println("Opciones Administrador");
	            System.out.println("1.) Cargar Piezas al inventario ");
	            System.out.println("2.) Crear Pieza y añadir al inventario");
	            System.out.println("3.) Cerrar Sesión ");
	            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
	            if (opcion == 1) {
	                File archivoPiezas = new File(
	                        "../proyecto1/entrega3/proyecto1_hotel/data/habitaciones2.txt");
	                admin.cargarPieza(archivoPiezas, esculturas,pinturas, fotografias, videos, impresiones );
	            } else if (opcion == 2) {
	                admin.pedir_crearPieza();
	                
	            } else if (opcion == 3) {
	                logOut();
	            } else {
	                System.out.println("Opcion Inválida");
	            }
	        } while (opcion != 3);
	    }
	 private void infoOperador(String usuario, String contrasena) {
	        int opcion;
	        Operador operador = new Operador(usuario, contrasena);
	        do {
	            System.out.println("Opciones Cajero");
	            System.out.println("1.) Cargar Registros de subasta");
	            System.out.println("2.) Crear Registros de subasta");
	            System.out.println("3.) Cerrar Sesión ");
	            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
	            if (opcion == 1) {
	                File archivoRegistros = new File(
	                        "../proyecto1/entrega3/proyecto1_hotel/data/habitaciones2.txt");
	                admin.cargarPieza(archivoPiezas);
	            } else if (opcion == 2) {
	                admin.pedir_crearPieza();
	                
	            } else if (opcion == 3) {
	                logOut();
	            } else {
	                System.out.println("Opcion Inválida");
	            }
	        } while (opcion != 3);
	    }
	 private void infoCajero(String usuario, String contrasena) {
	        int opcion;
	        Cajero admin = new Cajero(usuario, contrasena);
	        do {
	            System.out.println("Opciones Administrador");
	            System.out.println("1.) Cargar Piezas al inventario ");
	            System.out.println("2.) Crear Pieza y añadir al inventario");
	            System.out.println("3.) Cerrar Sesión ");
	            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
	            if (opcion == 1) {
	                File archivoPiezas = new File(
	                        "../proyecto1/entrega3/proyecto1_hotel/data/habitaciones2.txt");
	                admin.cargarPieza(archivoPiezas);
	            } else if (opcion == 2) {
	                admin.pedir_crearPieza();
	                
	            } else if (opcion == 3) {
	                logOut();
	            } else {
	                System.out.println("Opcion Inválida");
	            }
	        } while (opcion != 3);
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
	                    "../proyecto1/entrega3/proyecto1_hotel/data/database.txt")));
	            String linea;
	            linea = br.readLine();
	            while (linea != null) {
	                String[] partes = linea.split(";");
	                String usuario = partes[0];
	                String contrasena = partes[1];

	                usuarios.put(usuario, contrasena);

	                linea = br.readLine();
	            }
	            br.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 public void almacenarEsculturas() {
			ArrayList<String> textos = new ArrayList<String>();
			for(Escultura pieza : this.esculturas.values()) {
				String login =  (pieza.getPropietario()).getLogin() ;
				String contrasena =  (pieza.getPropietario()).getContrasena() ;
				String correo =  (pieza.getPropietario()).getCorreoElectronico() ;
				int numero =  (pieza.getPropietario()).getNumeroDeTelefono() ;
				String tipo = pieza.getTipo();
				
				textos.add(tipo + "," + pieza.getTitulo() + "," + pieza.getAno() + "," + pieza.getLugarCreacion() + "," + pieza.getAutor()+ "," + pieza.isExhibida() + "," 
			+ pieza.isPermisoVenta() + "," + pieza.getValorFijo() + "," + pieza.getValorMinimoSubasta()  + "," + login  + "," + contrasena + "," + correo  + "," + numero  + "," + pieza.getEstadoDePieza()+
			"," + pieza.getAlto() + "," + pieza.getAncho() + "," + pieza.getProfundidad() + "," + pieza.getMaterialEscultura() + "," + pieza.getPeso() + "," + pieza.getNecesidadElectricidad()+ "," + pieza.getDetallesInstalacion()+"\n");
			}
			almacenar("piezas.csv", textos);
		}
	 public void almacenarPinturas() {
			ArrayList<String> textos = new ArrayList<String>();
			for(Pintura pieza : this.pinturas.values()) {
				String login =  (pieza.getPropietario()).getLogin() ;
				String contrasena =  (pieza.getPropietario()).getContrasena() ;
				String correo =  (pieza.getPropietario()).getCorreoElectronico() ;
				int numero =  (pieza.getPropietario()).getNumeroDeTelefono() ;
				String tipo = pieza.getTipo();
				
				textos.add(tipo + "," + pieza.getTitulo() + "," + pieza.getAno() + "," + pieza.getLugarCreacion() + "," + pieza.getAutor()+ "," + pieza.isExhibida() + "," 
			+ pieza.isPermisoVenta() + "," + pieza.getValorFijo() + "," + pieza.getValorMinimoSubasta()  + "," + login  + "," + contrasena + "," + correo  + "," + numero  + "," + pieza.getEstadoDePieza()+
			"," + pieza.getAlto() + "," + pieza.getAncho() + "," + pieza.getMaterialBase() + "," + pieza.getTipoPinturas() +"\n");
			}
			almacenar("piezas.csv", textos);
		}
	 public void almacenarFotografias() {
			ArrayList<String> textos = new ArrayList<String>();
			for(Fotografia pieza : this.fotografias.values()) {
				String login =  (pieza.getPropietario()).getLogin() ;
				String contrasena =  (pieza.getPropietario()).getContrasena() ;
				String correo =  (pieza.getPropietario()).getCorreoElectronico() ;
				int numero =  (pieza.getPropietario()).getNumeroDeTelefono() ;
				String tipo = pieza.getTipo();
				
				textos.add(tipo + "," + pieza.getTitulo() + "," + pieza.getAno() + "," + pieza.getLugarCreacion() + "," + pieza.getAutor()+ "," + pieza.isExhibida() + "," 
			+ pieza.isPermisoVenta() + "," + pieza.getValorFijo() + "," + pieza.getValorMinimoSubasta()  + "," + login  + "," + contrasena + "," + correo  + "," + numero  + "," + pieza.getEstadoDePieza()+
			"," + pieza.getResolucion() + "," + pieza.getTecnica() + "," + pieza.getAncho() + "," + pieza.getAlto() +"\n");
			}
			almacenar("piezas.csv", textos);
		}
	 public void almacenarImpresiones() {
			ArrayList<String> textos = new ArrayList<String>();
			for(Impresion pieza : this.impresiones.values()) {
				String login =  (pieza.getPropietario()).getLogin() ;
				String contrasena =  (pieza.getPropietario()).getContrasena() ;
				String correo =  (pieza.getPropietario()).getCorreoElectronico() ;
				int numero =  (pieza.getPropietario()).getNumeroDeTelefono() ;
				String tipo = pieza.getTipo();
				
				textos.add(tipo + "," + pieza.getTitulo() + "," + pieza.getAno() + "," + pieza.getLugarCreacion() + "," + pieza.getAutor()+ "," + pieza.isExhibida() + "," 
			+ pieza.isPermisoVenta() + "," + pieza.getValorFijo() + "," + pieza.getValorMinimoSubasta()  + "," + login  + "," + contrasena + "," + correo  + "," + numero  + "," + pieza.getEstadoDePieza()+
			"," + pieza.getResolucion() + "," + pieza.getTecnica() + "," + pieza.getAncho() + "," + pieza.getAlto() +"\n");
			}
			almacenar("piezas.csv", textos);
	 }
	 public void almacenarVideos() {
			ArrayList<String> textos = new ArrayList<String>();
			for(Video pieza : this.videos.values()) {
				String login =  (pieza.getPropietario()).getLogin() ;
				String contrasena =  (pieza.getPropietario()).getContrasena() ;
				String correo =  (pieza.getPropietario()).getCorreoElectronico() ;
				int numero =  (pieza.getPropietario()).getNumeroDeTelefono() ;
				String tipo = pieza.getTipo();
				
				textos.add(tipo + "," + pieza.getTitulo() + "," + pieza.getAno() + "," + pieza.getLugarCreacion() + "," + pieza.getAutor()+ "," + pieza.isExhibida() + "," 
			+ pieza.isPermisoVenta() + "," + pieza.getValorFijo() + "," + pieza.getValorMinimoSubasta()  + "," + login  + "," + contrasena + "," + correo  + "," + numero  + "," + pieza.getEstadoDePieza()+
			"," + pieza.getDuracion() + "," + pieza.getNecesidadElectricidad()  + "\n");
			}
			almacenar("piezas.csv", textos);
	 }
		
	 public static void almacenar(String archivo, ArrayList<String> textos) {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File(archivo)));
				for(String texto : textos) {
					bw.write(texto);
				}
				bw.close();			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	

}
