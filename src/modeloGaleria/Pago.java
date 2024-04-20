package modeloGaleria;

public class Pago {
    private double monto;
    private Comprador comprador;
    private String tipoPago;
    
    public Pago(double monto, String fecha, String hora, String tipoPago, String estado) {
        this.monto = monto;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoPago = tipoPago;
        this.estado = estado;
    }
    
    public double getMonto() {
        return monto;
    }
    public String getFecha() {
        return fecha;
    }
    public String getHora() {
        return hora;
    }
    public String getTipoPago() {
        return tipoPago;
    }
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
    
    public String toString() {
        return "Monto: " + monto + " Fecha: " + fecha + " Hora: " + hora + " Tipo de Pago: " + tipoPago + " Estado: " + estado;
    }
}
