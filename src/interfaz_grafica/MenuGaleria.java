package interfaz_grafica;

import javax.swing.*;
import Tarjetalol.CreditCardForm;
import Tarjetalol.PaymentResult;
import modeloGaleria.Galeria;
import modeloGaleria.Pieza;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

public class MenuGaleria {
    private Galeria galeria;
    private JPanel selectedPiezaPanel;

    public MenuGaleria(Galeria galeria) {
        this.galeria = galeria;
        crearMenu();
    }

    private void crearMenu() {
        JFrame frame = new JFrame("Galería de Arte");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Piezas Disponibles para la Venta", JLabel.CENTER);
        mainPanel.add(titulo, BorderLayout.NORTH);

        JPanel piezasPanel = new JPanel();
        piezasPanel.setLayout(new GridLayout(0, 2, 10, 10));
        piezasPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (Map.Entry<String, Pieza> entry : galeria.getPiezas().entrySet()) {
            Pieza pieza = entry.getValue();
            JPanel piezaPanel = crearPanelPieza(pieza);
            piezasPanel.add(piezaPanel);
        }

        JScrollPane scrollPane = new JScrollPane(piezasPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JButton pagarButton = new JButton("Pagar");
        pagarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarMetodosDePago(frame);
            }
        });

        JPanel botonPanel = new JPanel();
        botonPanel.add(pagarButton);
        mainPanel.add(botonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }

    private JPanel crearPanelPieza(Pieza pieza) {
        JPanel piezaPanel = new JPanel();
        piezaPanel.setLayout(new BoxLayout(piezaPanel, BoxLayout.Y_AXIS));
        piezaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        piezaPanel.setBackground(Color.WHITE);

        JLabel tituloPieza = new JLabel(pieza.getTitulo(), JLabel.CENTER);
        piezaPanel.add(tituloPieza);

        piezaPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionarPieza(piezaPanel);
            }
        });

        return piezaPanel;
    }

    private void seleccionarPieza(JPanel piezaPanel) {
        if (selectedPiezaPanel != null) {
            selectedPiezaPanel.setBackground(Color.WHITE);
        }
        piezaPanel.setBackground(Color.LIGHT_GRAY);
        selectedPiezaPanel = piezaPanel;
    }

    private void mostrarMetodosDePago(JFrame parentFrame) {
        if (selectedPiezaPanel == null) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una pieza antes de proceder al pago.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        CreditCardForm dialog = new CreditCardForm(parentFrame);
        dialog.setVisible(true);

        PaymentResult result = dialog.getPaymentResult();
        if (result != null) {
            JOptionPane.showMessageDialog(null, result.getMessage(), "Payment Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Payment not processed", "Payment Result", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new MenuGaleria(new Galeria());
    }
}
