package modeloGaleria;
import java.util.Collection;

public class Artista{
    private String nombre;
    private String piezas; //Ingresa pieza-pieza-pieza
    protected Collection<Pieza> piezasLista;
	
    public Artista (String nombre, String piezas) {
        this.nombre = nombre;
        this.piezas = piezas;
    }

    public String getNombre() {
        return nombre;
    }
    public String getPieza() {
        return piezas;
    }
    
    public void piezasLista(String piezas) {
    	String[] partes = piezas.split("-");
    	if (partes.length == 1) {
    		boolean piezakey = Galeria.getPiezas().containsKey(piezas);
    		if (piezakey == true) {
    			Pieza piezaObj = Galeria.getPiezas().get(piezas);
    			this.piezasLista.add(piezaObj);
    		}
    	}
        if (partes.length != 1 && partes.length != 0) {
        	for (String parte: partes) {
        		boolean piezakey = Galeria.getPiezas().containsKey(parte);
        		if (piezakey == true) {
        			Pieza piezaObj = Galeria.getPiezas().get(parte);
        			this.piezasLista.add(piezaObj);
        		}
        	}
        }
    	
    }
} 
