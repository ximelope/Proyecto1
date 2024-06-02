package Tarjetalol;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import modeloGaleria.Galeria;

public class Sire implements PaymentGateway {
    @Override
    public PaymentResult processPayment(CreditCardInfo cardInfo, PaymentInfo paymentInfo, String Date) {
        PaymentResult result = new PaymentResult();
        
        if (cardInfo.getCardNumber().length() != 16) {
            result.setSuccess(false);
            result.setMessage("Invalid card number. The card number must be 16 digits long.");
            JOptionPane.showMessageDialog(null, result.getMessage(), "Payment Status", JOptionPane.ERROR_MESSAGE);
            return result;
        }
        
        result.setSuccess(true); 
        result.setMessage("Payment successful with Sire.");
        
        if (result.isSuccess()) {
            JOptionPane.showMessageDialog(null, result.getMessage(), "Payment Status", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Payment failed", "Payment Status", JOptionPane.ERROR_MESSAGE);
        }
        
        logTransaction("./src/data/transacciones.txt", cardInfo, paymentInfo, result, Date);
        Galeria.addSale(Date, paymentInfo);
        return result;
    }
   
    private void logTransaction(String fileName, CreditCardInfo cardInfo, PaymentInfo paymentInfo, PaymentResult result, String Date) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(Date + ";" + cardInfo.getCardHolderName()+ ";" + cardInfo.getExpiryDate()+ ";" +(result.isSuccess() ? "Success" : "Failure")+ ";" + result.getMessage());
            writer.newLine(); 
    	} catch (IOException e) {
            e.printStackTrace();
        }
    }
}

