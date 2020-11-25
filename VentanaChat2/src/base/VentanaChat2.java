package base;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaChat2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaChat2 frame = new VentanaChat2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaChat2() {
		super("C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.getContentPane().setLayout(new GridBagLayout());
		
		GridBagConstraints props = new GridBagConstraints();
		
		JTextField texto = new JTextField();
		props.gridx = 0;
		props.gridy = 0;
		props.gridwidth = 2;
		props.gridheight = 1;
		props.weightx = 1.0;
		props.weighty = 0.0;
		props.fill = GridBagConstraints.HORIZONTAL;
		this.getContentPane().add(texto, props);
		
		JButton boton1 = new JButton("Enviar");
		props.gridx = 2;
		props.gridy = 0;
		props.gridwidth = 1;
		props.gridheight = 1;
		props.weightx = 0.0;
		props.weighty = 0.0;
		props.fill = GridBagConstraints.NONE;
		props.anchor = GridBagConstraints.EAST;
		this.getContentPane().add(boton1, props);
		
		JTextArea area = new JTextArea();
		props.gridx = 0;
		props.gridy = 1;
		props.gridwidth = 3;
		props.gridheight = 1;
		props.weightx = 1.0;
		props.weighty = 1.0;
		props.fill = GridBagConstraints.BOTH;
		
		this.getContentPane().add(area, props);
		
		JButton boton2 = new JButton("Borrar chat");
		props.gridx = 1;
		props.gridy = 2;
		props.gridwidth = 3;
		props.gridheight = 1;
		props.weightx = 0.0;
		props.weighty = 0.0;
		props.fill = GridBagConstraints.NONE;
		props.anchor = GridBagConstraints.CENTER;
		this.getContentPane().add(boton2, props);
	}

}
