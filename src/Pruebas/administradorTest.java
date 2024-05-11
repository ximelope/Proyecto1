package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modeloGaleria.Administrador;
import modeloGaleria.Comprador;
import modeloGaleria.Escultura;
import modeloGaleria.Fotografia;
import modeloGaleria.Impresion;
import modeloGaleria.Pieza;
import modeloGaleria.Pintura;
import modeloGaleria.Propietario;
import modeloGaleria.Video;

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
	@Test
	void testCrearPiezaEscultuta() {
		HashMap<String, Propietario> propietarios=  new HashMap<>();
		Propietario propietario = new Propietario("Yeico","123", "yeico@gmail.com", 1234567890, "Linda" );
		String name = propietario.getLogin();
		propietarios.put(name, propietario);
		HashMap<String, Escultura> esculturas = new HashMap<>();
		assertEquals("Linda", admin.crearPiezaEscultura(propietarios,esculturas,"Escultura", "Linda",2020, "Bogota", "Camilo",true, true, 5000,3000,name, "02-02-2020",name,"5000",2,2,2,"Yeso",20,false,"nada").getTitulo());
	}
	@Test
	void testCrearPiezaPintura() {
		HashMap<String, Propietario> propietarios=  new HashMap<>();
		Propietario propietario = new Propietario("Yeico","123", "yeico@gmail.com", 1234567890, "Linda" );
		String name = propietario.getLogin();
		propietarios.put(name, propietario);
		HashMap<String, Pintura> pinturas = new HashMap<>();
		assertEquals("Linda", admin.crearPiezaPintura(propietarios,pinturas,"Pintura", "Linda",2020, "Bogota", "Camilo",true, true, 5000,3000,name, "02-02-2020",name,"5000",2,2,"Yeso","nada").getTitulo());
	}
	@Test
	void testCrearPiezaVideo() {
		HashMap<String, Propietario> propietarios=  new HashMap<>();
		Propietario propietario = new Propietario("Yeico","123", "yeico@gmail.com", 1234567890, "Linda" );
		String name = propietario.getLogin();
		propietarios.put(name, propietario);
		HashMap<String, Video> videos = new HashMap<>();
		assertEquals("Linda", admin.crearPiezaVideo(propietarios,videos,"Video", "Linda",2020, "Bogota", "Camilo",true, true, 5000,3000,name, "02-02-2020",name,"5000",2,true).getTitulo());
	}
	@Test
	void testCrearPiezaFotografia() {
		
		HashMap<String, Propietario> propietarios=  new HashMap<>();
		Propietario propietario = new Propietario("Yeico","123", "yeico@gmail.com", 1234567890, "Linda" );
		String name = propietario.getLogin();
		propietarios.put(name, propietario);
		HashMap<String, Fotografia> pinturas = new HashMap<>();
		assertEquals("Linda", admin.crearPiezaFotografia(propietarios,pinturas,"Fotografía", "Linda", 2024, "Cucuta", "Camilo", true, true, 5000, 5000, name, "07/05/2024",name, "5000", 300, "Digital", 10, 10).getTitulo());
		}
	@Test
	void testCrearPiezaImpresion() {
		
		HashMap<String, Propietario> propietarios=  new HashMap<>();
		Propietario propietario = new Propietario("Yeico","123", "yeico@gmail.com", 1234567890, "Linda" );
		String name = propietario.getLogin();
		propietarios.put(name, propietario);
		HashMap<String, Impresion> pinturas = new HashMap<>();
		assertEquals("Linda", admin.crearPiezaImpresion(propietarios,pinturas,"Fotografía", "Linda", 2024, "Cucuta", "Camilo", true, true, 5000, 5000, name, "07/05/2024",name, "5000", 300, "Digital", 10, 10).getTitulo());
	}
	@Test
	void testVerificacionDeCliente() {
		Comprador comprador = new Comprador("Lucia", "123", "lucia@gmail.com", 200, 3000, "Linda", "02-02-2000");
		admin.verificacionDeCliente(comprador);
		assertEquals("Negado", comprador.getEstado());
		Comprador cliente = new Comprador("Lucia", "123", "lucia@gmail.com", 31145807, 3000, "Linda", "02-02-2000");
		admin.verificacionDeCliente(cliente);
		assertEquals("Verificado", cliente.getEstado());
		
		
	}
    @Test
    public void testInput() throws IOException {

        String inputString = "Hola, mundo!";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);
        String result = admin.input("Ingrese un mensaje");
        assertEquals(inputString, result);
    }

    @Test
    public void testInputIOException() {
        System.setIn(new ByteArrayInputStream(new byte[0]));
        String result = admin.input("Ingrese un mensaje");
        assertNull(result);
    }
    @Test
    public void testAlmacenarFotografias() {
    	Propietario propietario = new Propietario("Santiago","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
		String name = propietario.getLogin();
        HashMap<String, Fotografia> fotografias = new HashMap<>();
        Fotografia fotografia = new Fotografia("Fotografia", "Hola", 2020, "Bogota", "Camilo", true, true, 300, 300, propietario, "11-02-2022", name, "200", 20, "30", 30, 30);
        fotografias.put("Hola", fotografia);
        admin.almacenarFotografias(fotografias);
        try (BufferedReader br = new BufferedReader(new FileReader("./src/data/Fotografias.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
            	String[] partes = linea.split(";");
                assertEquals("Fotografia",partes[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAlmacenarEsculturas() {
    	Propietario propietario = new Propietario("Santiago","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
		String name = propietario.getLogin();
        HashMap<String, Escultura> esculturas = new HashMap<>();
        Escultura escultura = new Escultura("Escultura", "Kila", 2020, "Bogota", "Camilo", true, true, 300, 300, propietario, "11-02-2022", name, "2000", 20, 30, 30,"Yeso",11,true,"Nada");
        esculturas.put("Kila", escultura );
        admin.almacenarEsculturas(esculturas);
        try (BufferedReader br = new BufferedReader(new FileReader("./src/data/Esculturas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
            	String[] partes = linea.split(";");
                assertEquals("Escultura",partes[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAlmacenarPinturas() {
    	Propietario propietario = new Propietario("Santiago","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
		String name = propietario.getLogin();
        HashMap<String, Pintura> pinturas = new HashMap<>();
        Pintura pintura = new Pintura("Pintura", "MonaLisa", 2020, "Bogota", "Camilo", true, true, 300, 300, propietario, "11-02-2022", name, "2000", 20,20,"Papel","Agua");
        pinturas.put("MonaLisa", pintura);
        admin.almacenarPinturas(pinturas);
        try (BufferedReader br = new BufferedReader(new FileReader("./src/data/Pinturas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
            	String[] partes = linea.split(";");
                assertEquals("Pintura",partes[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    @Test
    public void testAlmacenarImpresiones() {
    	Propietario propietario = new Propietario("Santiago","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
		String name = propietario.getLogin();
        HashMap<String, Impresion> impresiones = new HashMap<>();
        Impresion impresion = new Impresion("Impresion", "Paisaje", 2020, "Bogota", "Camilo", true, true, 300, 300, propietario, "11-02-2022", name, "2000", 20,"Papel",20,20);
        impresiones.put("Paisaje", impresion);
        admin.almacenarImpresiones(impresiones);
        try (BufferedReader br = new BufferedReader(new FileReader("./src/data/Impresiones.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
            	String[] partes = linea.split(";");
                assertEquals("Impresion",partes[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}

