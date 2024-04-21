package modeloGaleria;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class Operador extends Usuario {
	HashMap<String, Subasta> subastas = new HashMap<>();

	public Operador(String login, String contrasena) {
		super(login, contrasena);
	}
	@SuppressWarnings("unused")
	public void cargarSubastas(File archivo,HashMap<String, Pieza> piezas,HashMap<String, Subasta> sub) {
		System.out.println("Cargando subastas desde Archivo");
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            linea = br.readLine();
            while (linea != null) {
                String[] partes = linea.split(";");
                String id = partes[0];
                String fechaInicial= partes[1];
                String fechaFinal = partes[2];
                String titulo= partes[3];
                Pieza pieza = piezas.get(titulo);
                Subasta subasta = crearSubasta(id,fechaInicial, fechaFinal, pieza);
                sub.put(subasta.getId(), subasta);
                
                linea = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public void crearSubasta_pedir (HashMap<String, Pieza> piezas,HashMap<String, Subasta> sub) {
		System.out.println("Crear Subasta, Digite la info necesaria");
        String id = input("Ingrese el id de 2 digitos y 2 letras de la subasta: ");
        String fechaInicial= input("Ingrese la fecha inicial de la subasta");
        String fechaFinal = input("Ingrese la fecha de terminacion de la subasta: ");
        String titulo = input("Ingrese el titulo de la pieza: ");
        Pieza pieza = piezas.get(titulo);
        Subasta subasta = crearSubasta(id,fechaInicial, fechaFinal, pieza);
        sub.put(subasta.getId(), subasta);
	}
	public String input (String mensaje) {
        try {
            System.out.print(mensaje + ": ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
	}
	private Subasta crearSubasta(String id, String fechaInicial, String fechaFinal, Pieza pieza) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		
			Date fechaInicialDate = null;
			try {
				fechaInicialDate = formatoFecha.parse(fechaInicial);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Date fechaFinalDate = null;
			try {
				fechaFinalDate = formatoFecha.parse(fechaFinal);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Subasta subasta = new Subasta(id, fechaInicialDate, fechaFinalDate, pieza);
			subastas.put(subasta.getId(), subasta);
		return subasta;
	}
	@SuppressWarnings("unused")
	private void RegistrarOferta(HashMap<String, Comprador> clientes,String fecha, float monto, String login, String contraseña, String correo,int numero, int valorMax, String idSubasta, Pieza pieza, Administrador administrador)  {
		Comprador cliente = crearCliente(clientes, login, contraseña, correo, numero, valorMax);
		int valorInicial = subastas.get(idSubasta).getPieza().getValorMinimoSubasta()*3/4;
		Date fechaInicial = subastas.get(idSubasta).getFechaInicial();
		Date fechaFinal = subastas.get(idSubasta).getFechaFinal();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		Date parsedFecha = null;
		try {
			parsedFecha = formatoFecha.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				if (monto >= valorInicial) {
					if (parsedFecha.compareTo(fechaFinal) <= 0 || parsedFecha.compareTo(fechaInicial) >= 0) {
						if ("Verificado".equals(cliente.getEstado())) {
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
