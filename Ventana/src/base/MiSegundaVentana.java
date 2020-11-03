package base;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MiSegundaVentana extends JFrame {
	public MiSegundaVentana() {
		super("Mi segunda ventana");
		this.setSize(450,275);//el this no es obligatorio
		this.setResizable(false);//para que no se pueda modificar el tamaño
		this.setLocationRelativeTo(null);//para que centre la ventana
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Cierra la ventana pero la aplicación sigue 
	
	
		
		JLabel nombre = new JLabel("Nombre completo: ");
		nombre.setBounds(30,60,200,30);
		this.add(nombre);
		JTextField textoNombre = new JTextField();
		nombre.setLabelFor(textoNombre);
		textoNombre.setBounds(150,60,250,25);
		this.add(textoNombre);
		
		JLabel direccion = new JLabel("Dirección: ");
		direccion.setBounds(30,120,200,30);
		this.add(direccion);
		JTextField textoDireccion = new JTextField();
		direccion.setLabelFor(textoDireccion);
		textoDireccion.setBounds(150,120,250,25);
		this.add(textoDireccion);
		
		JPanel panel = new JPanel();
		this.add(panel,BorderLayout.SOUTH);
		panel.setBackground(Color.GRAY);
		JButton botonAceptar = new JButton("Aceptar");

		JButton botonCancelar = new JButton("Cancelar");
		
		panel.add(botonAceptar);
		panel.add(botonCancelar);
		
		
		
		
		
		
		
		
		
		
		
		this.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		MiSegundaVentana v2 = new MiSegundaVentana();
	}

}
