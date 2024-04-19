package modeloGaleria;

import java.io.File;

public class Administrador extends Usuario {
	
	public Administrador (String login, String contraseña, String rol) {
		super(login, contraseña, rol);
	}
	protected void crearPiezadocumento(File documento) {
		
	}
	protected void crearPieza(String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoSubasta,
			float valorFijo, float valorMinimoSubasta, String loginPropietario, String contraseñaPropietario,
			String correo, int numeroDeTelefono ) {
		
		
	}
	private void crearPropietario(File document) {
		
	}
	private void crearPieza (Pieza pieza) {
		
	}
	private void confirmarVenta () {
		
	}
}
