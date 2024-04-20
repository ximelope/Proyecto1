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
	public String getTitulo() {
		return titulo;
	}
	public int getAno() {
		return ano;
	}
	public String getLugarCreacion() {
		return lugarCreacion;
	}
	public String getAutor() {
		return autor;
	}
	public boolean isExhibida() {
		return exhibida;
	}
	public boolean isPermisoVenta() {
		return permisoVenta;
	}
	public float getValorFijo() {
		return valorFijo;
	}
	public double getValorMinimoSubasta() {
		return valorMinimoSubasta;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public String getEstadoDePieza() {
		return estadoDePieza;
	}
	
	public Video(String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoSubasta,
			float valorFijo, float valorMinimoSubasta, Propietario propietario,String estado, float duracion, boolean necesidadElectricidad) {
		
		super(titulo, ano, lugarCreacion, autor, exhibida, permisoSubasta, valorFijo, valorMinimoSubasta, propietario, estado);
		this.duracion= duracion;
		this.necesidadElectricidad= necesidadElectricidad;
	}
}
