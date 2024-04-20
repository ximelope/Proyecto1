package modeloGaleria;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class Operador extends Usuario {
	HashMap<String, Subasta> subastas = new HashMap<>();

	public Operador(String login, String contrasena) {
		super(login, contrasena);
	}
	@SuppressWarnings("unused")
	private void crearSubasta(String id, String fechaInicial, String fechaFinal, Pieza pieza) throws ParseException {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		
			Date fechaInicialDate = formatoFecha.parse(fechaInicial);
			Date fechaFinalDate = formatoFecha.parse(fechaFinal);

			Subasta subasta = new Subasta(id, fechaInicialDate, fechaFinalDate, pieza);
			subastas.put(subasta.getId(), subasta);
	}
	@SuppressWarnings("unused")
	private void RegistrarOferta(HashMap<String, Comprador> clientes,String fecha, float monto, String login, String contraseña, String correo,int numero, int valorMax, String idSubasta, Pieza pieza) throws ParseException {
		Comprador cliente = crearCliente(clientes, login, contraseña, correo, numero, valorMax);
		int valorInicial = subastas.get(idSubasta).getPieza().getValorMinimoSubasta()*3/4;
		Date fechaInicial = subastas.get(idSubasta).getFechaInicial();
		Date fechaFinal = subastas.get(idSubasta).getFechaFinal();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
			Date parsedFecha = formatoFecha.parse(fecha);
				if (monto >= valorInicial) {
					if (parsedFecha.compareTo(fechaFinal) <= 0 || parsedFecha.compareTo(fechaInicial) >= 0) {
						if (Administrador.verificacionDeCliente(cliente) == true) {
							Registro registro = new Registro(parsedFecha, monto, cliente, pieza);
							Subasta subasta = subastas.get(idSubasta);
							(subasta.getRegistros()).add(registro);
						}
					}
				}
			}

	private Comprador crearCliente(HashMap<String, Comprador> clientes,String login, String contraseña, String correo,int numero, int valorMax) {
				Comprador cliente= new Comprador(login, contraseña, correo, numero, valorMax);
				clientes.put(cliente.getLogin(), cliente);
				return cliente;
			}
		}
