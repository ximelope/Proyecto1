package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modeloGaleria.Cajero;
import modeloGaleria.Comprador;
import modeloGaleria.Fotografia;
import modeloGaleria.Pieza;
import modeloGaleria.Propietario;
import modeloGaleria.Registro;
import modeloGaleria.Venta;

class CajeroTest {
	static Cajero cajero;
	@BeforeAll
	static void setUpBeforeClass()throws Exception {
		cajero = new Cajero("Nicolas","123");
	}

	@Test
    public void testCrearVenta() {
        HashMap<String, Pieza> piezas = new HashMap<>();
        HashMap<String, Comprador> clientes = new HashMap<>();
        HashMap<String, Venta> ventas = new HashMap<>();
        
        Propietario propietario = new Propietario("jujujuli","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
		String name = propietario.getLogin();
        Pieza fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, name, "07/05/2024", "5000", 300, "Digital", 10, 10);
        piezas.put(fotografia.getTitulo(), fotografia);
        Comprador comprador = new Comprador("comprador1", "password", "comprador1@gmail.com", 1234567891, 10000, "Fotografia", "02-02-2022");
        clientes.put(comprador.getLogin(), comprador);

        cajero.crearVenta(fotografia,"01-01-2000" , comprador, ventas);
        assertTrue(ventas.containsKey(fotografia.getTitulo()));
    }
	
	@Test
    void testDarFactura() {
		Propietario propietario = new Propietario("jujujuli","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
		String name = propietario.getLogin();
		Pieza fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, name, "07/05/2024", "5000", 300, "Digital", 10, 10);
        Comprador comprador = new Comprador("comprador1", "password", "comprador1@gmail.com", 1234567891, 10000, "Fotografia", "02-02-2022");
        HashMap<String, Venta> ventas = new HashMap<>();
        
        cajero.crearVenta(fotografia, "02-02-2022", comprador, ventas);
        int factura = cajero.darFactura(fotografia.getTitulo(), ventas);

        assertEquals(ventas.get(fotografia.getTitulo()).getNumeroFactura(), factura);
    }
	
	@Test
	void testCargarVenta() throws IOException {
	    
	    File tempFile = File.createTempFile("test", ".txt");
	    tempFile.deleteOnExit();
	    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
	    writer.write("Ayuda;02-02-2022;comprador1\n");
	    writer.close();

	    HashMap<String, Pieza> piezas = new HashMap<>();
	    HashMap<String, Comprador> clientes = new HashMap<>();
	    HashMap<String, Venta> ventas = new HashMap<>();
	    Propietario propietario = new Propietario("jujujuli","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
	    String name = propietario.getLogin();
	    Pieza fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, name, "07/05/2024", "5000", 300, "Digital", 10, 10);
	    Comprador comprador = new Comprador("comprador1", "password", "comprador1@gmail.com", 1234567891, 10000, "Fotografia", "02-02-2022");
	    piezas.put(fotografia.getTitulo(), fotografia);
	    clientes.put(comprador.getLogin(), comprador);
	    
	    cajero.cargarVenta(tempFile, piezas, clientes, ventas);
	    assertTrue(ventas.containsKey(fotografia.getTitulo()));
	}
	@Test
	void testCrearVentaParseException() {
	    HashMap<String, Pieza> piezas = new HashMap<>();
	    HashMap<String, Comprador> clientes = new HashMap<>();
	    HashMap<String, Venta> ventas = new HashMap<>();
	    Propietario propietario = new Propietario("jujujuli","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
	    String name = propietario.getLogin();
	    Pieza fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, name, "07/05/2024", "5000", 300, "Digital", 10, 10);
	    Comprador comprador = new Comprador("comprador1", "password", "comprador1@gmail.com", 1234567891, 10000, "Fotografia", "02-02-2022");

	    piezas.put(fotografia.getTitulo(), fotografia);
	    clientes.put(comprador.getLogin(), comprador);

	    cajero.crearVenta(fotografia, "fecha mal formada", comprador, ventas);
	    assertFalse(ventas.containsKey(fotografia.getTitulo()));
	}
	
	@Test
	void testInput() throws IOException {
	    String simulatedUserInput = "test input";
	    InputStream stdin = System.in;
	    try {
	        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

	        String result = cajero.input("Ingrese algo");
	        assertEquals(simulatedUserInput, result);
	    } finally {
	        System.setIn(stdin);
	    }
	}
	
	@Test
	void testConfirmarPago() {
	    Propietario propietario = new Propietario("jujujuli","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
	    String name = propietario.getLogin();
	    Pieza fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, name, "07/05/2024", "5000", 300, "Digital", 10, 10);
	    Comprador comprador = new Comprador("comprador1", "password", "comprador1@gmail.com", 1234567891, 10000, "Fotografia", "02-02-2022");
	    comprador.cambiarEstado("Verificado");
	    Date date = new Date();
	    Registro registro = new Registro(date, fotografia.getValorFijo(), comprador, fotografia);

	    cajero.confirmarPago(registro);
	    assertEquals(comprador.getLogin(), fotografia.getPropietario().getLogin());
	}
	
	@Test
	void testAlmacenarVentas() {
	    // Crear datos de prueba
	    HashMap<String, Venta> ventas = new HashMap<>();
	    Propietario propietario = new Propietario("jujujuli","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
	    String name = propietario.getLogin();
	    Pieza fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, name, "07/05/2024", "5000", 300, "Digital", 10, 10);
	    Venta venta = new Venta(fotografia, "02-02-2022");
	    ventas.put(fotografia.getTitulo(), venta);

	    // Llamar al método a probar
	    cajero.almacenarVentas(ventas);

	    // Verificar que los datos de las ventas se escribieron correctamente en el archivo
	    try {
	        BufferedReader br = new BufferedReader(new FileReader(new File("./src/data/Ventas.txt")));
	        String linea = br.readLine();
	        assertEquals(fotografia.getTitulo() + ";02-02-2022;Nicolas", linea);
	        br.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}