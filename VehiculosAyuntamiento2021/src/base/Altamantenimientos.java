package base;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
/**
 * Clase construida con windowbuilder que nos permite dar de alta un nuevo mantenimiento en la base de datos
 * @author Cristian Barallobre
 * @version 06-03-2020
 * 
 */
public class Altamantenimientos extends JFrame {

	private JPanel contentPane;
	private JTextField numMantenimiento;
	private JTextField matricula;
	private JTextField tipoMantenimiento;
	private JTextField fechaMantenimiento;
	private JTextField coste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Altamantenimientos frame = new Altamantenimientos();
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
	public Altamantenimientos() {
		setTitle("Alta de mantenimientos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton aceptar = new JButton("Aceptar");
		panel_1.add(aceptar);
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

					sentencia = conexion.prepareStatement(
							"insert into mantenimientos (numMantenimiento,Matricula,TipoMantenimiento,FechaMantenimiento,Coste) values(?,?,?,?,?)");
					sentencia.setInt(1, numMantenimiento1);
					sentencia.setString(2, matricula1);
					sentencia.setString(3, tipoMantenimiento1);
					sentencia.setDate(4, (java.sql.Date) fechaMantenimiento1);
					sentencia.setDouble(5, coste1);
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
		panel_1.add(cancelar);
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
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel numerMantenimiento = new JLabel("N\u00FAmero mantenimiento");
		GridBagConstraints gbc_numerMantenimiento = new GridBagConstraints();
		gbc_numerMantenimiento.anchor = GridBagConstraints.EAST;
		gbc_numerMantenimiento.insets = new Insets(0, 0, 5, 5);
		gbc_numerMantenimiento.gridx = 1;
		gbc_numerMantenimiento.gridy = 1;
		panel.add(numerMantenimiento, gbc_numerMantenimiento);

		numMantenimiento = new JTextField();
		GridBagConstraints gbc_numMantenimiento = new GridBagConstraints();
		gbc_numMantenimiento.insets = new Insets(0, 0, 5, 0);
		gbc_numMantenimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_numMantenimiento.gridx = 3;
		gbc_numMantenimiento.gridy = 1;
		panel.add(numMantenimiento, gbc_numMantenimiento);
		numMantenimiento.setColumns(10);

		JLabel Matricula = new JLabel("Matr\u00EDcula");
		GridBagConstraints gbc_Matricula = new GridBagConstraints();
		gbc_Matricula.anchor = GridBagConstraints.EAST;
		gbc_Matricula.insets = new Insets(0, 0, 5, 5);
		gbc_Matricula.gridx = 1;
		gbc_Matricula.gridy = 2;
		panel.add(Matricula, gbc_Matricula);

		matricula = new JTextField();
		GridBagConstraints gbc_matricula = new GridBagConstraints();
		gbc_matricula.insets = new Insets(0, 0, 5, 0);
		gbc_matricula.fill = GridBagConstraints.HORIZONTAL;
		gbc_matricula.gridx = 3;
		gbc_matricula.gridy = 2;
		panel.add(matricula, gbc_matricula);
		matricula.setColumns(10);

		JLabel TipoMantenimiento = new JLabel("Tipo de mantenimiento");
		GridBagConstraints gbc_TipoMantenimiento = new GridBagConstraints();
		gbc_TipoMantenimiento.anchor = GridBagConstraints.EAST;
		gbc_TipoMantenimiento.insets = new Insets(0, 0, 5, 5);
		gbc_TipoMantenimiento.gridx = 1;
		gbc_TipoMantenimiento.gridy = 3;
		panel.add(TipoMantenimiento, gbc_TipoMantenimiento);

		tipoMantenimiento = new JTextField();
		GridBagConstraints gbc_tipoMantenimiento = new GridBagConstraints();
		gbc_tipoMantenimiento.insets = new Insets(0, 0, 5, 0);
		gbc_tipoMantenimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_tipoMantenimiento.gridx = 3;
		gbc_tipoMantenimiento.gridy = 3;
		panel.add(tipoMantenimiento, gbc_tipoMantenimiento);
		tipoMantenimiento.setColumns(10);

		JLabel FechaMantenimiento = new JLabel("Fecha de mantenimiento");
		GridBagConstraints gbc_FechaMantenimiento = new GridBagConstraints();
		gbc_FechaMantenimiento.anchor = GridBagConstraints.EAST;
		gbc_FechaMantenimiento.insets = new Insets(0, 0, 5, 5);
		gbc_FechaMantenimiento.gridx = 1;
		gbc_FechaMantenimiento.gridy = 4;
		panel.add(FechaMantenimiento, gbc_FechaMantenimiento);

		fechaMantenimiento = new JTextField();
		GridBagConstraints gbc_fechaMantenimiento = new GridBagConstraints();
		gbc_fechaMantenimiento.insets = new Insets(0, 0, 5, 0);
		gbc_fechaMantenimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_fechaMantenimiento.gridx = 3;
		gbc_fechaMantenimiento.gridy = 4;
		panel.add(fechaMantenimiento, gbc_fechaMantenimiento);
		fechaMantenimiento.setColumns(10);

		JLabel Coste = new JLabel("Coste");
		GridBagConstraints gbc_Coste = new GridBagConstraints();
		gbc_Coste.anchor = GridBagConstraints.EAST;
		gbc_Coste.insets = new Insets(0, 0, 0, 5);
		gbc_Coste.gridx = 1;
		gbc_Coste.gridy = 5;
		panel.add(Coste, gbc_Coste);

		coste = new JTextField();
		GridBagConstraints gbc_coste = new GridBagConstraints();
		gbc_coste.fill = GridBagConstraints.HORIZONTAL;
		gbc_coste.gridx = 3;
		gbc_coste.gridy = 5;
		panel.add(coste, gbc_coste);
		coste.setColumns(10);
	}

}
