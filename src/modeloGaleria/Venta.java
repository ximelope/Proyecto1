package modeloGaleria;
import java.util.Random;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Venta {

    private Pieza pieza;
    private int numeroFactura;
    private String fechaVenta;

    
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

    public Venta(Pieza pieza, String fechaVenta) {
        this.numeroFactura = generarNumeroFactura();
        this.pieza= pieza;
        this.fechaVenta= fechaVenta;
    }
    public boolean efectuarVenta (Pieza pieza, Comprador cliente){
        if (pieza.isPermisoVenta() == true && pieza.getEstadoDePieza().equals("Disponible")){
            pieza.cambiarEstado("Vendida");  
            return true;
        }
		return false;
    }
   
}
