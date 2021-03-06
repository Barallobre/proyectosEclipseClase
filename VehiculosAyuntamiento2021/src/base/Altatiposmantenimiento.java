package base;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
/**
 * Clase construida con windowbuilder que nos permite dar de alta un tipo de mantenimiento en la base de datos
 * @author Cristian Barallobre
 * @version 06-03-2020
 * 
 */
public class Altatiposmantenimiento extends JFrame {

	private JPanel contentPane;
	private JTextField tipoMantenimiento;


	public Altatiposmantenimiento() {
		setTitle("Alta tipo de mantenimiento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 105);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton aceptar = new JButton("Aceptar");
		panel.add(aceptar);
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conexion = DriverManager.getConnection(
							"jdbc:mysql://localhost/vehiculosayuntamiento2021?serverTimezone=UTC", "demo", "password");

					PreparedStatement sentencia;
					
					String tipoMantenimiento1 = tipoMantenimiento.getText();
			

					sentencia = conexion.prepareStatement("insert into tiposmantenimiento (TipoMantenimiento) values (?)");
					sentencia.setString(1, tipoMantenimiento1);
					sentencia.execute();
					
					sentencia.close();
					conexion.close();

					JOptionPane.showMessageDialog(null, "Tipo de Mantenimiento a�adido", "Veh�culos ayuntamiento",
							JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException | ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "??", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
		JButton cancelar = new JButton("Cancelar");
		panel.add(cancelar);
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Barrademenu frame = new Barrademenu();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Tipo de mantenimiento");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		tipoMantenimiento = new JTextField();
		GridBagConstraints gbc_tipoMantenimiento = new GridBagConstraints();
		gbc_tipoMantenimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_tipoMantenimiento.gridx = 5;
		gbc_tipoMantenimiento.gridy = 0;
		panel_1.add(tipoMantenimiento, gbc_tipoMantenimiento);
		tipoMantenimiento.setColumns(10);
	}

}
