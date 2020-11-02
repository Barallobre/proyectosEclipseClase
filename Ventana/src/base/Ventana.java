package base;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ventana extends JFrame{

	public Ventana() {
		super("T�tulo de la ventana.");
		this.setSize(400,300);//el this no es obligatorio
		this.setResizable(false);//para que no se pueda modificar el tama�o
		this.setLocationRelativeTo(null);//para que centre la ventana
		this.setLayout(null);//Elimino la distribuci�n
		
		JButton boton = new JButton("click");//a�adir un boton a la ventana
		boton.setBounds(90,30,150,50);//No funciona si la ventana tiene una distribuci�n
		this.add(boton);
		this.setVisible(true);
		
		this.setVisible(true);
		
		JLabel etiqueta = new JLabel("Nombre del m�dulo: ");
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
