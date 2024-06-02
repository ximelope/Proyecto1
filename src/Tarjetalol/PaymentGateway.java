package Tarjetalol;

public interface PaymentGateway {
    PaymentResult processPayment(CreditCardInfo cardInfo, PaymentInfo paymentInfo, String date);
}

