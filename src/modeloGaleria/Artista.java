package modeloGaleria;
import java.util.ArrayList;
import java.util.Collection;

public class Artista{
    private String nombre;//Ingresa pieza-pieza-pieza
    protected Collection<Pieza> piezasLista;
	
    public Artista (String nombre, Collection<Pieza> piezasLista) {
        this.nombre = nombre;
        this.piezasLista = piezasLista; // Asigna la colección pasada al constructor a piezasLista
    }

    public String getNombre() {
        return nombre;
    }
    public Collection<Pieza> getPiezasLista() {
        return piezasLista;
    }
} 
