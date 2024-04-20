package modeloGaleria;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Avion;

public class Subasta {
	private Date fechaInicial;
	private Date fechaFinal;
	private Pieza pieza;
	private int valorInicial;
	private int valorMinimo;
	private List<Registro> registros;
	private String id;

	public Subasta(String id, Date fechaInicial, Date fechaFinal, Pieza pieza) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.pieza = pieza;
        this.valorInicial = (pieza.getValorMinimoSubasta())*(3/4);
        this.valorMinimo = pieza.getValorMinimoSubasta();
        this.id  = id;
        registros = new LinkedList<Registro>( );
    }
	public Collection<Registro> getRegistros (){
		return registros;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public int getValorInicial() {
		return valorInicial;
	}

	public int getValorMinimo() {
		return valorMinimo;
	}
	public Pieza getPieza() {
		return pieza;
	}
	public Comprador getComprador() {
		return comprador;
	}
	public String getId() {
		return id;
	}

// Escoger el ultimo, y a ese mandarselo a administrador para que haga el cambio de tipo
	public void setNombreCompradorDesdeRegistro(OperadorRegistro registro, Pieza pieza) {
		if (registro.getCompradorOfertaMasAlta(pieza) == null) {
			this.comprador = null;
		}
		else this.comprador = registro.getCompradorOfertaMasAlta(pieza);
    }

}
