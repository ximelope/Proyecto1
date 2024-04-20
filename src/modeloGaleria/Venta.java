package modeloGaleria;
import java.util.Random;

public class Venta {

    private Pieza pieza;
    private int numeroFactura;

    public Venta() {
        this.numeroFactura = generarNumeroFactura();
    }
    
    public Pieza getPieza() {
        return pieza;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    private int generarNumeroFactura() {
        Random rand = new Random();
        // Genera un número aleatorio entre 1000 y 9999.
        return 1000 + rand.nextInt(9000);
    }

    public boolean efectuarVenta (Pieza pieza){
        if (pieza.isPermisoVenta() == true && pieza.getEstadoDePieza().equals("Disponible")){
            pieza.estadoDePieza = "Vendida";  
            return true;    
        }
        return false;
    }
}
