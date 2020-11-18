package base;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaConBotonEscuchador extends JFrame {
	JButton boton;
	JButton boton2;

	public VentanaConBotonEscuchador() {
		super("Ventana con boton");
		this.setBounds(100, 100, 300, 200);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		setContentPane(panel);

		boton = new JButton("Pulsar1");
		panel.add(boton);
		boton2 = new JButton("Pulsar2");
		panel.add(boton2);

		this.setVisible(true);
	}

	public void conectaEscuchaBoton(EscuchaBoton eb) {
		boton.addActionListener(eb);
		boton2.addActionListener(eb);
	}

}
