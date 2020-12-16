package base;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setTitle("Viajes Ch\u00EDos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCmoTeLlamas = new JLabel("C\u00F3mo te llamas");
		lblCmoTeLlamas.setBounds(25, 69, 92, 14);
		panel.add(lblCmoTeLlamas);
		
		JLabel lblNewLabel = new JLabel("AGENCIA DE VIAJES CH\u00CDOS S.L.");
		lblNewLabel.setBounds(137, 24, 177, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(189, 66, 214, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona un destino");
		lblNewLabel_1.setBounds(25, 109, 114, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tenerife","Gran Canaria","El Hierro"}));
		
		comboBox.setBounds(189, 105, 214, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Dinos qu\u00E9 te gusta:");
		lblNewLabel_2.setBounds(169, 186, 124, 14);
		panel.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Comer");
		chckbxNewCheckBox.setBounds(25, 236, 97, 23);
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Comprar");
		chckbxNewCheckBox_1.setBounds(25, 284, 97, 23);
		panel.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Ir de compras");
		chckbxNewCheckBox_2.setBounds(169, 236, 97, 23);
		panel.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Callejear");
		chckbxNewCheckBox_3.setBounds(169, 284, 97, 23);
		panel.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Nadar");
		chckbxNewCheckBox_4.setBounds(306, 236, 97, 23);
		panel.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Ver museos");
		chckbxNewCheckBox_5.setBounds(306, 284, 97, 23);
		panel.add(chckbxNewCheckBox_5);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("Aceptar");
		panel_1.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
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
		
		JButton btnNewButton = new JButton("Cancelar");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				System.exit(0);
			}
		});
		
		panel_1.add(btnNewButton);
		
	}
}
