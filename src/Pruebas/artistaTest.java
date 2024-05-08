package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modeloGaleria.Artista;
import modeloGaleria.Fotografia;
import modeloGaleria.Pieza;
import modeloGaleria.Propietario;
import modeloGaleria.Venta;

class artistaTest {
	public static Venta venta;
	public static Fotografia fotografia;
	@Test
    public void testConstructor() {
		Collection<Pieza> piezasLista = new ArrayList<>();
	    Artista artista = new Artista("Artista1", piezasLista);
        assertEquals("Artista1", artista.getNombre());
        assertTrue(artista.getPiezasLista().isEmpty());
	    }

	    @Test
	    public void testGetNombre() {
	        Collection<Pieza> piezasLista = new ArrayList<>();
	        Artista artista = new Artista("Artista1", piezasLista);
	        assertEquals("Artista1", artista.getNombre());
	    }

	    @Test
	    public void testGetPiezasLista() {
	        Collection<Pieza> piezasLista = new ArrayList<>();
	        Artista artista = new Artista("Artista1", piezasLista);
	        assertEquals(piezasLista, artista.getPiezasLista());
	    }

}
