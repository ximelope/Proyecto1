package modeloGaleria;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

//hola prueba
public class Cajero extends Usuario{
	static HashMap<String, List<Registro>> pagos = new HashMap<>();

	public Cajero(String login, String contrasena) {
		super(login, contrasena);
	}
	public void cargarVenta(File archivo, HashMap<String, Pieza> piezas,HashMap<String, Comprador> clientes,HashMap<String, Venta> ventas) {
		System.out.println("Cargando Registros desde Archivo");
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            linea = br.readLine();
            while (linea != null) {
                String[] partes = linea.split(";");
                String titulo = partes[0];
                String fecha = partes[1];
                String login= partes[2];
                Pieza pieza = piezas.get(titulo);
                Comprador comprador= clientes.get(login);
                crearVenta(pieza,fecha,comprador, ventas);
                
                linea = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public void pedirVenta(HashMap<String, Pieza> piezas,HashMap<String, Comprador> clientes, HashMap<String, Venta> ventas) {
		String titulo = input("Ingrses el titulo de la pieza a vender");
        String fecha = input("Ingrese la fecha de hoy");
        String login= input("Ingrese el usuario de el cliente que la compra");
        Pieza pieza = piezas.get(titulo);
        Comprador comprador= clientes.get(login);
        crearVenta(pieza,fecha,comprador, ventas);
	}
	
	
	public void  crearVenta(Pieza pieza, String fecha, Comprador comprador,HashMap<String, Venta> ventas) {
		Venta venta = new Venta (pieza, fecha);
		ventas.put(venta.getPieza().getTitulo() , venta);
		if (venta.efectuarVenta(pieza, comprador)==true) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        Date ParsedFecha = null;
			try {
				ParsedFecha = sdf.parse(fecha);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Registro registro = new Registro(ParsedFecha, pieza.getValorFijo(), comprador, pieza);
            confirmarPago(registro);
			
            
		}
	
	}
	public int darFactura(String titulo, HashMap<String, Venta> ventas) {
		Venta venta = ventas.get(titulo);
		int factura = venta.getNumeroFactura();
		return factura;
		
		
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
	
	public void confirmarPago(Registro registro) {
		String estado = registro.getCliente().getEstado();
		Comprador cliente = registro.getCliente();
		if (estado.equals("Verificado")) {
			Propietario propietario = new Propietario(cliente.getLogin(), cliente.getContrasena(), cliente.getCorreoElectronico(), cliente.getNumeroDeTelefono());
			registro.getPieza().cambiarPropietario(propietario);
			if (pagos.containsKey(cliente.getLogin())) {
				pagos.get(cliente.getLogin()).add(registro);
			} else {
				List<Registro> registros = new ArrayList<>();
    			registros.add(registro);
				pagos.put(cliente.getLogin(), registros);				
			}
		}
		
	}
	
	
}
