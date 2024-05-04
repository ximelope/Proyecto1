package Presentacion;
import modeloGaleria.Galeria;
import modeloGaleria.Impresion;
import modeloGaleria.Pieza;
import modeloGaleria.Pintura;
import modeloGaleria.Video;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import modeloGaleria.Administrador;
import modeloGaleria.Escultura;
import modeloGaleria.Fotografia;

public class InterfazAdministrador {
	Galeria galeria = new Galeria();
	public void mostrarMenuId() {
		System.out.println("1.) Registrarse");
		System.out.println("2.) Salir ");
	}
	public void ejecutar() {

		mostrarMenuId();
		galeria.cargarInformacion();

		int opcion = Integer.parseInt(input("\nSeleccione una opcion"));
		while (true) {
			if (opcion == 1) {
				String usuario = input("Ingresa usuario");
				String contrasena = input("Ingresa contrasena");
				boolean result = galeria.login(usuario, contrasena);
				if (result == true) {
					infoAdmin(usuario, contrasena);
					
				}
			} else if (opcion == 2) {
				System.out.println("Saliendo de la app...");
				System.out.print("\033[H\033[2J");
				System.out.flush();
				break;
			} else {
				System.out.println("Seleccione una opcion valida, por favor");
				System.out.print("\033[H\033[2J");
				System.out.flush();

			}
			System.out.print("\033[H\033[2J");
			mostrarMenuId();
			opcion = Integer.parseInt(input("\nSeleccione una opcion"));
			System.out.flush();
		}
	}
	public void infoAdmin(String usuario, String contrasena) { 
        int opcion;
        Administrador admin = new Administrador(usuario, contrasena);
        galeria.setAdministrador(admin);
        HashMap<String, Pieza> piezas = galeria.getPiezas();
        HashMap<String, Escultura> esculturas = galeria.getEsculturas();
        HashMap<String, Pintura> pinturas= galeria.getPinturas();
        HashMap<String, Fotografia> fotografias = galeria.getFotografias();
        HashMap<String, Video> videos = galeria.getVideos();
        HashMap<String, Impresion> impresiones = galeria.getImpresiones();
        
        do {
            System.out.println("Opciones Administrador");
            System.out.println("1.) Crear Pieza y añadir al inventario");
            System.out.println("2.) Mostrar los titulos que se encuentran en el inventario");
            System.out.println("3.) Mostrar la historia de una pieza");
            System.out.println("4.) Mostrar la historia de un artista");
            System.out.println("5.) Mostrar la historia de un comprador");
            System.out.println("6.) Cerrar Sesión ");
            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
            if (opcion == 2)
            {
            	System.out.println(piezas.keySet());
            } else if (opcion == 1) {
                admin.pedir_crearPieza(piezas,  esculturas,pinturas, fotografias, videos, impresiones);
                }
            else if (opcion == 3) {
            	System.out.println(piezas.keySet());
            	
                
            } else if (opcion == 6) {
                almacenarEsculturas(esculturas);
                almacenarPinturas(pinturas);
                almacenarFotografias(fotografias);
                almacenarImpresiones(impresiones);
                almacenarVideos(videos);
                
            } else {
                System.out.println("Opcion Inválida");
            }
        } while (opcion != 6);
    }

	public String input(String mensaje) {
		try {
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	public static void main(String[] args) {
		{
			InterfazAdministrador consola = new InterfazAdministrador();
			consola.ejecutar();
		}
	}
	public void almacenarEsculturas(HashMap<String, Escultura> esculturas) {
		 try (
	                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
	                		"./src/data/Piezas.txt")))) {
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
	 public void almacenarPinturas(HashMap<String, Pintura> pinturas) {
		 try (
	                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
	                		"./src/data/Piezas.txt")))) {
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
	 public void almacenarFotografias(HashMap<String, Fotografia> fotografias) {
		 try (
	                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
	                		"./src/data/Piezas.txt")))) {
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
	 public void almacenarImpresiones(HashMap<String, Impresion> impresiones) {
		 try (
	                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
	                		"./src/data/Piezas.txt")))) {
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

	 public void almacenarVideos(HashMap<String, Video> videos) {
		 try (
	                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
	                		"./src/data/Piezas.txt")))) {
	            String textos = "";
				for(Video pieza : videos.values()) {
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
}

