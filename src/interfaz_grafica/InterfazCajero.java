package interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modeloGaleria.Cajero;
import modeloGaleria.Galeria;

public class InterfazCajero extends JFrame implements ActionListener {
	private Galeria galeria;
	private JButton botones[][] = new JButton[5][1];
	private Cajero cajero;
	public InterfazCajero (Cajero cajero, Galeria galeria) {
		this.galeria = galeria;
		this.cajero = cajero;
		
		this.setSize(800, 800);
		this.setTitle("Cajero");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		JLabel menu = new JLabel("Menú Operador");
		JPanel titulo = new JPanel();
		titulo.setLayout(new FlowLayout());
		titulo.add(menu);
		this.add(titulo, BorderLayout.NORTH);
		
		JPanel menuBotones = new JPanel();
		menuBotones.setLayout(new GridLayout(5, 1, 10, 10));
		this.botones[0][0] = new JButton("1.) Confirmar pago-Dar factura");
		this.botones[0][0].addActionListener(this);
		menuBotones.add(this.botones[0][0]);
		this.botones[1][0] = new JButton("2.) Mostrar la historia de una pieza");
		this.botones[1][0].addActionListener(this);
		menuBotones.add(this.botones[1][0]);
		this.botones[2][0] = new JButton("3.) Mostrar la historia de un artista");
		this.botones[2][0].addActionListener(this);
		menuBotones.add(this.botones[2][0]);
		this.botones[3][0] = new JButton("4.) Ventas realizadas en el año");
		this.botones[3][0].addActionListener(this);
		menuBotones.add(this.botones[3][0]);
		this.add(menuBotones, BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bOprimido = (JButton)e.getSource();
		if (bOprimido.getText()=="1.) Confirmar pago-Dar factura") {
			new InterfazConfirmarPago(cajero, galeria); 
		}
		else if (bOprimido.getText()=="2.) Mostrar la historia de una pieza") {
			new InterfazHistoriaP(cajero, galeria);
		}
		else if (bOprimido.getText()=="3.) Mostrar la historia de un artista") {
			new InterfazHistoriaA(cajero, galeria);
		}
		else if (bOprimido.getText()=="4.) Ventas realizadas en el año") {
			
		}
	}

}
