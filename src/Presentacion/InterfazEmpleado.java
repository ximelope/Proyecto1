package Presentacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import modeloGaleria.Administrador;
import modeloGaleria.Artista;
import modeloGaleria.Cajero;
import modeloGaleria.Comprador;
import modeloGaleria.Galeria;
import modeloGaleria.Operador;
import modeloGaleria.Pieza;
import modeloGaleria.Registro;
import modeloGaleria.Subasta;
import modeloGaleria.Venta;

public class InterfazEmpleado {
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
					infoEmpleado(usuario, contrasena);
				}else {	
					System.out.println("Usuario o contraseña incorrecta");
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

	public void infoEmpleado(String usuario, String contrasena){
		int opcion= 0;
		do {
			System.out.println("Como empleado puede ser Operador o cajero ");
			System.out.println("1.) Cajero");
			System.out.println("2.) Operador");
			System.out.println("3.) Salir");
			opcion = Integer.parseInt(input("\nSeleccione una opcion"));
			if (opcion==1) {
				infoCajero(usuario,contrasena);
			}
			else if (opcion== 2) {
				infoOperador(usuario,contrasena);
			
			} else if (opcion == 3) {
            System.out.println("Saliendo del menú de empleado...");
			} else {
            System.out.println("Opcion Inválida");
			}
		}while (opcion != 3);
	}
	public void infoOperador(String usuario, String contrasena) {
        int opcion;
        Operador operador = new Operador(usuario, contrasena);
        HashMap<String, Pieza> piezas = galeria.getPiezas();
        HashMap<String, Subasta> subastas = galeria.getSubastas();
        HashMap<String, Registro> registros  = galeria.getRegistros();
        HashMap<String, Comprador> clientes = galeria.getClientes();
        HashMap<String, Artista> artistas = galeria.getArtistas();
        Administrador administrador = galeria.getAdministrador();
        File subasta = new File("./src/data/Subastas.txt");
        operador.cargarSubastas(subasta, piezas, subastas);
        File registro = new File("./src/data/Registros.txt");
        operador.cargarRegistros(registro, piezas,registros, clientes, administrador);
        
        do {
            System.out.println("Opciones Operador");
            System.out.println("1.) Crear Subasta");
            System.out.println("2.) Crear Registros ");
            System.out.println("3.) Cerrar Subasta (mostar el nuevo dueño) ");
            System.out.println("4.) Mostrar la historia de una pieza");
            System.out.println("5.) Mostrar la historia de un artista");
            System.out.println("6.) Cerrar Sesión ");
            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
            if (opcion == 1) {
            	operador.crearSubasta_pedir(piezas, subastas);
            } else if (opcion == 2) {
            	operador.crearRegistro_pedir(piezas, registros, clientes, administrador);
                
            } else if (opcion == 3) {
            	String id = input("Ingrese el id de la subasta a finalizar(00aa, 00bb)");
            	System.out.println(operador.ganador(id));
            }else if (opcion == 4) {
            	String nombre = input("Ingrese el nombre de la pieza de la que quiere saber la historia: ");
            	Pieza pieza= piezas.get(nombre);
            	operador.historiaDePieza(pieza);
     
            }else if (opcion == 5) {
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
            	
            }else if (opcion == 6) {
                operador.almacenarRegistros(registros);
                operador.almacenarSubastas(subastas);
            } else {
                System.out.println("Opcion Inválida");
            }
        }while (opcion != 6);
    }
	public void infoCajero(String usuario, String contrasena) {
        int opcion;
        Cajero admin = new Cajero(usuario, contrasena);
        HashMap<String, Comprador> clientes = galeria.getClientes();
        HashMap<String, Venta> ventas = galeria.getVentas();
        HashMap<String, Pieza> piezas = galeria.getPiezas();
        HashMap<String, Artista> artistas = galeria.getArtistas();
        do {
            System.out.println("Opciones Cajero");
            System.out.println("1.) Crear Venta");
            System.out.println("2.) Confirmar pago-Dar factura ");
            System.out.println("3.) Mostrar la historia de una pieza");
            System.out.println("4.) Mostrar la historia de un artista");
            System.out.println("5.) Cerrar sesión ");
            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
            if (opcion == 1) {
            	admin.pedirVenta(piezas, clientes, ventas);
            } else if (opcion == 2) {
            	String titulo= input("Ingrese el titulo de la pieza: ");
                int factura = admin.darFactura(titulo,ventas);
                System.out.println("La factura es: " + factura);
                
            } else if (opcion == 3) {
            	String nombre = input("Ingrese el titulo de la obra");
            	Pieza pieza = piezas.get(nombre);
            	admin.historiaDePieza(pieza);
            
            } else if (opcion == 4) {
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
            }else if (opcion == 5) {
                admin.almacenarVentas(ventas);
            } else {
                System.out.println("Opcion Inválida");
            }
        } while (opcion != 5);
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
    public static void main(String[] args)  {
		InterfazEmpleado consola = new InterfazEmpleado();
		consola.ejecutar();
		
	}
 
}

