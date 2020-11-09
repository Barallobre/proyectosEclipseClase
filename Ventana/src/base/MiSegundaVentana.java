package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MiSegundaVentana extends JFrame {
	public MiSegundaVentana() {
		super("Mi segunda ventana");
		this.setSize(450, 275);// el this no es obligatorio
		this.setResizable(false);// para que no se pueda modificar el tamaño
		this.setLocationRelativeTo(null);// para que centre la ventana
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Cierra la ventana pero la aplicación sigue

		JPanel panel0 = new JPanel();
		this.add(panel0, BorderLayout.CENTER);
		panel0.setLayout(null);// ponemos el setLayout a null para poder poner las coordenadas nosotros
		JLabel nombre = new JLabel("Nombre completo: ");
		nombre.setBounds(30, 60, 200, 30);
		panel0.add(nombre);
		JTextField textoNombre = new JTextField();
		nombre.setLabelFor(textoNombre);
		textoNombre.setBounds(150, 60, 250, 25);
		panel0.add(textoNombre);

		JLabel direccion = new JLabel("Dirección: ");
		direccion.setBounds(30, 120, 200, 30);
		panel0.add(direccion);
		JTextField textoDireccion = new JTextField();
		direccion.setLabelFor(textoDireccion);
		textoDireccion.setBounds(150, 120, 250, 25);
		panel0.add(textoDireccion);

		JPanel panel = new JPanel();
		((FlowLayout) panel.getLayout()).setAlignment(FlowLayout.RIGHT);
		this.add(panel, BorderLayout.SOUTH);
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
