package modeloGaleria;
import java.util.Date;

public class Subasta {
	private Date fechaInicial;
	private Date fechaFinal;
	private Pieza pieza;
	private double valorInicial;
	private double valorMinimo;
	private String nombreComprador;
	private String tituloPieza;

	public Subasta(Date fechaInicial, Date fechaFinal, Pieza pieza) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.pieza = pieza;
        this.valorInicial = (pieza.getValorMinimoSubasta())*(3/4);
        this.valorMinimo = pieza.getValorMinimoSubasta();
		this.tituloPieza = (pieza.getTitulo());
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

	public void setNombreCompradorDesdeRegistro(OperadorRegistro registro, String tituloObra) {
		if (registro.getCompradorOfertaMasAlta(tituloObra) == null) {
			this.nombreComprador = "No hay comprador";
		}
		else this.nombreComprador = registro.getCompradorOfertaMasAlta(tituloObra);
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

	public String getTituloPieza() {
		return tituloPieza;
	}
}
