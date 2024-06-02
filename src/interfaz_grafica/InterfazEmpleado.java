package interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modeloGaleria.Cajero;
import modeloGaleria.Galeria;
import modeloGaleria.Operador;
import modeloGaleria.Usuario;

public class InterfazEmpleado extends JFrame implements ActionListener  {
	private Galeria galeria; 
	private String usuario;
	private String contrasena;
	private JButton botones[][] = new JButton[2][1];

	public InterfazEmpleado (Galeria galeria, String usuario, String contrasena) {
		this.galeria= galeria; 
		this.usuario= usuario; 
		this.contrasena= contrasena; 
		
		
		this.setSize(800, 800);
		this.setTitle("Empleado");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		JLabel menu = new JLabel("Ingresar como: ");
		JPanel titulo = new JPanel();
		titulo.setLayout(new FlowLayout());
		titulo.add(menu);
		this.add(titulo, BorderLayout.NORTH);
		
		JPanel menuBotones = new JPanel();
		menuBotones.setLayout(new GridLayout(2, 1, 10, 10));
		this.botones[0][0] = new JButton("Cajero ");
		this.botones[0][0].addActionListener(this);
		menuBotones.add(this.botones[0][0]);
		this.botones[1][0] = new JButton("Operador ");
		this.botones[1][0].addActionListener(this);
		menuBotones.add(this.botones[1][0]);
		this.add(menuBotones, BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		File subasta = new File("./src/data/Subastas.txt");
        File registro = new File("./src/data/Registros.txt");
        File ventas = new File("./src/data/Ventas.txt");
		JButton bOprimido = (JButton)e.getSource();
		if (bOprimido.getText()=="Cajero ") {
			Cajero cajero = new Cajero(usuario, contrasena);
			cajero.cargarVenta(ventas, galeria.getPiezas(), galeria.getClientes(), galeria.getVentas());
			new InterfazCajero(cajero, galeria);
		}
		else if (bOprimido.getText()=="Operador ") {
			Operador operador = new Operador(usuario, contrasena);
			operador.cargarSubastas(subasta, galeria.getPiezas(), galeria.getSubastas());
			operador.cargarRegistros(registro, galeria.getPiezas(),galeria.getRegistros(), galeria.getClientes(), galeria.getAdministrador());
			new InterfazOperador(operador, galeria);
		}
	}
	
	

}