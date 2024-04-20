package Presentacion;
import modeloGaleria.Galeria;
import java.io.*;

public class Presentar {
	Galeria galeria = new Galeria();
	public void mostrarMenu() {
		System.out.println("1.) Registrarse");
		System.out.println("2.) Salir ");
	}
	public void ejecutarAplicacion() {

		mostrarMenu();
		galeria.cargarInformacion();

		int opcion = Integer.parseInt(input("\nSeleccione una opcion"));
		while (true) {
			if (opcion == 1) {
				ejecutarOpcion1();
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
			mostrarMenu();
			opcion = Integer.parseInt(input("\nSeleccione una opcion"));
			System.out.flush();
		}
	}

	private void ejecutarOpcion1() {
		String usuario = input("Ingresa usuario");
		String contrasena = input("Ingresa contrasena");
		String rol = input("Ingresa el rol que cumples (Administrador, Operador o Cajero");
		galeria.login(usuario, contrasena,rol);
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
			Presentar consola = new Presentar();
			consola.ejecutarAplicacion();
		}
	}
}

		
