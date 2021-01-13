package base;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelFCM extends JPanel {
	private JTextField txtEdad;
	private JTextField txtFCM;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public PanelFCM() {
		setBorder(UIManager.getBorder("OptionPane.border"));
		setBackground(new Color(240, 248, 255));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		add(panel_1);
		
		JLabel lblFrecuenciaCardacaMxima = new JLabel("<html><p style=\"text-align:center;margin:10 0 15 0\">Frecuencia Card\u00EDaca<br>M\u00E1xima (FCM)</p></html>\r\n");
		lblFrecuenciaCardacaMxima.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFrecuenciaCardacaMxima.setFont(new Font("Verdana", Font.BOLD, 16));
		lblFrecuenciaCardacaMxima.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblFrecuenciaCardacaMxima.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblFrecuenciaCardacaMxima);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		add(panel);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		buttonGroup.add(rdbtnHombre);
		rdbtnHombre.setFont(new Font("Verdana", Font.BOLD, 14));
		rdbtnHombre.setBackground(new Color(240, 248, 255));
		rdbtnHombre.setMnemonic('h');
		panel.add(rdbtnHombre);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		buttonGroup.add(rdbtnMujer);
		rdbtnMujer.setFont(new Font("Verdana", Font.BOLD, 14));
		rdbtnMujer.setBackground(new Color(240, 248, 255));
		rdbtnMujer.setMnemonic('M');
		panel.add(rdbtnMujer);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 248, 255));
		add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Edad");
		lblNewLabel.setBackground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setDisplayedMnemonic('E');
		panel_2.add(lblNewLabel);
		
		txtEdad = new JTextField();
		txtEdad.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdad.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setLabelFor(txtEdad);
		panel_2.add(txtEdad);
		txtEdad.setColumns(4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 248, 255));
		add(panel_3);
		
		JCheckBox chkSedentario = new JCheckBox("Sedentario/a");
		chkSedentario.setFont(new Font("Verdana", Font.BOLD, 14));
		chkSedentario.setBackground(new Color(240, 248, 255));
		chkSedentario.setMnemonic('S');
		panel_3.add(chkSedentario);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(240, 248, 255));
		add(panel_6);
		
		JLabel lblNewLabel_1 = new JLabel("FCM");
		lblNewLabel_1.setBackground(new Color(240, 248, 255));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 14));
		panel_6.add(lblNewLabel_1);
		
		txtFCM = new JTextField();
		txtFCM.setHorizontalAlignment(SwingConstants.CENTER);
		txtFCM.setForeground(new Color(178, 34, 34));
		txtFCM.setFont(new Font("Verdana", Font.BOLD, 14));
		txtFCM.setBackground(new Color(240, 248, 255));
		lblNewLabel_1.setLabelFor(txtFCM);
		txtFCM.setEditable(false);
		panel_6.add(txtFCM);
		txtFCM.setColumns(4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 248, 255));
		add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(240, 248, 255));
		add(panel_5);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Integer FCM=0;
				if(chkSedentario.isSelected())
					FCM = 220 - Integer.parseInt(txtEdad.getText());
				else
					if (rdbtnHombre.isSelected())
						FCM = (int) (209 - (0.7*Integer.parseInt(txtEdad.getText())));
					else
						FCM = (int) (214 - (0.8*Integer.parseInt(txtEdad.getText())));
				txtFCM.setText(FCM.toString());
				
			}catch (Exception e2) {
				JOptionPane.showMessageDialog(panel, "Se ha producido un error, vuelva a intentarlo", "Error", JOptionPane.WARNING_MESSAGE);
			}
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton.setMnemonic('C');
		panel_5.add(btnNewButton);

	}

}
