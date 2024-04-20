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
	public boolean isPermisoSubasta() {
		return permisoSubasta;
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
	public Escultura(String titulo, int ano, String lugarCreacion, String autor, boolean exhibida,
			boolean permisoSubasta, float valorFijo, float valorMinimoSubasta, Propietario propietario, float alto, float ancho,
			float profundidad, String materialEscultura, float peso, boolean necesitaElectricidad, String detallesInstalacion) {
		super(titulo, ano, lugarCreacion, autor, exhibida, permisoSubasta, valorFijo, valorMinimoSubasta, propietario,estado);
		this.alto= alto;
		this.ancho= ancho;
		this.profundidad= profundidad; 
		this.materialEscultura= materialEscultura;
		this.peso = peso;
		this.necesitaElectricidad= necesitaElectricidad;
		this.detallesInstalacion= detallesInstalacion;
		
	}
}
