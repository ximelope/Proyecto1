package modeloGaleria;
import java.util.Collection;

public class Comprador extends Usuario{
    private String correoElectronico;
    private int numeroDeTelefono;
    private String estado;// Verificado, Bloqueado, NoAplica
    private int valorMax;
    protected Collection<Pieza> infocompras;
	
    public Comprador (String login, String contraseña, String correo, int numero, int valorMax) {
        super(login,contraseña);
        this.correoElectronico= correo;
        this.numeroDeTelefono= numero;
        this.valorMax = valorMax;
        this.estado = "NoAplica";
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
    public void cambiarEstado( String nuevoEstado) {
    	this.estado= nuevoEstado;
    }

    public void comprarObra(Pieza pieza) {
        Venta venta = new Venta();
        if (venta.efectuarVenta(pieza, this) == true) {
            this.infocompras.add(pieza);}
    }

}

	
	