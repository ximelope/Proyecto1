package Presentacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import modeloGaleria.Cajero;
import modeloGaleria.Galeria;
import modeloGaleria.Operador;
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
	public String input(String mensaje) {
		try {
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	public void infoEmpleado(String usuario, String contrasena){
		System.out.println("Como empleado puede ser Operador o cajero ");
		System.out.println("1.) Cajero");
		System.out.println("1.) Operador");
		int opcion = Integer.parseInt(input("\nSeleccione una opcion"));
		do {
			if (opcion==1) {
				infoCajero(usuario,contrasena);
			}
			else if (opcion== 2) {
				infoOperador(usuario,contrasena);
			}
			else {
				System.out.println("Opcion Inválida");
			}
		}while (opcion != 3);
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
}
