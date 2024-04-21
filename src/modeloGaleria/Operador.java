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
	public String ganador(String id ) {
		Subasta subasta = subastas.get(id);
		Registro registro = subasta.getUltimoRegistro();
		String nombre = registro.getCliente().getLogin();
		return "El ganador de la subasta es: " + nombre;
	}
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
        String id = input("Ingrese el id de 2 digitos y 2 letras de la subasta(00aa,00bb,00cc): ");
        String fechaInicial= input("Ingrese la fecha inicial de la subasta");
        String fechaFinal = input("Ingrese la fecha de terminacion de la subasta: ");
        String titulo = input("Ingrese el titulo de la pieza: ");
        Pieza pieza = piezas.get(titulo);
        Subasta subasta = crearSubasta(id,fechaInicial, fechaFinal, pieza);
        sub.put(subasta.getId(), subasta);
      
	}
	public void crearRegistro_pedir(HashMap<String, Pieza> piezas, HashMap<String, Registro> registros,HashMap<String, Comprador> clientes, Administrador administrador) {
		System.out.println("Crear Registro, Digite la info necesaria");
        String fecha = input("Ingrese la fecha del registro ");
        float monto= Float.parseFloat(input("Ingrese el monto ofrecido"));
        String login= input("Ingrese el login del comprador");
        String contrasena = input("Ingrese la contraseña del comprador: ");
        String correo = input("Ingrese el correo del comprador: ");
        int numero= Integer.parseInt(input("Ingrese el numero de telefono del comprador(8 digitos)"));
        int valorMax= Integer.parseInt(input("Ingrese el valorMaximo del comprador"));
        String titulo= input("Ingresr el titulo");
        String idSubasta = input("Ingrese el id de la oferta (00aa,00bb,00cc");
        Pieza pieza = piezas.get(titulo);
        registrarOferta(registros, clientes,fecha, monto, login, contrasena, correo, numero, valorMax, idSubasta, pieza, administrador );
	}
	public void cargarRegistros(File archivo,HashMap<String, Pieza> piezas, HashMap<String, Registro> registros,HashMap<String, Comprador> clientes, Administrador administrador) {
		System.out.println("Cargando Registros desde Archivo");
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            linea = br.readLine();
            while (linea != null) {
                String[] partes = linea.split(";");
                String fecha = partes[0];
                float monto= Float.parseFloat(partes[1]);
                String login = partes[2];
                String contrasena= partes[3];
                String correo= partes[4];
                int numero= Integer.parseInt(partes[5]);
                int valorMax = Integer.parseInt(partes[6]);
                String titulo= partes[7];
                String idSubasta= partes[8];
                Pieza pieza = piezas.get(titulo);
                registrarOferta(registros, clientes,fecha, monto, login, contrasena, correo, numero, valorMax, idSubasta, pieza, administrador );
                
                linea = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
	
	
	private void registrarOferta(HashMap<String, Registro> registros,HashMap<String, Comprador> clientes,String fecha, float monto, String login, String contraseña, String correo,int numero, int valorMax, String idSubasta, Pieza pieza, Administrador administrador)  {
		Comprador cliente = crearCliente(clientes, login, contraseña, correo, numero, valorMax);
		administrador.verificacionDeCliente(cliente);
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
			if (parsedFecha.after(fechaInicial) && parsedFecha.before(fechaFinal)) {
				if ("Verificado".equals(cliente.getEstado())) {
					Registro registro = new Registro(parsedFecha, monto, cliente, pieza,subastas.get(idSubasta));
					registros.put(String.valueOf(registro.getMonto()), registro);
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

