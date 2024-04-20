package modeloGaleria;
import java.util.Date;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class OperadorRegistro {


	private Date fecha;
	private Date fechaInicial;
	private Date fechaFinal;
	private double monto;
	private String UsuarioComprador;
	private Subasta subasta;
	private double valorInicial;
	private double valorMinimo;
	private Pieza pieza;
	private Map<String, Map<String, Double>> ofertasRegistro = new HashMap<>();
	private String tituloPieza;
	//Preguntar lo del formato de fecha
	
	public OperadorRegistro(Date fecha, float monto, String UsuarioComprador, Subasta subasta, float valorMinimo, Date fechaInicial, Date fechaFinal, Pieza pieza) 
	{
		this.fecha = fecha;
		this.monto = monto;
		this.valorInicial = (subasta.getValorInicial());
		this.valorMinimo = (subasta.getValorMinimo());
		this.fechaInicial = (subasta.getFechaInicial());
		this.fechaFinal = (subasta.getFechaFinal());
		this.pieza = (subasta.getPieza());
		this.UsuarioComprador = UsuarioComprador;
		this.tituloPieza = (subasta.getTituloPieza());
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public Date getFechaInicial() {
		return fechaInicial;
	}
	
	public Date getFechaFinal() {
		return fechaFinal;
	}
	
	public double getMonto() {
		return monto;
	}
	
	public String getUsuarioComprador() {
		return UsuarioComprador;
	}
	
	public Subasta getSubasta() {
		return subasta;
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

	public String getTituloPieza() {
		return tituloPieza;
	}
	
	public void ofertasSubastaRegistro (String tituloPieza, String UsuarioComprador, double monto, Date fecha, Date fechaInicial, Date fechaFinal, double valorInicial) {
		if (monto >= valorInicial) {
			if (fecha.compareTo(fechaFinal) <= 0 || fecha.compareTo(fechaInicial) >= 0) {
				if (!ofertasRegistro.containsKey(tituloPieza)) {
					ofertasRegistro.put(tituloPieza, new HashMap<>());
				}
				ofertasRegistro.get(tituloPieza).put(UsuarioComprador, monto);
		   }   
	   }
   }

	public Map.Entry<String, Double> getOfertaMasAlta(String tituloPieza) {
	    if (ofertasRegistro.containsKey(tituloPieza)) {
	        return Collections.max(ofertasRegistro.get(tituloPieza).entrySet(), Map.Entry.comparingByValue());
	    }
	    return null;
	}

	public String getCompradorOfertaMasAlta(String tituloObra) {
		Map.Entry<String, Double> ofertaMasAlta = getOfertaMasAlta(tituloObra);
		if (ofertaMasAlta != null) {
			return ofertaMasAlta.getKey();
		}
		return null;
	}
}
