package modeloGaleria;

public class Escultura extends Pieza{
	
	private float alto;
	private float ancho; 
	private float profundidad; 
	private String materialEscultura;
	private float peso;
	private boolean necesitaElectricidad;
	private String detallesInstalacion;
	
	public float getAlto() {
		return alto;
	}
	public float getAncho() {
		return ancho;
	}
	public String getDetallesInstalacion() {
		return detallesInstalacion;
	}
	public float getProfundidad() {
		return profundidad; 
	}
	
	public String getMaterialEscultura() {
		return materialEscultura;
	}
	public float getPeso() {
		return peso;
	}
	public boolean getNecesidadElectricidad() {
		return necesitaElectricidad;
	}
	public Escultura(String titulo, int ano, String lugarCreacion, String autor, boolean exhibida,
			boolean permisoSubasta, float valorFijo, float valorMinimoSubasta, Propietario propietario, float alto, float ancho,
			float profundidad, String materialEscultura, float peso, boolean necesitaElectricidad, String detallesInstalacion) {
		super(titulo, ano, lugarCreacion, autor, exhibida, permisoSubasta, valorFijo, valorMinimoSubasta, propietario);
		this.alto= alto;
		this.ancho= ancho;
		this.profundidad= profundidad; 
		this.materialEscultura= materialEscultura;
		this.peso = peso;
		this.necesitaElectricidad= necesitaElectricidad;
		this.detallesInstalacion= detallesInstalacion;
		
	}
}
