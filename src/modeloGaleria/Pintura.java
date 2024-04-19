package modeloGaleria;

public class Pintura extends Pieza {
	
	private float alto;
	private float ancho;
	private String materialBase;
	private String tipoPinturas;
	
	//getters
	public float getAlto() {
		return alto;
	}

	public float getAncho() {
		return ancho;
	}

	public String getMaterialBase() {
		return materialBase;
	}

	public String getTipoPinturas() {
		return tipoPinturas;
	}
	
	//Constructor
	public Pintura(String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoSubasta,
			float valorFijo, float valorMinimoSubasta, Propietario propietario, float alto, float ancho, String materialBase,
			String tipoPinturas) 
	{
		super(titulo, ano, lugarCreacion, autor, exhibida, permisoSubasta, valorFijo, valorMinimoSubasta, propietario);
		this.alto =alto;
		this.ancho= ancho;
		this.materialBase= materialBase;
		this.tipoPinturas= tipoPinturas;
	}
	
	

}
