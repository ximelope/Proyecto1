package modeloGaleria;

import java.util.Date;
import java.util.HashMap;

public class Operador extends Usuario {
	HashMap<String, Subasta> subastas = new HashMap<>();

	public Operador(String login, String contrasena) {
		super(login, contrasena);
		// TODO Auto-generated constructor stub
	}
	private void crearSubasta(String id, Date fechaInicial, Date fechaFinal, Pieza pieza) {
		Subasta subasta = new Subasta(id, fechaInicial, fechaFinal, pieza);
		subastas.put(subasta.getId(), subasta);
	}
	private void RegistrarOferta(HashMap<String, Comprador> clientes,Date fecha, float monto, String login, String contraseña, String correo,int numero, int valorMax, String idSubasta, Pieza pieza) {
		Comprador cliente = crearCliente(clientes, login, contraseña, correo, numero, valorMax);
		//hace la comparacion 
		//Si la cumple crea el registro y despues añade ese registro a su respectiva subasta
		//Confirmar que el cliente este verificado
		Registro registro= new Registro(fecha, monto, cliente, pieza );
		Subasta subasta  = subastas.get(idSubasta);
		(subasta.getRegistros()).add(registro);
	}
	private Comprador crearCliente(HashMap<String, Comprador> clientes,String login, String contraseña, String correo,int numero, int valorMax) {
		Comprador cliente= new Comprador(login, contraseña, correo, numero, valorMax);
		clientes.put(cliente.getLogin(), cliente);
		return cliente;
	}
}
