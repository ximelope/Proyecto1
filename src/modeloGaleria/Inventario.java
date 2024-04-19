package modeloGaleria;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Inventario {
	private Map<String, Pieza> bodega;
	private Map<String, Pieza> exhibicion;
	private Administrador administrador;
	
	public Inventario (Administrador administrador) {
		bodega = new HashMap<String,Pieza>( );
		exhibicion = new HashMap<String,Pieza>( );
		this.administrador= administrador;
	}
	
	public Collection<Pieza> getBodega (){
		return bodega.values();
	}
	public Collection<Pieza> getExhibicion (){
		return exhibicion.values();
	}
	public Administrador getAdministrador () {
		return administrador;
	}
	private void cargarPiezas() {
		
	}
}
