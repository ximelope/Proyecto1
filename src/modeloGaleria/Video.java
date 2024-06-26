package modeloGaleria;

public class Video extends Pieza{

	private float duracion; 
	private Boolean necesidadElectricidad;
	
	public float getDuracion() {
		return duracion;
	}
	public Boolean getNecesidadElectricidad() {
		return necesidadElectricidad;
	}
	
	
	
	public Video(String tipo, String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoSubasta,
			int valorFijo, int valorMinimoSubasta, Propietario propietario, String propietarios, String fechas, String precios,  float duracion, boolean necesidadElectricidad) {
		
		super(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoSubasta, valorFijo, valorMinimoSubasta, propietario, propietarios, fechas, precios);
		this.duracion= duracion;
		this.necesidadElectricidad= necesidadElectricidad;
	}
}
