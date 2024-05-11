package Presentacion;
import modeloGaleria.Galeria;
import modeloGaleria.Impresion;
import modeloGaleria.Pieza;
import modeloGaleria.Pintura;
import modeloGaleria.Propietario;
import modeloGaleria.Video;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import modeloGaleria.Administrador;
import modeloGaleria.Artista;
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
        HashMap<String, Propietario> propietarios= galeria.getPropietarios();
        HashMap<String, Pieza> piezas = galeria.getPiezas();
        HashMap<String, Escultura> esculturas = galeria.getEsculturas();
        HashMap<String, Pintura> pinturas= galeria.getPinturas();
        HashMap<String, Fotografia> fotografias = galeria.getFotografias();
        HashMap<String, Video> videos = galeria.getVideos();
        HashMap<String, Impresion> impresiones = galeria.getImpresiones();
        HashMap<String, Artista> artistas = galeria.getArtistas();
        
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
                admin.pedir_crearPieza(propietarios, piezas,  esculturas,pinturas, fotografias, videos, impresiones);
                admin.almacenarEsculturas(esculturas);
                admin.almacenarPinturas(pinturas);
                admin.almacenarFotografias(fotografias);
                admin.almacenarImpresiones(impresiones);
                admin.almacenarVideos(videos);
                }
            else if (opcion == 3) {
            	String nombre = input("Ingrese el titulo de la obra");
            	Pieza pieza = piezas.get(nombre);
            	admin.historiaDePieza(pieza);
            	
                
            } 
            else if (opcion == 4) {
            	String nombre = input("Ingrese el nombre del artista");
            	Boolean verificarNombre = artistas.containsKey(nombre);
            	if (verificarNombre == true) {
            		Artista artista = artistas.get(nombre);
            		System.out.println("Artista: " + artista.getNombre());
            		System.out.println("Obras del artista: " + artista.getPiezasLista().size());
            		for (Pieza pieza: artista.getPiezasLista()) {
            			System.out.println("Pieza: " + pieza.getTitulo());
            			System.out.println("Año: " + pieza.getAno());
            			System.out.println("Valor de pieza: " );
						String [] precios = pieza.getPrecios().split("-");
						for (String precio: precios) {
							System.out.println(precio);
							}
						System.out.println("Fecha de venta: ");
						String [] fechas = pieza.getFechasVendidas().split("-");
						for (String fecha: fechas) {
							System.out.println(fecha);
							}
						}
            	}
            	else {
            		System.out.println("Este artista no se encuentra en la base de datos");
            	}
                
            }
            else if (opcion == 6) {
                admin.almacenarEsculturas(esculturas);
                admin.almacenarPinturas(pinturas);
                admin.almacenarFotografias(fotografias);
                admin.almacenarImpresiones(impresiones);
                admin.almacenarVideos(videos);
                
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
}

