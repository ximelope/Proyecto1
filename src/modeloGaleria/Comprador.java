package modeloGaleria;
import java.util.ArrayList;
import java.util.Collection;

public class Comprador extends Usuario{
    private String correoElectronico;
    private int numeroDeTelefono;
    private String estado;// Verificado, Bloqueado, NoAplica
    private int valorMax;
    public Collection<Pieza> infocompras;
   	private String piezas;
    private String fechas;
	
    public Comprador (String login, String contraseña, String correo, int numero, int valorMax, String piezas, String fechas) {
        super(login,contraseña);
        this.correoElectronico= correo;
        this.numeroDeTelefono= numero;
        this.valorMax = valorMax;
        this.estado = "NoAplica";
        this.piezas= piezas;
        this.fechas= fechas;
        this.infocompras = new ArrayList<Pieza>();
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    
    public int getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public int getValorMax() {
        return valorMax;
    }
    public String getEstado() {
        return estado;
    }
    public String getPiezas() {
        return piezas;
    }
    public String getFechas() {
        return fechas;
    }
    public void cambiarEstado( String nuevoEstado) {
    	this.estado= nuevoEstado;
    }
    public Collection<Pieza> getInfocompras() {
		return infocompras;
	}

	public void setInfocompras(Collection<Pieza> infocompras) {
		this.infocompras = infocompras;
	}

    
    public void comprarObra(Pieza pieza) {
        Venta venta = new Venta(pieza,"22-04-2024");
        if (venta.efectuarVenta(pieza, this) == true) {
            this.infocompras.add(pieza);}
    }

}

	
	