package base;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ventana extends JFrame{

	public Ventana() {
		super("Título de la ventana.");
		this.setSize(400,300);//el this no es obligatorio
		this.setResizable(false);//para que no se pueda modificar el tamaño
		this.setLocationRelativeTo(null);//para que centre la ventana
		this.setLayout(null);//Elimino la distribución
		
		JButton boton = new JButton("click");//añadir un boton a la ventana
		boton.setBounds(90,30,150,50);//No funciona si la ventana tiene una distribución
		this.add(boton);
		this.setVisible(true);
		
		this.setVisible(true);
		
		JLabel etiqueta = new JLabel("Nombre del módulo: ");
		etiqueta.setBounds(30,90,200,30);
		etiqueta.setDisplayedMnemonic('m');
		this.add(etiqueta);
		
		JTextField ctexto = new JTextField();
		etiqueta.setLabelFor(ctexto);
		ctexto.setBounds(240,90,120,30);
		this.add(ctexto);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		Ventana v1 = new Ventana();
	}

}
