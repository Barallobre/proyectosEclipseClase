package base;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Ventana extends JFrame {

	JPanel contentPane;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JButton boton1;
	JButton boton2;
	JButton boton3;
	

	
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(245, 222, 179));
		boton1 = new JButton("Imprimir");
		panel1.add(boton1);
		panel1.setVisible(true);
		contentPane.add(panel1, BorderLayout.CENTER);	
		

		
		panel2 = new JPanel();
		panel2.setBackground(new Color(224, 255, 255));
		boton2 = new JButton("Panel2");
		panel2.add(boton2);
		panel2.setVisible(false);
		//contentPane.add(panel2, BorderLayout.CENTER);	

				
		panel3 = new JPanel();
		panel3.setBackground(new Color(230, 230, 250));
		boton3 = new JButton("Panel3");
		panel3.add(boton3);
		panel3.setVisible(false);
		//contentPane.add(panel3, BorderLayout.CENTER);	
		
//		System.out.println(contentPane.getComponentZOrder(panel1));
//		System.out.println(contentPane.getComponentZOrder(panel2));
//		System.out.println(contentPane.getComponentZOrder(panel3));
//		contentPane.setComponentZOrder(panel2,2);
//		contentPane.setComponentZOrder(panel3,1);
//		contentPane.setComponentZOrder(panel1,0);
//		System.out.println(contentPane.getComponentZOrder(panel1));
//		System.out.println(contentPane.getComponentZOrder(panel2));
//		System.out.println(contentPane.getComponentZOrder(panel3));		
		
	}

	public void asignaEscuchadores(EscuchaBoton eb) {
		boton1.addActionListener(eb);
		boton2.addActionListener(eb);
		boton3.addActionListener(eb);
	}

}
