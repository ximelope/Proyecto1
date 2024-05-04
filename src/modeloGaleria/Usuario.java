package modeloGaleria;

public abstract class Usuario {
	protected String login;
	protected String contrasena;
	
	public String getLogin() {
		return login;
	}
	public String getContrasena() {
		return contrasena;
	}
	
	
	public Usuario (String login, String contrasena) {
		this.contrasena = contrasena;
		this.login = login; 
	}
	public void historiaDePieza(Pieza pieza) {
		String propie= pieza.getPropietarios();
		String[] partes = propie.split("-");
		

		for (String parte : partes) {
		    System.out.println(parte);
		}
		
	}
	
}
