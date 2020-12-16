package base;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.SegundaVentana;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;



	
	public VentanaPrincipal() {
		setTitle("Viajes Chios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("<html><h3>AGENCIA DE VIAJES CH\u00CDOS S.L.</h3></html>");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Aceptar");
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SegundaVentana frame = new SegundaVentana();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		JButton btnNewButton_1 = new JButton("Cancelar");
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				System.exit(0);
			}
		});
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel nombre = new JLabel("C\u00F3mo te llamas");
		nombre.setHorizontalAlignment(SwingConstants.LEFT);
		nombre.setHorizontalTextPosition(SwingConstants.LEFT);
		nombre.setBounds(new Rectangle(21, 27, 146, 14));

		panel_2.add(nombre);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona un destino");
		lblNewLabel_1.setBounds(21, 64, 146, 14);
		panel_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(177, 24, 197, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tenerife","Gran Canaria","El Hierro"}));
		
		comboBox.setBounds(175, 60, 199, 22);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("<html><h4>Dinos qu\u00E9 te gusta:</h4></html>");
		lblNewLabel_2.setBounds(143, 142, 172, 14);
		panel_2.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Comer");
		chckbxNewCheckBox.setBounds(21, 193, 97, 23);
		panel_2.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Comprar");
		chckbxNewCheckBox_1.setBounds(21, 219, 97, 23);
		panel_2.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Ir de compras");
		chckbxNewCheckBox_2.setBounds(143, 193, 132, 23);
		panel_2.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Callejear");
		chckbxNewCheckBox_3.setBounds(143, 219, 97, 23);
		panel_2.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Nadar");
		chckbxNewCheckBox_4.setBounds(277, 193, 97, 23);
		panel_2.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Ver museos");
		chckbxNewCheckBox_5.setBounds(277, 219, 97, 23);
		panel_2.add(chckbxNewCheckBox_5);
	}

}
