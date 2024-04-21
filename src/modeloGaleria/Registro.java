package modeloGaleria;

import java.util.Date;

public class Registro {
	private Date fecha;
	private float monto;
	private Comprador cliente;
	private Pieza pieza;
	private Subasta subasta;
	public Subasta getSubasta() {
		return subasta;
	}

	public void setSubasta(Subasta subasta) {
		this.subasta = subasta;
	}

	public Date getFecha() {
		return fecha;
	}
	

	public float getMonto() {
		return monto;
	}

	
	public Comprador getCliente() {
		return cliente;
	}

	public Pieza getPieza() {
		return pieza;
	}
	
	public Registro (Date fecha, float monto, Comprador cliente, Pieza pieza, Subasta subasta) {
		this.fecha= fecha;
		this.monto = monto;
		this.cliente = cliente;
		this.pieza= pieza;
		this.subasta= subasta;
	}
	public Registro (Date fecha, float monto, Comprador cliente, Pieza pieza) {
		this.fecha= fecha;
		this.monto = monto;
		this.cliente = cliente;
		this.pieza= pieza;
		
	}
	

}