package Pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modeloGaleria.Administrador;
import modeloGaleria.Fotografia;
import modeloGaleria.Pieza;
import modeloGaleria.Propietario;
import modeloGaleria.Subasta;

public class SubastaTest {
	private static Subasta subasta;
	@BeforeAll
	static void setUpBeforeClass() {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		
		Date fechaInicialDate = null;
		try {
			fechaInicialDate = formatoFecha.parse("17-02-2006");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date fechaFinalDate = null;
		try {
			fechaFinalDate = formatoFecha.parse("08-03-2008");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Propietario propietario = new Propietario("jujujuli","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
	    String name = propietario.getLogin();
	    Pieza fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", false, true, 5000, 5000, propietario, name, "07/05/2024", "5000", 300, "Digital", 10, 10);
		subasta = new Subasta("11", fechaInicialDate, fechaFinalDate, fotografia);
	}
	    @Test
	    void testSubastaConstructor() {
	        Date fechaInicial = new Date();
	        Date fechaFinal = new Date();
	        Propietario propietario = new Propietario("prop123", "123", "prop123@gmail.com", 1234567890, "Ayuda");
	        Pieza fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, propietario.getLogin(), "07/05/2024", "5000", 300, "Digital", 10, 10);
			Subasta subasta = new Subasta("sub123", fechaInicial, fechaFinal, fotografia);

	        assertEquals("sub123", subasta.getId());
	        assertEquals(fechaInicial, subasta.getFechaInicial());
	        assertEquals(fechaFinal, subasta.getFechaFinal());
	        assertEquals(fotografia, subasta.getPieza());
	        assertEquals(fotografia.getValorMinimoSubasta() * 3 / 4, subasta.getMonto());
	        assertTrue(subasta.getRegistros().isEmpty());
	        assertNull(subasta.getUltimoRegistro());
	    }

	    @Test
	    void testCambiarMonto() {
	        Date fechaInicial = new Date();
	        Date fechaFinal = new Date();
	        Propietario propietario = new Propietario("prop123", "123", "prop123@gmail.com", 1234567890, "Ayuda");
	        Pieza fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, propietario.getLogin(), "07/05/2024", "5000", 300, "Digital", 10, 10);
			Subasta subasta = new Subasta("sub123", fechaInicial, fechaFinal, fotografia);

	        subasta.cambiarMonto(5000);
	        assertEquals(5000, subasta.getMonto());
	    
	}
}
