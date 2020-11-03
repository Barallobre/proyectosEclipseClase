package base;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana2 extends JFrame{

	public Ventana2() {
		super("Título de la ventana.");
		this.setSize(400,300);//el this no es obligatorio
		this.setResizable(false);//para que no se pueda modificar el tamaño
		this.setLocationRelativeTo(null);//para que centre la ventana
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Cierra la ventana pero la aplicación sigue 
	
		
		JPanel panel = new JPanel(); //creamos un panel que por defecto ocupa todo 
		this.add(panel);
		Color miColor = new Color(100,100,255);
		panel.setBackground(miColor);
		
		JButton boton = new JButton("click");//añadir un boton a la ventana
		boton.setBounds(90,30,150,50);//No funciona si la ventana tiene una distribución
		panel.add(boton);
		
		JButton boton2 = new JButton("click2");//añadir un boton a la ventana
		panel.add(boton2);
		
		JPanel panel2 = new JPanel();
		this.add(panel2,BorderLayout.SOUTH);
		panel2.setBackground(Color.orange);
		JButton boton3 = new JButton("click3");
		panel2.add(boton3);
		
		
		this.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		Ventana2 v1 = new Ventana2();
	}

}
//El layout tiene cinco zonas y por defecto ocupa todo