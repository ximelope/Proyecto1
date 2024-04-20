package modeloGaleria;

import java.util.Date;

public abstract class Pieza {
	
	protected String tipo;
	protected String titulo;
	protected int ano;
	protected String lugarCreacion;
	protected String autor;
	protected boolean exhibida; 
	protected boolean permisoVenta;
	protected float valorFijo;
	protected double valorMinimoSubasta;
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
	public String getTipo() {
		return tipo;
	}

	
	
	// Constructor
	public Pieza(String tipo,String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
			float valorFijo, double valorMinimoSubasta, Propietario propietario, String estadoDePieza) {
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
		this.estadoDePieza= estadoDePieza;
	}
	
}