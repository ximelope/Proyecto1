package modeloGaleria;
import java.util.Random;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Venta {

    private Pieza pieza;
    private int numeroFactura;
    private String fechaVenta;
    private Cajero cajero;

    
    public Pieza getPieza() {
        return pieza;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public String getFechaVenta() {
        return this.fechaVenta;
    }

    private int generarNumeroFactura() {
        Random rand = new Random();
        // Genera un número aleatorio entre 1000 y 9999.
        return 1000 + rand.nextInt(9000);
    }

    public Venta(Pieza pieza, String fechaVenta, Cajero cajero) {
        this.numeroFactura = generarNumeroFactura();
        this.pieza= pieza;
        this.fechaVenta= fechaVenta;
        this.cajero= cajero;
    }
    public boolean efectuarVenta (Pieza pieza, Comprador cliente){
        if (pieza.isPermisoVenta() == true && pieza.getEstadoDePieza().equals("Disponible")){
            pieza.estadoDePieza = "Vendida";  
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            Date ParsedFecha= null;
            try {
            	ParsedFecha = formatoFecha.parse(fechaVenta);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Registro registro = new Registro(ParsedFecha, pieza.getValorFijo(), cliente, pieza);
            cajero.confirmarPago(registro);
            return true;
        }
		return false;
    }
}