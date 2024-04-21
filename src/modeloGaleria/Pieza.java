package modeloGaleria;

public abstract class Pieza {
	
	protected String tipo;
	protected String titulo;
	protected int ano;
	protected String lugarCreacion;
	protected String autor;
	protected boolean exhibida; 
	protected boolean permisoVenta;
	protected int valorFijo;
	protected int valorMinimoSubasta;
	protected Propietario propietario;
	protected String estadoDePieza;
	
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
	public int getValorFijo() {
		return valorFijo;
	}
	public int getValorMinimoSubasta() {
		return valorMinimoSubasta;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public String getEstadoDePieza() {
		return estadoDePieza;
	}
	public String getTipo() {
		return tipo;
	}

	public void cambiarPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
	public void cambiarEstado(String estado) {
        this.estadoDePieza = estado;
    }
	
	
	// Constructor
	public Pieza(String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
			int valorFijo, int valorMinimoSubasta, Propietario propietario) {
		this.tipo= tipo;
		this.titulo = titulo;
		this.ano = ano;
		this.lugarCreacion = lugarCreacion;
		this.autor = autor;
		this.exhibida = exhibida;
		this.permisoVenta = permisoVenta;
		this.valorFijo = valorFijo;
		this.valorMinimoSubasta = valorMinimoSubasta;
		this.propietario = propietario;
		this.estadoDePieza= "Disponible";
	}
	
}