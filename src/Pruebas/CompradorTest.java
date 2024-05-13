package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modeloGaleria.Comprador;
import modeloGaleria.Fotografia;
import modeloGaleria.Pieza;
import modeloGaleria.Propietario;
import modeloGaleria.Registro;
import modeloGaleria.Subasta;

class CompradorTest {

	@Test
    void testComprador() {
        Comprador comprador = new Comprador("comp123", "123", "comp123@gmail.com", 1234567890, 3000, "Pieza", "10/10/2025");

        assertEquals("comp123@gmail.com", comprador.getCorreoElectronico());
        assertEquals(1234567890, comprador.getNumeroDeTelefono());
        assertEquals(3000, comprador.getValorMax());
        assertEquals("NoAplica", comprador.getEstado());
        assertEquals("Pieza", comprador.getPiezas());
        assertEquals("10/10/2025", comprador.getFechas());

        comprador.cambiarEstado("Verificado");
        assertEquals("Verificado", comprador.getEstado());

        Propietario propietario = new Propietario("prop123", "123", "prop123@gmail.com", 1234567890, "Ayuda");
        String name = propietario.getLogin();
        Pieza fotografia = new Fotografia("Fotografía", "Ayuda", 2024, "Cucuta", "jujuli", true, true, 5000, 5000, propietario, name, "07/05/2024", "5000", 300, "Digital", 10, 10);
        comprador.comprarObra(fotografia);
        List<Pieza> comprador1 = (List<Pieza>)comprador.getInfocompras();
        Pieza pieza = null;
        comprador.setInfocompras(comprador.getInfocompras());
        for (Pieza piecita : comprador1 ) {
            if (piecita.getTitulo().equals("Ayuda")) {
                pieza = piecita;
                break; // No necesitamos seguir buscando una vez que encontramos el registro
            }
        }
        assertNotNull(pieza, "No se encontró un registro con monto 4000");
      }

}


