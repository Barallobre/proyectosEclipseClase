package base;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaConBotonEscuchador  extends JFrame{
	
	public VentanaConBotonEscuchador(){
		super("Ventana con boton");
		this.setBounds(100,100,300,200);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		setContentPane(panel);
		
		JButton boton = new JButton("Pulsar1");
		panel.add(boton);
		JButton boton2 = new JButton("Pulsar2");
		panel.add(boton2);
		
		boton.addActionListener(new EscuchaBoton());
		boton2.addActionListener(new EscuchaBoton());
		this.setVisible(true);
	}
	
	
	
	


}
