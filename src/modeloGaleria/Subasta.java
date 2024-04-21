package modeloGaleria;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Subasta {
	private Date fechaInicial;
	private Date fechaFinal;
	private Pieza pieza;
	private List<Registro> registros;
	private String id;

	public Subasta(String id, Date fechaInicial, Date fechaFinal, Pieza pieza) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.pieza = pieza;
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
	public Pieza getPieza() {
		return pieza;
	}

	
	public String getId() {
		return id;
	}

	public Registro getUltimoRegistro() {
		if (!registros.isEmpty()) {
				return registros.get(registros.size() - 1);
			} else {
				return null; // O lanzar una excepción.
			}
	}

	public void confirmarPagoCajero (Registro registro, Cajero cajero) {
		if (getUltimoRegistro()!= null){
			cajero.confirmarPago(getUltimoRegistro());
		}
	}
}
