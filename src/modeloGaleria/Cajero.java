package modeloGaleria;
import java.util.HashMap;
import java.util.List;

public class Cajero extends Usuario{
	HashMap<String, List<Registro>> pagos = new HashMap<>();

	public Cajero(String login, String contrasena) {
		super(login, contrasena);
	}
	public void confirmarPago(Registro registro, String tipoPago) {
		String estado = registro.getCliente().getEstado();
	Comprador cliente = (Comprador) registro.getCliente().clone();
		if (estado.equals("Verificado")) {
			Propietario propietario = new Propietario(cliente.getLogin(), cliente.getContrasena(), cliente.getCorreoElectronico(), cliente.getNumeroDeTelefono());
			registro.getPieza().setPropietario(propietario);
			if (pagos.containsKey(cliente.getLogin())) {
				pagos.get(cliente.getLogin()).add(registro);
			} else {
				pagos.put(cliente.getLogin(), List.of(registro));				
			}
		}
		
	}
}
