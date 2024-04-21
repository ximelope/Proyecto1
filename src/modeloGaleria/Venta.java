package modeloGaleria;
import java.util.Random;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Venta {

    private Pieza pieza;
    private int numeroFactura;
    private Date fechaVenta;

    public Venta(String fechaVentaString) {
        this.numeroFactura = generarNumeroFactura();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
			try {
				this.fechaVenta = formatoFecha.parse(fechaVentaString);
			} catch (ParseException e) {
				e.printStackTrace();
			};   
    }
    
    public Pieza getPieza() {
        return pieza;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public Date getFechaVenta() {
        return this.fechaVenta;
    }

    private int generarNumeroFactura() {
        Random rand = new Random();
        // Genera un número aleatorio entre 1000 y 9999.
        return 1000 + rand.nextInt(9000);
    }

    public boolean efectuarVenta (Pieza pieza, Comprador cliente){
        if (pieza.isPermisoVenta() == true && pieza.getEstadoDePieza().equals("Disponible")){
            pieza.estadoDePieza = "Vendida";  
            Registro registro = new Registro(fechaVenta, pieza.getValorFijo(), cliente, pieza);
            Cajero.confirmarPago(registro);
            return true; 
        }
        return false;
    }

}
