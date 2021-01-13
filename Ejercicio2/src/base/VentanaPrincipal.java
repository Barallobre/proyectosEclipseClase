package base;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class VentanaPrincipal extends JFrame {
	public VentanaPrincipal() {
		super("Examen DI 1\u00AA Evaluaci\u00F3n");
		setSize(566, 412);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		Componente componente = new Componente();
		componente.setBounds(326, 0, 224, 373);
		getContentPane().add(componente);
		
		JLabel lblNewLabel = new JLabel("<html><h1>Cristian Barallobre,</h1></htlm>");
		lblNewLabel.setBounds(46, 132, 291, 38);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><h2>entrenador personal</h2></html>\r\n");
		lblNewLabel_1.setBounds(72, 181, 217, 25);
		getContentPane().add(lblNewLabel_1);
		
		setVisible(true);
	}


}
