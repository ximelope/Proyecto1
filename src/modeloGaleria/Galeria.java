package modeloGaleria;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Galeria {
	protected HashMap<String, Escultura> esculturas = new HashMap<>();
	protected HashMap<String, Pintura> pinturas = new HashMap<>();
	protected HashMap<String, Video> videos  = new HashMap<>();
	protected HashMap<String, Fotografia> fotografias = new HashMap<>();
	protected HashMap<String, Impresion> impresiones = new HashMap<>();
	protected HashMap<String, Pieza> piezas = new HashMap<>();
	protected HashMap<String, Subasta> subastas = new HashMap<>();
	protected HashMap<String, String> usuarios = new HashMap<>();
	
	 public void cargarInformacion() {
	        try {

	            cargarUsuarios();

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
	 public void infoAdmin(String usuario, String contrasena) {
	        String opcion;
	        Administrador admin = new Administrador(usuario, contrasena);
	        do {
	            System.out.println("Opciones Administrador");
	            System.out.println("1.) Cargar Piezas al inventario ");
	            System.out.println("2.) Crear Pieza y añadir al inventario");
	            System.out.println("3.) Cerrar Sesión ");
	            System.out.println("3.) Cerrar Sesión ");
	            System.out.println("hiululg");
	            opcion = input("\nSeleccione una opcion");
	            if (opcion == "1") {
	            	System.out.println(opcion);
	                File archivoPiezas = new File(
	                		"../proyecto/src/data/Piezas.txt");
	                admin.cargarPieza(archivoPiezas,piezas,  esculturas,pinturas, fotografias, videos, impresiones );
	                System.out.println(opcion);
	            } else if (opcion == "2") {
	            	System.out.println(opcion);
	                admin.pedir_crearPieza(piezas,  esculturas,pinturas, fotografias, videos, impresiones);
	                
	            } else if (opcion == "3") {
	                almacenarEsculturas();
	                almacenarPinturas();
	                almacenarFotografias();
	                almacenarImpresiones();
	                almacenarVideos();
	                
	            } else {
	                System.out.println("Opcion Inválida");
	            }
	        } while (opcion != "3");
	    }
	 public void infoOperador(String usuario, String contrasena) {
	        int opcion;
	        Adelantando operador = new Adelantando(usuario, contrasena);
	        do {
	            System.out.println("Opciones Cajero");
	            System.out.println("1.) Cargar Subasta");
	            System.out.println("2.) Crear Subasta");
	            System.out.println("3.) Cargar Registros ");
	            System.out.println("4.) Crear Registros ");
	            System.out.println("5.) Cerrar Sesión ");
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
	                operador.cargarSubastas(archivoRegistros,piezas, subastas);
	            } else {
	                System.out.println("Opcion Inválida");
	            }
	        } while (opcion != 5);
	    }
	 public void infoCajero(String usuario, String contrasena) {
	        int opcion;
	        //Cajero admin = new Cajero(usuario, contrasena);
	        do {
	            System.out.println("Opciones Administrador");
	            System.out.println("1.) Cargar Piezas al inventario ");
	            System.out.println("2.) Crear Pieza y añadir al inventario");
	            System.out.println("3.) Cerrar Sesión ");
	            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
	            
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
