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
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JTextField;
/**
 * 
 * @author Cristian Barallobre
 * @version 06-03-2020
 * Clase construida con windowbuilder que nos permite modificar los tipos de mantenimiento en la base de datos
 */
public class Modificaciontiposmantenimiento extends JFrame {

	private JPanel contentPane;
	private JTextField tipoMantenimiento;
	private JTextField nuevoNombre;

	public Modificaciontiposmantenimiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 131);
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
					
					String nuevoNombre1 = nuevoNombre.getText();

					sentencia = conexion.prepareStatement("update tiposmantenimiento set TipoMantenimiento=? where TipoMantenimiento=?");
					sentencia.setString(2, tipoMantenimiento1);
					sentencia.setString(1, nuevoNombre1);
				
					sentencia.execute();
					
					sentencia.close();
					conexion.close();

					JOptionPane.showMessageDialog(null, "Tipo de Mantenimiento modificado", "Vehículos ayuntamiento",
							JOptionPane.PLAIN_MESSAGE);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "El coste debe ser un número", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "No puedes cambiar ese dato, se encuentra en otras tablas.", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
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
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Tipo mantenimiento");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		tipoMantenimiento = new JTextField();
		GridBagConstraints gbc_tipoMantenimiento = new GridBagConstraints();
		gbc_tipoMantenimiento.insets = new Insets(0, 0, 5, 0);
		gbc_tipoMantenimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_tipoMantenimiento.gridx = 5;
		gbc_tipoMantenimiento.gridy = 0;
		panel_1.add(tipoMantenimiento, gbc_tipoMantenimiento);
		tipoMantenimiento.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nuevo nombre");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		nuevoNombre = new JTextField();
		GridBagConstraints gbc_nuevoNombre = new GridBagConstraints();
		gbc_nuevoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_nuevoNombre.gridx = 5;
		gbc_nuevoNombre.gridy = 1;
		panel_1.add(nuevoNombre, gbc_nuevoNombre);
		nuevoNombre.setColumns(10);
	}

}
