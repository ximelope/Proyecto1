package modeloGaleria;

public abstract class Pieza {
	
	protected String titulo;
	protected int ano;
	protected String lugarCreacion;
	protected String autor;
	protected boolean exhibida; 
	protected boolean permisoSubasta;
	protected float valorFijo;
	protected float valorMinimoSubasta;
	protected Propietario propietario;
	
	
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
	public float getValorMinimoSubasta() {
		return valorMinimoSubasta;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	
	// Constructor
	public Pieza(String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoSubasta,
			float valorFijo, float valorMinimoSubasta, Propietario propietario) {
		this.titulo = titulo;
		this.ano = ano;
		this.lugarCreacion = lugarCreacion;
		this.autor = autor;
		this.exhibida = exhibida;
		this.permisoSubasta = permisoSubasta;
		this.valorFijo = valorFijo;
		this.valorMinimoSubasta = valorMinimoSubasta;
		this.propietario = propietario;
	}
	

}
