package modeloGaleria;

public class Fotografia extends Pieza {

	private float resolucion;
	private String tecnica;
	private float ancho;
	private float alto;
	public Fotografia(String tipo, String titulo, int ano, String lugarCreacion, String autor, boolean exhibida,
			boolean permisoVenta, int valorFijo, int valorMinimoSubasta, Propietario propietario, String propietarios, String fechas,
			float resolucion, String tecnica, float ancho, float alto) {
		super(tipo, titulo, ano, lugarCreacion, autor, exhibida, permisoVenta, valorFijo, valorMinimoSubasta, propietario, propietarios, fechas);
		this.resolucion= resolucion;
		this.tecnica= tecnica;
		this.ancho  = ancho;
		this.alto = alto;
		// TODO Auto-generated constructor stub
	}
	public float getResolucion() {
		return resolucion; 
	}
	public String getTecnica() {
		return tecnica;
	}
	public float getAncho() {
		return ancho;
	}
	
	public float getAlto() {
		return alto;
		
	}
}