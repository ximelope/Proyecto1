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

import modeloGaleria.Administrador;
import modeloGaleria.Galeria;
import modeloGaleria.Operador;

public class InterfazOperador extends JFrame implements ActionListener{
	private Galeria galeria;
	private JButton botones[][] = new JButton[5][1];
	private Operador operador;
	public InterfazOperador (Operador operador, Galeria galeria) {
		this.galeria = galeria;
		this.operador = operador;
		
		this.setSize(800, 800);
		this.setTitle("Administrador");
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
		this.botones[1][0] = new JButton("1.) Cerrar Subasta (mostar el nuevo dueño) ");
		this.botones[1][0].addActionListener(this);
		menuBotones.add(this.botones[1][0]);
		this.botones[2][0] = new JButton("2.) Mostrar la historia de una pieza");
		this.botones[2][0].addActionListener(this);
		menuBotones.add(this.botones[2][0]);
		this.botones[3][0] = new JButton("3.) Mostrar la historia de un artista");
		this.botones[3][0].addActionListener(this);
		menuBotones.add(this.botones[3][0]);
		this.botones[4][0] = new JButton("4.) Ventas realizadas en el año");
		this.botones[4][0].addActionListener(this);
		menuBotones.add(this.botones[4][0]);
		this.add(menuBotones, BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bOprimido = (JButton)e.getSource();
		if (bOprimido.getText()=="1.) Cerrar Subasta (mostar el nuevo dueño) ") {
			JFrame subasta = new JFrame();
			subasta.setSize(400, 400);
			subasta.setTitle("Cerrar Subasta");
			subasta.setDefaultCloseOperation(EXIT_ON_CLOSE);
			subasta.setLayout(new BorderLayout());
			subasta.setVisible(true);

			JPanel personaPanel = new JPanel();
	        personaPanel.setLayout(new GridLayout(2, 2));

	        JLabel nameLabel = new JLabel("Ingrese el id de la subasta a finalizar(00aa, 00bb)");
	        JTextField nameField = new JTextField();

	        JButton submitButton = new JButton("Enviar");
	        personaPanel.add(nameLabel);
	        personaPanel.add(nameField);
	        personaPanel.add(new JLabel());  // Añadir un espacio vacío
	        personaPanel.add(submitButton);
	        submitButton.addActionListener(this);
	        subasta.add(personaPanel, BorderLayout.CENTER);
	        subasta.setVisible(true);
		
		}
		else if (bOprimido.getText()=="2.) Mostrar la historia de una pieza") {
			new InterfazHistoriaP(operador, galeria);
		}
		else if (bOprimido.getText()=="3.) Mostrar la historia de un artista") {
			new InterfazHistoriaA(operador, galeria);
		}
		else if (bOprimido.getText()=="4.) Ventas realizadas en el año") {
			
		}
	}

}
