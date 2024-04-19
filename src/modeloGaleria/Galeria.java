package modeloGaleria;

import java.util.HashMap;
import java.util.Map;


public class Galeria {
	private Map<String, Pieza> inventario;
	
	public Galeria () {
		setInventario(new HashMap<String, Pieza>( ));
	}

	public Map<String, Pieza> getInventario() {
		return inventario;
	}

	public void setInventario(Map<String, Pieza> inventario) {
		this.inventario = inventario;
	}
	
	

}
