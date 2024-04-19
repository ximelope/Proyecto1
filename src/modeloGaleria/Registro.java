package modeloGaleria;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Registro {


	private Date fecha;
	private Date fechaInicial;
	private Date fechaFinal;
	private float monto;
	private String UsuarioComprador;
	private Subasta subasta;
	private float valorInicial;
	private float valorMinimo;
	private Pieza pieza;
	private final List<Pieza> piezasSubastadas;
	private Map<String, Map<String, Double>> ofertasRegistro;
	
	//Preguntar lo del formato de fecha
	
	public Registro(Date fecha, float monto, String UsuarioComprador, Subasta subasta, float valorMinimo, Date fechaInicial, Date fechaFinal, Pieza pieza) 
	{
		this.fecha = fecha;
		this.monto = monto;
		this.valorInicial = (subasta.getValorInicial());
		this.valorMinimo = (subasta.getValorMinimo());
		this.fechaInicial = (subasta.getFechaInicial());
		this.fechaFinal = (subasta.getFechaFinal());
		this.pieza = (subasta.getPieza());
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
	
	public float getMonto() {
		return monto;
	}
	
	public String getUsuarioComprador() {
		return UsuarioComprador;
	}
	
	public Subasta getSubasta() {
		return subasta;
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
	
	public void piezaVenta (Pieza pieza) {
		String tituloPieza = pieza.getTitulo();
		if (!ofertasRegistro.containsKey(tituloPieza)) {
			
		}
		
	}
	public void agregarOferta(String tituloObra, String nombreComprador, double montoOferta) {
	    if (!registroOfertas.containsKey(tituloObra)) {
	        registroOfertas.put(tituloObra, new HashMap<>());
	    }
	    registroOfertas.get(tituloObra).put(nombreComprador, montoOferta);
	}
	
	
	public void ofertasSubastaRegistro (float monto, float valorInicial) {
			
			if (monto >= valorInicial) {
				 if (fecha.compareTo(fechaFinal) <= 0 || fecha.compareTo(fechaInicial) >= 0) {
				       
				    
				}
				
				
			}
		}
}
