package Tarjetalol;

public class PaymentInfo {
    private String nombre;
    private String status;

    public PaymentInfo(String nombre, String status) {
        this.nombre = nombre;
        this.status = status;
    }

    public String getnombre() {
        return nombre;
    }

    public String getAccountNumber() {
        return status;
    }

}
