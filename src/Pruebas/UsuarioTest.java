package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modeloGaleria.Fotografia;
import modeloGaleria.Pieza;
import modeloGaleria.Propietario;
import modeloGaleria.Usuario;

class UsuarioTest {

	@Test
    void testGetLogin() {
        Usuario usuario = new Usuario("testLogin", "testPassword") {
        };
        assertEquals("testLogin", usuario.getLogin());
    }

    @Test
    void testGetContrasena() {
        Usuario usuario = new Usuario("testLogin", "testPassword") {
        };
        assertEquals("testPassword", usuario.getContrasena());
    }
}
