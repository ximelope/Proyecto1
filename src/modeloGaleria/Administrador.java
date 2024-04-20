package modeloGaleria;

import java.io.File;

public class Administrador extends Usuario {
	private Inventario inventario;
	public Inventario getInventario() {
		return inventario;
	}
	
	public Administrador (String login, String contraseña, String rol) {
		super(login, contraseña, rol);
		this.inventario = new Inventario();
	}
	protected void crearPiezadocumento(File documento) {
		
	}
	protected void crearPiezaEscultura(String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
			float valorFijo, float valorMinimoSubasta, String loginPropietario, String contraseñaPropietario,
			String correo, int numeroDeTelefono, float alto, float ancho, float profundidad, String material, float peso, boolean electricidad, 
			String otros) {
		Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
		Pieza pieza= new Escultura(titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,
				valorFijo, valorMinimoSubasta, propietario, alto, ancho, profundidad, material, peso, electricidad, otros);
	}
		
	protected void crearPiezaPintura(String titulo, int ano, String lugarCreacion, String autor, boolean exhibida, boolean permisoVenta,
			float valorFijo, float valorMinimoSubasta, String loginPropietario, String contraseñaPropietario,
			String correo, int numeroDeTelefono, float alto, float ancho, String materialBase, String tipoPinturas) {
		Propietario propietario = crearPropietario(loginPropietario, contraseñaPropietario, correo, numeroDeTelefono);
		Pieza pieza = new Pintura(titulo, ano, lugarCreacion, autor, exhibida, permisoVenta,valorFijo, valorMinimoSubasta, propietario,   )
		
	}
			
	private void crearPropietarioDocumento(File document) {
		
	}
	private Propietario crearPropietario(String loginPropietario, String contraseñaPropietario,
			String correo, int numeroDeTelefono) {
		String rol = "propietario";
		Propietario propietario = new Propietario(loginPropietario, contraseñaPropietario,rol, correo, numeroDeTelefono);
		return propietario;
	}
	private void añadirPieza (Pieza pieza) {
		
		
		
	}
	private void confirmarVenta () {
		
	}
}
