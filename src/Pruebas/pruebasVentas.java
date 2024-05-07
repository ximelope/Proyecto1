package Pruebas;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import modeloGaleria.Propietario;
import modeloGaleria.Venta;
import modeloGaleria.Comprador;
import modeloGaleria.Fotografia;

public class pruebasVentas {
	private Venta venta;
	private Fotografia fotografia;
	@Before
	public void setUp() {
		Propietario propietario = new Propietario("jujujuli","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
		String name = propietario.getLogin();
		this.fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, name, "07/05/2024", "5000", 300, "Digital", 10, 10);
		this.venta = new Venta(fotografia, "2022-01-01");
	}
	@Test
    public void testEfectuarVenta() {
        Comprador comprador = new Comprador("comprador1", "password", "comprador1@gmail.com", 1234567891, 10000, "Fotografia");
        assertTrue(venta.efectuarVenta(fotografia, comprador));
        assertEquals("Vendida", fotografia.getEstadoDePieza());
    }

}
