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

import modeloGaleria.Comprador;
import modeloGaleria.Galeria;

public class InterfazCliente extends JFrame implements ActionListener {
	private Galeria galeria;
	private JButton botones[][] = new JButton[3][1];
	private Comprador cliente;

	public InterfazCliente (Galeria galeria, Comprador cliente) {
		this.cliente= cliente; 
		this.galeria= galeria; 
		
		this.setSize(800, 800);
		this.setTitle("Cliente");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		JLabel menu = new JLabel("Menú Cliente");
		JPanel titulo = new JPanel();
		titulo.setLayout(new FlowLayout());
		titulo.add(menu);
		this.add(titulo, BorderLayout.NORTH);
		
		JPanel menuBotones = new JPanel();
		menuBotones.setLayout(new GridLayout(3, 1, 10, 10));
		this.botones[0][0] = new JButton("1.) Mostrar la historia de una pieza");
		this.botones[0][0].addActionListener(this);
		menuBotones.add(this.botones[0][0]);
		this.botones[1][0] = new JButton("2.) Mostrar la historia de un artista");
		this.botones[1][0].addActionListener(this);
		menuBotones.add(this.botones[1][0]);
		this.botones[2][0] = new JButton("3.) Ventas realizadas en el año");
		this.botones[2][0].addActionListener(this);
		menuBotones.add(this.botones[2][0]);
		this.add(menuBotones, BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bOprimido = (JButton)e.getSource();
		if (bOprimido.getText()=="1.) Mostrar la historia de una pieza") {
			new InterfazHistoriaP(cliente, galeria);
		}
		else if (bOprimido.getText()=="2.) Mostrar la historia de un artista") {
			new InterfazHistoriaA(cliente, galeria);
		}
		else if (bOprimido.getText()=="3.) Ventas realizadas en el año") {
			
		}
	}

}