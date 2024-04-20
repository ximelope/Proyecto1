package modeloGaleria;
import java.util.Collection;

public class Comprador extends Usuario{
    private String correoElectronico;
    private int numeroDeTelefono;
    public boolean verificado;
    private double valorMax;
    protected Collection<Pieza> infocompras;
	
    public Comprador (String login, String contraseña, String rol, String correo, int numero, double valorMax) {
        super(login,contraseña,rol);
        this.correoElectronico= correo;
        this.numeroDeTelefono= numero;
        this.valorMax = valorMax;
        this.verificado = false;
    }
    
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public int getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public double getValorMax() {
        return valorMax;
    }
    public boolean isVerificado() {
        return verificado;
    }
    
    public void setVerificado(boolean verificado) {
        this.verificado = verificado; }

    public void comprarObra(Pieza pieza) {
        this.infocompras.add(pieza);
    }

}

	
	