package Presentacion;
import modeloGaleria.Galeria;
import modeloGaleria.Pieza;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import modeloGaleria.Artista;
import modeloGaleria.Comprador;

public class InterfazComprador {
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
					infoComprador(usuario, contrasena);
					
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
	
	public void infoComprador(String usuario, String contraseña) {
		int opcion;
		Comprador comprador = galeria.getClientes().get(usuario);
		HashMap<String, Comprador> clientes = galeria.getClientes();
		HashMap<String, Artista> artistas = galeria.getArtistas();
		HashMap<String, Pieza> piezas = galeria.getPiezas();
		do {
	            System.out.println("Opciones Comprador");
	            System.out.println("1.) Mostrar la historia de una pieza");
	            System.out.println("2.) Mostrar la historia de un artista");
	            System.out.println("3.) Cerrar Sesión");
	            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
	            if (opcion == 1)
	            {
	            	//Ver si funciona
	            	String nombre = input("Ingrese el titulo de la obra");
	            	Pieza pieza = piezas.get(nombre);
	            	System.out.println("Los datos básicos de la pieza son: ");
	        		System.out.println("Tipo: "+ pieza.getTipo()+", Nombre: "+ pieza.getTitulo()+ ", Autor: " + pieza.getAutor()+ ", Año de creación: "+pieza.getAno()+ ", Lugar de creación: "+ pieza.getLugarCreacion()+ ", Propietario actual: " + pieza.getPropietario().getLogin()) ;
	        		
	        		String propie= pieza.getPropietarios();
	        		String[] partes = propie.split("-");
	        		System.out.println("Los dueños de esta pieza han sido: ");
	        		for (String parte : partes) {
	        		    System.out.println(parte);
	        		}
	        		System.out.println("Esta pieza ha sido vendida por : ");
	        		String precios= pieza.getPrecios();
	        		String[] precio = precios.split("-");
	        		for (String par : precio) {
	        		    System.out.println(par+ " pesos ");
	        		}
	        		System.out.println("Esta pieza ha sido vendida en estas fechas : ");
	        		String fechas= pieza.getFechasVendidas();
	        		String[] pre = fechas.split(",");
	        		for (String par : pre) {
	        		    System.out.println(par);
	        		}
	            } else if (opcion == 2) {
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
	             else {
	                System.out.println("Opcion Inválida");
	            }
	        } while (opcion != 3);
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

		}










