package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modeloGaleria.Propietario;
import modeloGaleria.Video;

class VideoTest {
    @Test
    void testGetDuracion() {
        Propietario propietario = new Propietario("prop123", "123", "prop123@gmail.com", 1234567890, "Ayuda");
        Video video = new Video("Video", "Ayuda", 2025, "Medellin", "prop123", true, true, 3000, 3000, propietario, "prop123", "10/10/2025", "3000", 120.0f, true);
        assertEquals(120.0f, video.getDuracion());
    }

    @Test
    void testGetNecesidadElectricidad() {
        Propietario propietario = new Propietario("prop123", "123", "prop123@gmail.com", 1234567890, "Ayuda");
        Video video = new Video("Video", "Ayuda", 2025, "Medellin", "prop123", true, true, 3000, 3000, propietario, "prop123", "10/10/2025", "3000", 120.0f, true);
        assertTrue(video.getNecesidadElectricidad());
    }
}