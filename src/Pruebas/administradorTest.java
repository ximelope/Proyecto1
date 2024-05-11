package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modeloGaleria.Administrador;
import modeloGaleria.Fotografia;
import modeloGaleria.Pieza;
import modeloGaleria.Propietario;

class administradorTest {
	private static Administrador admin;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		admin = new Administrador("Nicolas","123");
	}

	@Test
	void testAñadirPieza() {
		HashMap<String, Pieza> piezas = new HashMap<>();
		Propietario propietario = new Propietario("jujujuli","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
		String name = propietario.getLogin();
		Pieza fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, name, "07/05/2024", "5000", 300, "Digital", 10, 10);
		admin.añadirPieza(fotografia,piezas);
		assertTrue(piezas.containsKey(fotografia.getTitulo()));
	}
	
	

}
