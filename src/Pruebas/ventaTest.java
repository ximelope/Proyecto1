package Pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modeloGaleria.Comprador;
import modeloGaleria.Fotografia;
import modeloGaleria.Propietario;
import modeloGaleria.Venta;

class ventaPrueba {

	public static Venta venta;
	public static Fotografia fotografia;
	@BeforeAll
	static void setUp()throws Exception {
		Propietario propietario = new Propietario("jujujuli","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
		String name = propietario.getLogin();
		fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, name, "07/05/2024", "5000", 300, "Digital", 10, 10);
		venta = new Venta(fotografia, "2022-01-01");
	}
	//Verifica que la venta se efectue correctamente
	@Test
    public void testEfectuarVenta() {
        Comprador comprador = new Comprador("comprador1", "password", "comprador1@gmail.com", 1234567891, 10000, "Fotografia", "02-02-2022");
        assertTrue(venta.efectuarVenta(fotografia, comprador));
        assertEquals("Vendida", fotografia.getEstadoDePieza());
    }
	@Test
	public void testNoEfectuarVenta() {
	    Propietario propietario = new Propietario("jujujuli","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
	    String name = propietario.getLogin();
	    Fotografia fotografiaNoDisponible = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", false, true, 5000, 5000, propietario, name, "07/05/2024", "5000", 300, "Digital", 10, 10);
	    fotografiaNoDisponible.cambiarEstado("nn");
	    Comprador comprador = new Comprador("comprador1", "password", "comprador1@gmail.com", 1234567891, 10000, "Fotografia", "02-02-2022");
	    assertFalse(venta.efectuarVenta(fotografiaNoDisponible, comprador));
	    assertEquals("No disponible", fotografiaNoDisponible.getEstadoDePieza());
	}
   @Test
   public void testGenerarNumeroFactura() {
        int numeroFactura = venta.getNumeroFactura();
	    assertTrue(numeroFactura >= 1000 && numeroFactura <= 9999);
	    }

   @Test
   public void testFechaVenta() {
	   assertEquals("2022-01-01", venta.getFechaVenta());
	    } 	
   @Test
   public void testGetPieza() {
       assertEquals(fotografia, venta.getPieza());
   }
   @Test
   void testVentaConstructor() {
       Venta venta = new Venta();
       assertNotNull(venta.getNumeroFactura());
   }

}
