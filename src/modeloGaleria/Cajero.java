package modeloGaleria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cajero extends Usuario{
	static HashMap<String, List<Registro>> pagos = new HashMap<>();

	public Cajero(String login, String contrasena) {
		super(login, contrasena);
	}
	public void confirmarPago(Registro registro) {
		String estado = registro.getCliente().getEstado();
		Comprador cliente = (Comprador) registro.getCliente();
		if (estado.equals("Verificado")) {
			Propietario propietario = new Propietario(cliente.getLogin(), cliente.getContrasena(), cliente.getCorreoElectronico(), cliente.getNumeroDeTelefono());
			registro.getPieza().setPropietario(propietario);
			if (pagos.containsKey(cliente.getLogin())) {
				pagos.get(cliente.getLogin()).add(registro);
			} else {
				List<Registro> registros = new ArrayList<>();
    			registros.add(registro);
				pagos.put(cliente.getLogin(), registros);				
			}
		}
		
	}
	public void crearVenta(Pieza pieza, String fechaVenta ) {
		Venta venta = new Venta(Pieza pieza, String fechaVenta);
	}
	
}
