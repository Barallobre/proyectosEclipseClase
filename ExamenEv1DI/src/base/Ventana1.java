package base;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import base.PanelFCM;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class Ventana1 extends JFrame{
	
	public Ventana1() {
		super("Examen DI 1\u00AA Evaluaci\u00F3n");
		setSize(400,300);
		setResizable(false);
		setLocationRelativeTo(null);
		
		PanelFCM panelFCM = new PanelFCM();
		getContentPane().add(panelFCM, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("<html><p style=\"margin: 0 24 0 24\">Tu_Nombre_y_Apellido,<br>entrenador/a personal</p></html>");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		JPanel panel = new JPanel(); 
		JButton boton = new JButton("clic");
		panel.add(boton); //o setContentPane(boton);
		//setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		Ventana1 v1= new Ventana1();
		v1.setVisible(true);
	}

}
