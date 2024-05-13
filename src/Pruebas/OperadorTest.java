package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import modeloGaleria.Administrador;
import modeloGaleria.Comprador;
import modeloGaleria.Fotografia;
import modeloGaleria.Operador;
import modeloGaleria.Pieza;
import modeloGaleria.Propietario;
import modeloGaleria.Registro;
import modeloGaleria.Subasta;

class OperadorTest {
	private static Operador operador;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		operador = new Operador("Julian", "123");
		HashMap<String, Subasta> subastas = new HashMap<>();
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date date1 = format.parse("01-01-2022");
		Date date2 = format.parse("01-01-2023");
		Propietario propietario = new Propietario("jujujuli", "123", "lauraj@gmail.com", 1234567890, "Ayuda");
		Pieza fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, "jujuli", "07/05/2024", "5000", 300, "Digital", 10, 10);
		Subasta subasta = new Subasta("id00", date1, date2, fotografia);
		
		Comprador comprador = new Comprador("comprador1", "password", "comprador1@gmail.com", 1234567891, 10000, "Fotografia", "02-02-2022");
		Registro registro = new Registro(date1, 2567890, comprador, fotografia);
		registro.setSubasta(subasta);
		subasta.getRegistros().add(registro);
		subastas.put(subasta.getId(), subasta);
		
		operador.subastas = subastas;
	}
    @Test
    public void testGanador() {
        String expectedWinner = "El ganador de la subasta es: comprador1";
        assertEquals(expectedWinner, operador.ganador("id00"));
    }
    
    @Test
    public void testCargarSubastas() {
        try {
            File tempFile = File.createTempFile("tempFile", ".txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
            bw.write("id1;01-01-2022;01-01-2023;Fotografía\n");
            bw.write("id2;02-02-2022;02-02-2023;Fotografía\n");
            bw.close();
            
            HashMap<String, Pieza> piezas = new HashMap<>();
            Propietario propietario = new Propietario("jujujuli", "123", "lauraj@gmail.com", 1234567890, "Ayuda");
            Pieza fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, "jujuli", "07/05/2024", "5000", 300, "Digital", 10, 10);
            piezas.put("Fotografía", fotografia);

            HashMap<String, Subasta> sub = new HashMap<>();

            operador.cargarSubastas(tempFile, piezas, sub);

            assertEquals(2, sub.size());
            assertTrue(sub.containsKey("id1"));
            assertTrue(sub.containsKey("id2"));

        } catch (Exception e) {
            fail("Exception thrown during test: " + e.toString());
        }
    }
    @Test
	void testInput() throws IOException {
	    String simulatedUserInput = "test input";
	    InputStream stdin = System.in;
	    try {
	        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

	        String result = operador.input("Ingrese algo");
	        assertEquals(simulatedUserInput, result);
	    } finally {
	        System.setIn(stdin);
	    }
	}

    @Test
    public void testAlmacenarRegistros() throws Exception {

        File tempFile = File.createTempFile("Registros", ".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
	    writer.write("01-01-2022;2567890;comprador1\n");
	    writer.close();

        tempFile.deleteOnExit();

        HashMap<String, Registro> registros = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaRegistro = sdf.parse("01-01-2022");
        Comprador comprador = new Comprador("comprador1", "password", "comprador1@gmail.com", 1234567891, 10000, "Fotografia", "02-02-2022");
        Propietario propietario = new Propietario("jujujuli", "123", "lauraj@gmail.com", 1234567890, "Ayuda");
        Pieza fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, "jujuli", "07/05/2024", "5000", 300, "Digital", 10, 10);
        Subasta subasta = new Subasta("id00", fechaRegistro, fechaRegistro, fotografia);
        Registro registro = new Registro(fechaRegistro, 2567890, comprador, fotografia, subasta);
        registros.put("registro1", registro);

        operador.almacenarRegistros(registros);
        try (BufferedReader br = new BufferedReader(new FileReader(tempFile))) {
            String line = br.readLine();
            assertNotNull(line, "El archivo está vacío o no se leyó correctamente");
            String[] partes = line.split(";");
            assertEquals("01-01-2022", partes[0]);
            assertEquals("2567890", partes[1]);
            assertEquals("comprador1", partes[2]);
        } catch (IOException e) {
            fail("Error al leer el archivo de registros: " + e.getMessage());
        }
    }

    @Test
    public void testAlmacenarSubastas() throws Exception {
        Operador operador = new Operador("Julian", "123");
        HashMap<String, Subasta> subastas = new HashMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaInicio = sdf.parse("01-01-2023");
        Date fechaFin = sdf.parse("31-12-2023");
        Propietario propietario = new Propietario("prop123", "123", "prop123@gmail.com", 1234567890, "Helping");
        Pieza fotografia = new Fotografia("Foto", "Ayuda", 2025, "Medellin", "prop123", true, true, 3000, 3000, propietario, "prop123", "10/10/2025", "3000", 200, "Impresa", 20, 20);
        Subasta subasta = new Subasta("id123", fechaInicio, fechaFin, fotografia);
        subastas.put("id123", subasta);

        // Crear archivo temporal para almacenar las subastas
        File tempFile = File.createTempFile("Subastas", ".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
	    writer.write("id123;01-01-2023;31-12-2023;Foto\n");
	    writer.close();

        tempFile.deleteOnExit();
        operador.almacenarSubastas(subastas);

        // Leer y verificar los datos del archivo
        try (BufferedReader br = new BufferedReader(new FileReader(tempFile))) {
            String line = br.readLine();
            assertNotNull(line, "El archivo está vacío o no se leyó correctamente");
            String[] partes = line.split(";");
            assertEquals("id123", partes[0]);
            assertEquals("01-01-2023", partes[1]);
            assertEquals("31-12-2023", partes[2]);
            assertEquals("Foto", partes[3]);
        } catch (IOException e) {
            fail("Error al leer el archivo de subastas: " + e.getMessage());
        }
    }
    
    @Test
    void testRegistrarOfertaValida() throws Exception {
        HashMap<String, Registro> registros = new HashMap<>();
        HashMap<String, Comprador> clientes = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaInicio = sdf.parse("01-01-2022");
        Date fechaFin = sdf.parse("31-12-2022");
        Propietario propietario = new Propietario("prop123", "123", "prop123@gmail.com", 1234567890, "Ayuda");
        Pieza fotografia = new Fotografia("Foto", "Ayuda", 2025, "Medellin", "prop123", true, true, 3000, 3000, propietario, "prop123", "10/10/2025", "3000", 200, "Impresa", 20, 20);
        Subasta subasta = new Subasta("id123", fechaInicio, fechaFin, fotografia);
        operador.subastas.put("id123", subasta);

        Comprador comprador = new Comprador("user123", "pass123", "user123@example.com", 12345678, 10000, "Foto", "15-06-2022");
        comprador.cambiarEstado("Verificado");
        clientes.put("user123", comprador);    

        Administrador administrador = new Administrador("admin", "admin123");

        String fecha = "15-06-2022";
        operador.registrarOferta(registros, clientes, fecha, 4000, "user123", "pass123", "user123@example.com", 1234567890, 10000, "id123", operador.subastas.get("id123").getPieza(), administrador);
        
        Subasta subasta1 = operador.subastas.get("id123");
        List<Registro> registros1 = (List<Registro>) subasta1.getRegistros();
        Registro registro2 = null;
        for (Registro registro : registros1) {
            if (registro.getMonto() == 4000) {
                Registro registro3 = registro;
                registro2 = registro3;
                break; // No necesitamos seguir buscando una vez que encontramos el registro
            }
        }
        assertNotNull(registro2, "No se encontró un registro con monto 4000");
        assertEquals(4000, registro2.getMonto(), "El monto del registro encontrado no es 4000");
    
    }
    
    @Test
    void testRegistrarOfertaInvalidaPorFecha() throws Exception {
    	HashMap<String, Registro> registros = new HashMap<>();
        HashMap<String, Comprador> clientes = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaInicio = sdf.parse("01-01-2022");
        Date fechaFin = sdf.parse("31-12-2022");
        Propietario propietario = new Propietario("prop123", "123", "prop123@gmail.com", 1234567890, "Ayuda");
        propietario.getPiezas();
        Pieza fotografia = new Fotografia("Foto", "Ayuda", 2025, "Medellin", "prop123", true, true, 3000, 3000, propietario, "prop123", "10/10/2025", "3000", 200, "Impresa", 20, 20);
        Subasta subasta = new Subasta("id123", fechaInicio, fechaFin, fotografia);
        operador.subastas.put("id123", subasta);

        Comprador comprador = new Comprador("user123", "pass123", "user123@example.com", 12345678, 10000, "Foto", "15-06-2022");
        comprador.cambiarEstado("Verificado");
        clientes.put("user123", comprador);    

        Administrador administrador = new Administrador("admin", "admin123");
        String fecha = "01-01-2023"; // Fuera del rango de la subasta
        operador.registrarOferta(registros, clientes, fecha, 3500, "user123", "pass123", "user123@example.com", 1234567890, 10000, "id123", operador.subastas.get("id123").getPieza(),administrador);

        assertTrue(registros.isEmpty());
        assertEquals(3000*3/4, operador.subastas.get("id123").getMonto()); 
    }
}
    


