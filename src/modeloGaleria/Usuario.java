package modeloGaleria;

public abstract class Usuario {
	protected String login;
	protected String contraseña;
	private String rol;
	
	public Usuario (String login, String contraseña, String rol) {
		this.contraseña = contraseña;
		this.login = login; 
		this.rol = rol;
	}
	
	public String getRol() {
		return rol;
	}

}
