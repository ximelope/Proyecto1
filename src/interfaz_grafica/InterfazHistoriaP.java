package interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modeloGaleria.Galeria;
import modeloGaleria.Usuario;

public class InterfazHistoriaP extends JFrame implements ActionListener {
	private JTextField nameField;
	private JButton submitButton ;
	private Usuario usuario;
	private Galeria galeria; 
	
	public InterfazHistoriaP(Usuario usuario, Galeria galeria) {
		this.galeria = galeria;
		this.usuario= usuario; 
		this.setSize(800, 800);
		this.setTitle("Historia de una Pieza ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JLabel menu = new JLabel("Historia de una Pieza");
		JPanel titulo = new JPanel();
		titulo.setLayout(new FlowLayout());
		titulo.add(menu);
		this.add(titulo, BorderLayout.NORTH);
		
		JPanel personaPanel = new JPanel();
        personaPanel.setLayout(new GridLayout(2, 2));

        JLabel nameLabel = new JLabel("Nombre de la Pieza:");
        nameField = new JTextField();

        submitButton = new JButton("Enviar");
        personaPanel.add(nameLabel);
        personaPanel.add(nameField);
        personaPanel.add(new JLabel());  // Añadir un espacio vacío
        personaPanel.add(submitButton);
        submitButton.addActionListener(this);
        this.add(personaPanel, BorderLayout.CENTER);
        this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {
            String username = nameField.getText();
            String respuesta = usuario.historiaPiezaInterfaz(galeria.getPiezas().get(username));
            JOptionPane.showMessageDialog(this, respuesta, "Mensaje", JOptionPane.INFORMATION_MESSAGE);	
		}

		
	}
	
}