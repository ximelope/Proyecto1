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
	
	//Constructor
	public Pintura(String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoSubasta,
			float valorFijo, float valorMinimoSubasta, Propietario propietario,String estado, float alto, float ancho, String materialBase,
			String tipoPinturas) 
	{
		super(titulo, ano, lugarCreacion, autor, exhibida, permisoSubasta, valorFijo, valorMinimoSubasta, propietario, estado);
		this.alto =alto;
		this.ancho= ancho;
		this.materialBase= materialBase;
		this.tipoPinturas= tipoPinturas;
	}
	
	

}
