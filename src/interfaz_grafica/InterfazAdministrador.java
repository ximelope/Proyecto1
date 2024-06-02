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

import modeloGaleria.Administrador;
import modeloGaleria.Galeria;



public class InterfazAdministrador extends JFrame implements ActionListener {
	private Galeria galeria;
	private JButton botones[][] = new JButton[5][1];
	private Administrador  administrador;
	public InterfazAdministrador (Administrador administrador, Galeria galeria) {
		this.galeria = galeria;
		this.administrador = administrador;
		
		this.setSize(800, 800);
		this.setTitle("Administrador");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		JLabel menu = new JLabel("Menú Administrador");
		JPanel titulo = new JPanel();
		titulo.setLayout(new FlowLayout());
		titulo.add(menu);
		this.add(titulo, BorderLayout.NORTH);
		
		JPanel menuBotones = new JPanel();
		menuBotones.setLayout(new GridLayout(5, 1, 10, 10));
		this.botones[1][0] = new JButton("1.) Mostrar los titulos que se encuentran en el inventario");
		this.botones[1][0].addActionListener(this);
		menuBotones.add(this.botones[1][0]);
		this.botones[2][0] = new JButton("2.) Mostrar la historia de una pieza");
		this.botones[2][0].addActionListener(this);
		menuBotones.add(this.botones[2][0]);
		this.botones[3][0] = new JButton("3.) Mostrar la historia de un artista");
		this.botones[3][0].addActionListener(this);
		menuBotones.add(this.botones[3][0]);
		this.botones[4][0] = new JButton("4.) Mostrar la historia de un comprador");
		this.botones[4][0].addActionListener(this);
		menuBotones.add(this.botones[4][0]);
		this.botones[0][0] = new JButton("5.) Ventas realizadas en el año");
		this.botones[0][0].addActionListener(this);
		menuBotones.add(this.botones[0][0]);
		this.add(menuBotones, BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bOprimido = (JButton)e.getSource();
		if (bOprimido.getText()=="1.) Mostrar los titulos que se encuentran en el inventario") {
			JOptionPane.showMessageDialog(this,galeria.getPiezas().keySet(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (bOprimido.getText()=="2.) Mostrar la historia de una pieza") {
			new InterfazHistoriaP(administrador, galeria);
		}
		else if (bOprimido.getText()=="3.) Mostrar la historia de un artista") {
			new InterfazHistoriaA(administrador, galeria);
		}
		else if (bOprimido.getText()=="4.) Mostrar la historia de un comprador") {
			new IntergazHistoriaC(administrador, galeria);
		}
		else if (bOprimido.getText()=="5.) Ventas realizadas en el año") {
			DiagramaVentas.showChart(galeria);
		}
	}
	
}