package modeloGaleria;
import java.util.Date;

public class Subasta {
	private Date fechaInicial;
	private Date fechaFinal;
	private Pieza pieza;
	private float valorInicial;
	private float valorMinimo;
	
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
	public float getValorInicial() {
		return valorInicial;
	}

	public float getValorMinimo() {
		return valorMinimo;
	}
	public Pieza getPieza() {
		return pieza;
	}
}
