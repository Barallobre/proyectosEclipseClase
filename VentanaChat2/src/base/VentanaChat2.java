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
		GridBagConstraints props1 = new GridBagConstraints();
		GridBagConstraints props2 = new GridBagConstraints();
		GridBagConstraints props3 = new GridBagConstraints();
		
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
		props1.gridx = 2;
		props1.gridy = 0;
		props1.gridwidth = 1;
		props1.gridheight = 1;
		props1.weightx = 0.0;
		props1.weighty = 0.0;
		props1.fill = GridBagConstraints.NONE;
		props1.anchor = GridBagConstraints.EAST;
		this.getContentPane().add(boton1, props1);
		
		JTextArea area = new JTextArea();
		props2.gridx = 0;
		props2.gridy = 1;
		props2.gridwidth = 3;
		props2.gridheight = 1;
		props2.weightx = 1.0;
		props2.weighty = 1.0;
		props2.fill = GridBagConstraints.BOTH;
		
		this.getContentPane().add(area, props2);
		
		JButton boton2 = new JButton("Borrar chat");
		props3.gridx = 1;
		props3.gridy = 2;
		props3.gridwidth = 3;
		props3.gridheight = 1;
		props3.weightx = 0.0;
		props3.weighty = 0.0;
		props3.fill = GridBagConstraints.NONE;
		props3.anchor = GridBagConstraints.CENTER;
		this.getContentPane().add(boton2, props3);
	}

}
