package modeloGaleria;

public class Propietario extends Usuario{
	private String correoElectronico;
	private int numeroDeTelefono;
	
	public Propietario (String login, String contraseña, String rol, String correo, int numero) {
		super(login,contraseña,rol);
		this.correoElectronico= correo;
		this.numeroDeTelefono= numero;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public int getNumeroDeTelefono() {
		return numeroDeTelefono;
	}

}
