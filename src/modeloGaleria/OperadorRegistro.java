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
	private Comprador comprador;
	private Subasta subasta;
	private double valorInicial;
	private double valorMinimo;
	private Pieza pieza;
	private Map<Pieza, Map<Comprador, Double>> ofertasRegistro = new HashMap<>();
	//Preguntar lo del formato de fecha
	
	public OperadorRegistro(Date fecha, float monto, Comprador comprador, Subasta subasta, float valorMinimo, Date fechaInicial, Date fechaFinal, Pieza pieza) 
	{
		this.fecha = fecha;
		this.monto = monto;
		this.subasta = new Subasta(fechaInicial, fechaFinal, pieza);
		this.valorInicial = (subasta.getValorInicial());
		this.valorMinimo = (subasta.getValorMinimo());
		this.fechaInicial = (subasta.getFechaInicial());
		this.fechaFinal = (subasta.getFechaFinal());
		this.pieza = (subasta.getPieza());
		this.comprador = comprador;
		this.pieza = pieza;
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
	
	public Comprador getComprador() {
		return comprador;
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
	
	public void ofertasSubastaRegistro (Pieza pieza, Comprador comprador, double monto, Date fecha, Date fechaInicial, Date fechaFinal, double valorInicial) {
		if (monto >= valorInicial) {
			if (fecha.compareTo(fechaFinal) <= 0 || fecha.compareTo(fechaInicial) >= 0) {
				if (!ofertasRegistro.containsKey(pieza)) {
					ofertasRegistro.put(pieza, new HashMap<>());
				}
				ofertasRegistro.get(pieza).put(comprador, monto);
		   }   
	   }
   }

	public Map.Entry<Comprador, Double> getOfertaMasAlta(Pieza pieza) {
	    if (ofertasRegistro.containsKey(pieza)) {
	        return Collections.max(ofertasRegistro.get(pieza).entrySet(), Map.Entry.comparingByValue());
	    }
	    return null;
	}

	public Comprador getCompradorOfertaMasAlta(Pieza pieza) {
		Map.Entry<Comprador, Double> ofertaMasAlta = getOfertaMasAlta(pieza);
		if (ofertaMasAlta != null) {
			return ofertaMasAlta.getKey();
		}
		return null;
	}
}
