package Tarjetalol;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CreditCardForm extends JDialog {
    private JTextField cardNumberField;
    private JTextField cardHolderField;
    private JTextField expiryDateField;
    private JTextField dateField;
    private JTextField cvvField;
    private JButton submitButton;
    private boolean isSubmitted;
    private JComboBox<String> paymentGatewayComboBox;
    private PaymentResult paymentResult;
    private static Map<String, PaymentGateway> gateways = new HashMap<>();
    
    
    static {
        gateways.put("PayPal", new PayPal());
        gateways.put("PayU", new PayU());
        gateways.put("Sire", new Sire());
    }
    
    public CreditCardForm(JFrame parent) {
        super(parent, "Información de la tarjeta", true);
        setupUI();
        setupActions();
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        formPanel.add(new JLabel("Payment Gateway:"));
        paymentGatewayComboBox = new JComboBox<>(gateways.keySet().toArray(new String[0]));
        formPanel.add(paymentGatewayComboBox);

        formPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre componentes

        formPanel.add(new JLabel("Numero de tarjeta:"));
        cardNumberField = new JTextField(16);
        formPanel.add(cardNumberField);

        formPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre componentes

        formPanel.add(new JLabel("Nombre usuario:"));
        cardHolderField = new JTextField(30);
        formPanel.add(cardHolderField);

        formPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre componentes

        formPanel.add(new JLabel("Fecha expiración(MM/YYYY):"));
        expiryDateField = new JTextField(7);
        formPanel.add(expiryDateField);

        formPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre componentes

        formPanel.add(new JLabel("CVV:"));
        cvvField = new JTextField(3);
        formPanel.add(cvvField);
        
        JLabel dateLabel = new JLabel("Date:");
        dateField = new JTextField(new SimpleDateFormat("yyyy-MM-dd").format(new Date())); // Default to today's date
        formPanel.add(dateLabel);
        formPanel.add(dateField);
        
        formPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre componentes

        submitButton = new JButton("Submit");
        formPanel.add(submitButton);

        add(formPanel, BorderLayout.CENTER);

        setSize(600, 450);
        setLocationRelativeTo(null);
    }

    private void setupActions() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedGateway = (String) paymentGatewayComboBox.getSelectedItem();
                PaymentGateway gateway = gateways.get(selectedGateway);

                CreditCardInfo cardInfo = new CreditCardInfo(
                    cardNumberField.getText(),
                    cardHolderField.getText(),
                    expiryDateField.getText(),
                    cvvField.getText()
                );

                PaymentInfo paymentInfo = new PaymentInfo(cardHolderField.getText(), "succes"); // Simulated payment info

                paymentResult = gateway.processPayment(cardInfo, paymentInfo, dateField.getText());
                isSubmitted = true;
                setVisible(false);
            }
        });
    }
    public PaymentResult getPaymentResult() {
        return paymentResult;
    }

    public static void main(String[] args) {
        JFrame parentFrame = new JFrame();
        CreditCardForm dialog = new CreditCardForm(parentFrame);
        dialog.setVisible(true);

        PaymentResult result = dialog.getPaymentResult();
        if (result != null) {
            System.out.println(result.getMessage());
        } else {
            System.out.println("Payment not processed");
        }

        System.exit(0);
    }

}
