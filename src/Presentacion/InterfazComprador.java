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
		galeria.setCliente(comprador);
		HashMap<String, Comprador> comprador = galeria.getClientes();
		do {
	            System.out.println("Opciones Comprador");
	            System.out.println("1.) Mostrar la historia de una pieza");
	            System.out.println("2.) Mostrar la historia de un artista");
	            System.out.println("3.) Mostrar la historia de un comprador");
	            System.out.println("4.) Cerrar Sesión");
	            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
	            if (opcion == 2)
	            {
	            	//System.out.println(piezas.keySet());
	            } else if (opcion == 1) {
	                //admin.pedir_crearPieza(piezas,  esculturas,pinturas, fotografias, videos, impresiones); // invocar metodos de comprador 
	                }
	            else if (opcion == 3) {
	            	//System.out.println(piezas.keySet());
	            	
	                
	            } else if (opcion == 4) {
	                //almacenarEsculturas(esculturas);
	                //almacenarPinturas(pinturas);
	                //almacenarFotografias(fotografias);
	                //almacenarImpresiones(impresiones);
	                //almacenarVideos(videos);
	                
	            } else {
	                System.out.println("Opcion Inválida");
	            }
	        } while (opcion != 4);
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










