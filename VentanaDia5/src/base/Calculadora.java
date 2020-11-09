package base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora extends JFrame {
	public Calculadora() {
		super("Calculadora Básica");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelCentro = new JPanel();
		this.add(panelCentro,BorderLayout.CENTER);
		
		GridLayout distr = new GridLayout(4,1,0,0);
		panelCentro.setLayout(distr);
		
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton b0 = new JButton("0");
		JButton bC = new JButton("C");
		JButton bIgual = new JButton("=");
		JButton bDivision = new JButton("/");
		JButton bMultiplicacion = new JButton("*");
		JButton bResta = new JButton("-");
		JButton bSuma = new JButton("+");
		
		panelCentro.add(b7);
		panelCentro.add(b8);
		panelCentro.add(b9);
		panelCentro.add(bDivision);
		
		panelCentro.add(b4);
		panelCentro.add(b5);
		panelCentro.add(b6);
		panelCentro.add(bMultiplicacion);
		
		panelCentro.add(b1);
		panelCentro.add(b2);
		panelCentro.add(b3);
		panelCentro.add(bResta);
		
		panelCentro.add(b0);
		panelCentro.add(bC);
		panelCentro.add(bIgual);
		panelCentro.add(bSuma);

		JTextField cuadroTexto = new JTextField();
		this.add(cuadroTexto, BorderLayout.NORTH);
		
	}

	public static void main(String[] args) {
		Calculadora ventana = new Calculadora();
		ventana.setVisible(true);
	}

}
