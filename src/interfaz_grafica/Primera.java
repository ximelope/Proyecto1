package interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modeloGaleria.Administrador;
import modeloGaleria.Comprador;
import modeloGaleria.Galeria;


public class Primera extends JFrame implements ActionListener {
	private Galeria galeria;
	private JButton loginButton;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JComboBox<String> userTypeComboBox;
	
	public Primera () {
		galeria= new Galeria();
		this.setSize(800, 800);
		this.setTitle("Galeria");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		// Crear el panel para el formulario de login
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(4, 2));

        // Crear los componentes del formulario
        JLabel userTypeLabel = new JLabel("Tipo de Usuario:");
        String[] userTypes = {"Administrador", "Cliente", "Empleado"};
        userTypeComboBox = new JComboBox<>(userTypes);

        JLabel usernameLabel = new JLabel("Usuario:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");

     // Añadir los componentes al panel
        loginPanel.add(userTypeLabel);
        loginPanel.add(userTypeComboBox);
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel());  // Añadir un espacio vacío
        loginPanel.add(loginButton);
        loginButton.addActionListener(this);

        // Añadir el panel al marco principal
        this.add(loginPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == loginButton) {
			String userType = (String) userTypeComboBox.getSelectedItem();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Verificar las credenciales (esto es solo un ejemplo simple)
            if (galeria.getUsuarios().containsKey(username) &&  String.valueOf(galeria.getUsuarios().get(username)).equals(password)) {
                // Si la contraseña es correcta, cambiar a la pantalla de opciones
            	if (userType =="Administrador") {
            		Administrador administrador = new Administrador(username,password);
            		new InterfazAdministrador(administrador, galeria);
            	}else if (userType == "Cliente") {
            		Comprador comprador = galeria.getClientes().get(username);
            		new InterfazCliente(galeria, comprador);
            		
            	}else {
            		new InterfazEmpleado();
            	}
                
            } else {
                // Mostrar mensaje de error
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
		}
		
	}
	public static void main(String[] args) {
		new Primera();
	}
	


}