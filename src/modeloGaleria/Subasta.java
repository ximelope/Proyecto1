package modeloGaleria;
import java.util.Date;

public class Subasta {
	private Date fechaInicial;
	private Date fechaFinal;
	private Pieza pieza;
	private double valorInicial;
	private double valorMinimo;
	private Comprador comprador;

	public Subasta(Date fechaInicial, Date fechaFinal, Pieza pieza) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.pieza = pieza;
        this.valorInicial = (pieza.getValorMinimoSubasta())*(3/4);
        this.valorMinimo = pieza.getValorMinimoSubasta();
    }
	
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public double getValorInicial() {
		return valorInicial;
	}

	public double getValorMinimo() {
		return valorMinimo;
	}
	public Pieza getPieza() {
		return pieza;
	}
	public Comprador getComprador() {
		return comprador;
	}


	public void setNombreCompradorDesdeRegistro(OperadorRegistro registro, Pieza pieza) {
		if (registro.getCompradorOfertaMasAlta(pieza) == null) {
			this.comprador = null;
		}
		else this.comprador = registro.getCompradorOfertaMasAlta(pieza);
    }

}
