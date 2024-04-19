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
	
	public Video(String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoSubasta,
			float valorFijo, float valorMinimoSubasta, Propietario propietario, float duracion, boolean necesidadElectricidad) {
		
		super(titulo, ano, lugarCreacion, autor, exhibida, permisoSubasta, valorFijo, valorMinimoSubasta, propietario);
		this.duracion= duracion;
		this.necesidadElectricidad= necesidadElectricidad;
	}
}
