package Pruebas;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modeloGaleria.Artista;
import modeloGaleria.Comprador;
import modeloGaleria.Escultura;
import modeloGaleria.Fotografia;
import modeloGaleria.Galeria;
import modeloGaleria.Impresion;
import modeloGaleria.Pieza;
import modeloGaleria.Pintura;
import modeloGaleria.Propietario;
import modeloGaleria.Subasta;
import modeloGaleria.Video;



public class GaleriaTest {
	private  Galeria galeria;
	
	@BeforeEach
	public void setUp() {
		this.galeria = new Galeria();
	}
	
	@Test
	public void testCargarInformacion() {
		galeria.cargarInformacion();
		assertTrue(galeria.getUsuarios().containsKey("Juliana"));
	}
	@Test
	public void testCargarPropietario() {
		galeria.cargarPropietario();
		assertTrue(galeria.getPropietarios().containsKey("Santiago"));
	}
	@Test
	public void testCargarComprador() {
		galeria.cargarComprador();
		assertTrue(galeria.getClientes().containsKey("Santiago"));
	}
	@Test
	public void testCargarArtista() {
		galeria.cargarArtista();
		assertTrue(galeria.getArtistas().containsKey("Camilo"));
	}
	@Test
	public void testCargarPieza() {
		File videos = new File("./src/data/Videos.txt");
		galeria.cargarPieza(videos);
		assertTrue(galeria.getPiezas().containsKey("Lluvia"));
	}
	@Test
	public void testCrearPiezaEscultuta() {
		HashMap<String, Propietario> propietarios=  new HashMap<>();
		Propietario propietario = new Propietario("Yeico","123", "yeico@gmail.com", 1234567890, "Linda" );
		String name = propietario.getLogin();
		propietarios.put(name, propietario);
		HashMap<String, Escultura> esculturas = new HashMap<>();
		assertEquals("Linda", galeria.crearPiezaEscultura(esculturas,"Escultura", "Linda",2020, "Bogota", "Camilo",true, true, 5000,3000,name, "02-02-2020",name,"5000",2,2,2,"Yeso",20,false,"nada").getTitulo());
		}
	@Test
	public void testCrearPiezaPintura() {
		HashMap<String, Propietario> propietarios=  new HashMap<>();
		Propietario propietario = new Propietario("Yeico","123", "yeico@gmail.com", 1234567890, "Linda" );
		String name = propietario.getLogin();
		propietarios.put(name, propietario);
		HashMap<String, Pintura> pinturas = new HashMap<>();
		assertEquals("Linda", galeria.crearPiezaPintura(pinturas,"Pintura", "Linda",2020, "Bogota", "Camilo",true, true, 5000,3000,name, "02-02-2020",name,"5000",2,2,"Yeso","nada").getTitulo());
	}
	@Test
	public void testCrearPiezaVideo() {
		HashMap<String, Propietario> propietarios=  new HashMap<>();
		Propietario propietario = new Propietario("Yeico","123", "yeico@gmail.com", 1234567890, "Linda" );
		String name = propietario.getLogin();
		propietarios.put(name, propietario);
		HashMap<String, Video> videos = new HashMap<>();
		assertEquals("Linda", galeria.crearPiezaVideo(videos,"Video", "Linda",2020, "Bogota", "Camilo",true, true, 5000,3000,name, "02-02-2020",name,"5000",2,true).getTitulo());
	}
	@Test
	public void testCrearPiezaFotografia() {		
		HashMap<String, Propietario> propietarios=  new HashMap<>();
		Propietario propietario = new Propietario("Yeico","123", "yeico@gmail.com", 1234567890, "Linda" );
		String name = propietario.getLogin();
		propietarios.put(name, propietario);
		HashMap<String, Fotografia> pinturas = new HashMap<>();
		assertEquals("Linda", galeria.crearPiezaFotografia(pinturas,"Fotografía", "Linda", 2024, "Cucuta", "Camilo", true, true, 5000, 5000, name, "07/05/2024",name, "5000", 300, "Digital", 10, 10).getTitulo());
		}
	@Test
	public void testCrearPiezaImpresion() {		
		HashMap<String, Propietario> propietarios=  new HashMap<>();
		Propietario propietario = new Propietario("Yeico","123", "yeico@gmail.com", 1234567890, "Linda" );
		String name = propietario.getLogin();
		propietarios.put(name, propietario);
		HashMap<String, Impresion> pinturas = new HashMap<>();
		assertEquals("Linda", galeria.crearPiezaImpresion(pinturas,"Fotografía", "Linda", 2024, "Cucuta", "Camilo", true, true, 5000, 5000, name, "07/05/2024",name, "5000", 300, "Digital", 10, 10).getTitulo());
	}
	@Test
	public void testAñadirPieza() {
		HashMap<String, Pieza> piezas = new HashMap<>();
		Propietario propietario = new Propietario("jujujuli","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
		String name = propietario.getLogin();
		Pieza fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, name, "07/05/2024", "5000", 300, "Digital", 10, 10);
		galeria.añadirPieza(fotografia,piezas);
		assertTrue(piezas.containsKey(fotografia.getTitulo()));
	}
	@Test
	public void testCrearPropietario() {
		Propietario propietario = new Propietario("jujujuli","123", "lauraj@gmail.com", 1234567890, "Ayuda" );
		String name = propietario.getLogin();
		Propietario respuesta=galeria.crearPropietario("jujujuli","123", "lauraj@gmail.com", 1234567890, "Ayuda");
		assertEquals(name, respuesta.getLogin());
	}
	@Test
	public void testCrearComprador() {
		Comprador comprador = new Comprador("jujujuli","123", "lauraj@gmail.com", 1234567890,300, "Ayuda","1" );
		String name = comprador.getLogin();
		Comprador respuesta=galeria.crearComprador("jujujuli","123", "lauraj@gmail.com", 1234567890,300, "Ayuda","1");
		assertEquals(name, respuesta.getLogin());
	}
	@Test
	public void testCrearArtista() {
		Collection<Pieza> piezasCollection= new ArrayList<>();
		Artista artista = new Artista ("Nicolas",piezasCollection );
		String name= artista.getNombre();
		Artista respuesta= galeria.crearArtista(name, piezasCollection);
		assertEquals(name, respuesta.getNombre());
	}
	@Test
	public void loginTest() {
		galeria.cargarInformacion();
		assertFalse(galeria.login("Nico","123"));
		assertTrue(galeria.login("Juliana","123"));
	}
	@Test
	public void testCargarUsuarios() {
		galeria.cargarUsuarios();
		assertTrue(galeria.getUsuarios().containsKey("Juliana"));
	}
	@Test
    void testInput() throws IOException {
	    String inputString = "Hola, mundo!";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);
        String result = galeria.input("Ingrese un mensaje");
        assertEquals(inputString, result);
    }
    @Test
    void testInputIOException() {
        System.setIn(new ByteArrayInputStream(new byte[0]));
        String result = galeria.input("Ingrese un mensaje");
        assertNull(result);
    }
	
	
	
}
