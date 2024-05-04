package modeloGaleria;
import java.util.Collection;

public class Comprador extends Usuario{
    private String correoElectronico;
    private int numeroDeTelefono;
    private String estado;// Verificado, Bloqueado, NoAplica
    private int valorMax;
    protected Collection<Pieza> infocompras;
    private String piezas;
	
    public Comprador (String login, String contraseña, String correo, int numero, int valorMax, String piezas) {
        super(login,contraseña);
        this.correoElectronico= correo;
        this.numeroDeTelefono= numero;
        this.valorMax = valorMax;
        this.estado = "NoAplica";
        this.piezas= piezas;
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
    public void cambiarEstado( String nuevoEstado) {
    	this.estado= nuevoEstado;
    }

    
    public void comprarObra(Pieza pieza) {
        Venta venta = new Venta(pieza,"22-04-2024");
        if (venta.efectuarVenta(pieza, this) == true) {
            this.infocompras.add(pieza);}
    }

}

	
	