package base;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class DatosRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosRegistro frame = new DatosRegistro();
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
	public DatosRegistro() {
		setTitle("Datos de Registro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setSize(100, 20);
		lblNewLabel.setLocation(10, 10);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setSize(240, 20);
		textField.setLocation(175, 10);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setSize(100, 20);
		lblNewLabel_1.setLocation(10, 40);
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 40, 240, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Repita la contrase\u00F1a:");
		lblNewLabel_2.setBounds(10, 70, 150, 20);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 70, 240, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(10, 122, 46, 14);
		panel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(175, 119, 240, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre:");
		lblNewLabel_4.setBounds(10, 150, 46, 14);
		panel.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(175, 147, 240, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Apellidos:");
		lblNewLabel_5.setBounds(10, 179, 46, 14);
		panel.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(175, 176, 240, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Nacimiento:");
		lblNewLabel_6.setBounds(10, 213, 66, 14);
		panel.add(lblNewLabel_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("D\u00EDa nacimiento");
		comboBox.setBounds(175, 209, 37, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel_7 = new JLabel("de");
		lblNewLabel_7.setBounds(222, 213, 12, 14);
		panel.add(lblNewLabel_7);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("Mes nacimiento");
		comboBox_1.setBounds(244, 209, 71, 22);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_8 = new JLabel("de");
		lblNewLabel_8.setBounds(325, 213, 12, 14);
		panel.add(lblNewLabel_8);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("A\u00F1o nacimiento");
		comboBox_2.setBounds(349, 209, 66, 22);
		panel.add(comboBox_2);
		
		JLabel lblNewLabel_9 = new JLabel("Sexo:");
		lblNewLabel_9.setBounds(10, 248, 46, 14);
		panel.add(lblNewLabel_9);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hombre");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(175, 244, 86, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Mujer");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(263, 244, 66, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Ns/Nc");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(346, 244, 58, 23);
		panel.add(rdbtnNewRadioButton_2);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Aceptar");
		panel_1.add(btnNewButton);
		
		JOptionPane.showMessageDialog(null, "Bienvenido al grupo");
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		panel_1.add(btnNewButton_1);
	}
}
