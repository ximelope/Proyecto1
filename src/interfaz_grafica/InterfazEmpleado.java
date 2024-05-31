package interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class InterfazEmpleado extends JFrame implements ActionListener  {


	public InterfazEmpleado () {
		this.setSize(800, 800);
		this.setTitle("Empleado");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new InterfazEmpleado();
	}
	
	

}