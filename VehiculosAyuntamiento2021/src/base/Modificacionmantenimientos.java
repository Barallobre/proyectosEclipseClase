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
 * Clase construida con windowbuilder que nos permite modificar los parámetros de un mantenimiento
 * @author Cristian Barallobre
 * @version 06-03-2020
 * 
 */
public class Modificacionmantenimientos extends JFrame {

	private JPanel contentPane;
	private JTextField numMantenimiento;
	private JTextField matricula;
	private JTextField fechaMantenimiento;
	private JTextField coste;
	private JTextField tipoMantenimiento;


	public Modificacionmantenimientos() {
		setTitle("Modificaci\u00F3n de mantenimientos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 203);
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
					int numMantenimiento1 = Integer.parseInt(numMantenimiento.getText());
					String matricula1 = matricula.getText();
					String tipoMantenimiento1 = tipoMantenimiento.getText();
					String fechaSQL = fechaMantenimiento.getText();
					Double coste1 = Double.parseDouble(coste.getText());
					Date fechaMantenimiento1 = java.sql.Date.valueOf(fechaSQL);

					sentencia = conexion.prepareStatement("update mantenimientos set Matricula=?,TipoMantenimiento=?,FechaMantenimiento=?,Coste=? where NumMantenimiento=?");
					sentencia.setString(1, matricula1);
					sentencia.setString(2, tipoMantenimiento1);
					sentencia.setDate(3, (java.sql.Date) fechaMantenimiento1);
					sentencia.setDouble(4, coste1);
					sentencia.setInt(5, numMantenimiento1);
					sentencia.execute();
					
					sentencia.close();
					conexion.close();

					JOptionPane.showMessageDialog(null, "Mantenimiento añadido", "Vehículos ayuntamiento",
							JOptionPane.PLAIN_MESSAGE);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "El número de Mantenimiento debe ser un número", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,
							"No existe ningún coche con esa matrícula o el Tipo de mantenimiento introducido no existe.",
							"ERROR", JOptionPane.PLAIN_MESSAGE);
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null,
							"Revise los datos introducidos. La fecha debe tener el formato YYYY-MM-DD", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
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
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero de mantenimiento");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		numMantenimiento = new JTextField();
		GridBagConstraints gbc_numMantenimiento = new GridBagConstraints();
		gbc_numMantenimiento.insets = new Insets(0, 0, 5, 0);
		gbc_numMantenimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_numMantenimiento.gridx = 5;
		gbc_numMantenimiento.gridy = 0;
		panel_1.add(numMantenimiento, gbc_numMantenimiento);
		numMantenimiento.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Matr\u00EDcula");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		matricula = new JTextField();
		GridBagConstraints gbc_matricula = new GridBagConstraints();
		gbc_matricula.insets = new Insets(0, 0, 5, 0);
		gbc_matricula.fill = GridBagConstraints.HORIZONTAL;
		gbc_matricula.gridx = 5;
		gbc_matricula.gridy = 1;
		panel_1.add(matricula, gbc_matricula);
		matricula.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de mantenimiento");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		fechaMantenimiento = new JTextField();
		GridBagConstraints gbc_fechaMantenimiento = new GridBagConstraints();
		gbc_fechaMantenimiento.insets = new Insets(0, 0, 5, 0);
		gbc_fechaMantenimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_fechaMantenimiento.gridx = 5;
		gbc_fechaMantenimiento.gridy = 2;
		panel_1.add(fechaMantenimiento, gbc_fechaMantenimiento);
		fechaMantenimiento.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Coste");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 3;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		coste = new JTextField();
		GridBagConstraints gbc_coste = new GridBagConstraints();
		gbc_coste.insets = new Insets(0, 0, 5, 0);
		gbc_coste.fill = GridBagConstraints.HORIZONTAL;
		gbc_coste.gridx = 5;
		gbc_coste.gridy = 3;
		panel_1.add(coste, gbc_coste);
		coste.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo de Mantenimiento");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 4;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		tipoMantenimiento = new JTextField();
		GridBagConstraints gbc_tipoMantenimiento = new GridBagConstraints();
		gbc_tipoMantenimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_tipoMantenimiento.gridx = 5;
		gbc_tipoMantenimiento.gridy = 4;
		panel_1.add(tipoMantenimiento, gbc_tipoMantenimiento);
		tipoMantenimiento.setColumns(10);
	}

}
