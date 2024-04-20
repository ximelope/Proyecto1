package modeloGaleria;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Inventario {
	private Map<String, Pieza> bodega;
	private Map<String, Pieza> exhibicion;

	public Inventario() {
		bodega = new HashMap<String,Pieza>( );
		exhibicion = new HashMap<String,Pieza>( );
	}

	public Collection<Pieza> getBodega (){
		return bodega.values();
	}
	public Collection<Pieza> getExhibicion (){
		return exhibicion.values();
	}
	protected void cargarPiezas(Pieza pieza) {
		Boolean estado = pieza.isExhibida();
		if (estado==true) {
			this.exhibicion.put(pieza.getTitulo(), pieza);
		}
		else {
			this.bodega.put(pieza.getTitulo(), pieza);
		}
	}
	
}
