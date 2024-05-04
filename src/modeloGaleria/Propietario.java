package modeloGaleria;

public class Propietario extends Usuario{
	private String correoElectronico;
	private int numeroDeTelefono;
	private String piezas;
	
	public Propietario (String login, String contraseña, String correo, int numero, String piezas) {
		super(login,contraseña);
		this.correoElectronico= correo;
		this.numeroDeTelefono= numero;
		this.piezas= piezas;
	}
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	
	public int getNumeroDeTelefono() {
		return numeroDeTelefono;
	}
	public String getPiezas() {
		return piezas;
	}

}


