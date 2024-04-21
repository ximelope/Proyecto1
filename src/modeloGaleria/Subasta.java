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
<<<<<<< HEAD
			return pieza;
=======
		return pieza;
>>>>>>> branch 'master' of https://github.com/ximelope/Proyecto1.git
	}

	public String getId() {
<<<<<<< HEAD
			return id;
=======
		return id;
>>>>>>> branch 'master' of https://github.com/ximelope/Proyecto1.git
	}

	public Registro getUltimoRegistro() {
		if (!registros.isEmpty()) {
<<<<<<< HEAD
			return registros.get(registros.size() - 1);
		} else {
			return null; // O lanzar una excepción.
		}
=======
				return registros.get(registros.size() - 1);
			} else {
				return null; // O lanzar una excepción.
			}
>>>>>>> branch 'master' of https://github.com/ximelope/Proyecto1.git
	}

	public void confirmarPagoCajero (Registro registro) {
		if (getUltimoRegistro()!= null){
			Cajero.confirmarPago(getUltimoRegistro());
		}
	}
}
