package modeloGaleria;

public abstract class Pieza {
	
	protected String titulo;
	protected int ano;
	protected String lugarCreacion;
	protected String autor;
	protected boolean exhibida; 
	protected boolean permisoSubasta;
	protected float valorFijo;
	protected double valorMinimoSubasta;
	protected Propietario propietario;
	protected String estadoDePieza;
	
	public abstract String getTitulo();
	public abstract int getAno();
	public abstract String getLugarCreacion();
	public abstract String getAutor();
	public abstract boolean isExhibida();
	public abstract boolean isPermisoVenta();
	public abstract float getValorFijo();
	public abstract double getValorMinimoSubasta();
	public abstract Propietario getPropietario() ;
	public abstract String getEstadoDePieza();
	
	
	
	
	// Constructor
	public Pieza(String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
			float valorFijo, double valorMinimoSubasta, Propietario propietario, String estadoDePieza) {
		this.titulo = titulo;
		this.ano = ano;
		this.lugarCreacion = lugarCreacion;
		this.autor = autor;
		this.exhibida = exhibida;
		this.permisoSubasta = permisoVenta;
		this.valorFijo = valorFijo;
		this.valorMinimoSubasta = valorMinimoSubasta;
		this.propietario = propietario;
		this.estadoDePieza= estadoDePieza;
	}

}
