package base;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.*;
import javax.swing.*;

public class Componente extends JPanel {
	
	JLabel espacio = new JLabel();
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public Componente() {
		super();
		setLayout(null);
		espacio.setBounds(133, 259, 47, 14);
		
		add(espacio);
		
		JLabel lblNewLabel = new JLabel("FCM");
		lblNewLabel.setBounds(66, 259, 46, 14);
		add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Sedentario");
		chckbxNewCheckBox.setBounds(83, 215, 97, 23);
		add(chckbxNewCheckBox);
		
		textField = new JTextField();
		textField.setBounds(134, 179, 46, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Edad");
		lblNewLabel_1.setBounds(66, 182, 46, 14);
		add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hombre");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(133, 105, 109, 23);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Mujer");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(19, 105, 109, 23);
		add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html><h2>Frecuencia card\u00EDaca</h2></html>");
		lblNewLabel_2.setBounds(29, 22, 189, 43);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("M\u00E1xima (FCM)");
		lblNewLabel_3.setBounds(81, 66, 105, 14);
		add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setBounds(91, 315, 89, 23);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int edad = Integer.parseInt(textField.getText());
					String hombres = String.valueOf((209-(0.7*edad)));
					espacio.setText(hombres);
					String mujeres = String.valueOf((214-(0.8*edad)));
					espacio.setText(mujeres);
					
//					if(rdbtnNewRadioButton == true) {
//						String hombres = String.valueOf((209-(0.7*edad)));
//						espacio.setText(hombres);
//					}else if(rdbtnNewRadioButton_1 == true){
//						String mujeres = String.valueOf((214-(0.8*edad)));
//						espacio.setText(mujeres);
//					}
//					espacio.setText(hombres);
//					espacio.setText(mujeres);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}

	
}
