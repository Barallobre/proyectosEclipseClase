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
	private JTextField coste;
	private JTextField dia;
	private JTextField mes;
	private JTextField ano;


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
					String dia1=dia.getText();
					String mes1=mes.getText();
					String ano1=ano.getText();
					
					String fechaSQL = ano1+"-"+mes1+"-"+dia1;
				
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
					JOptionPane.showMessageDialog(null, "Error introduciendo parámetros", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,
							"Ha introducido mal algún dato.",
							"ERROR", JOptionPane.PLAIN_MESSAGE);
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null,
							"Ha introducido mal algún dato.", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null,
							null,null,
							JOptionPane.PLAIN_MESSAGE);
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
		gbl_panel.columnWidths = new int[] {30, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		
				JLabel numerMantenimiento = new JLabel("N\u00FAmero mantenimiento");
				GridBagConstraints gbc_numerMantenimiento = new GridBagConstraints();
				gbc_numerMantenimiento.anchor = GridBagConstraints.EAST;
				gbc_numerMantenimiento.insets = new Insets(0, 0, 5, 5);
				gbc_numerMantenimiento.gridx = 1;
				gbc_numerMantenimiento.gridy = 0;
				panel.add(numerMantenimiento, gbc_numerMantenimiento);
		
				numMantenimiento = new JTextField();
				GridBagConstraints gbc_numMantenimiento = new GridBagConstraints();
				gbc_numMantenimiento.gridwidth = 3;
				gbc_numMantenimiento.insets = new Insets(0, 0, 5, 0);
				gbc_numMantenimiento.fill = GridBagConstraints.HORIZONTAL;
				gbc_numMantenimiento.gridx = 2;
				gbc_numMantenimiento.gridy = 0;
				panel.add(numMantenimiento, gbc_numMantenimiento);
				numMantenimiento.setColumns(10);
		
				JLabel Matricula = new JLabel("Matr\u00EDcula");
				GridBagConstraints gbc_Matricula = new GridBagConstraints();
				gbc_Matricula.anchor = GridBagConstraints.EAST;
				gbc_Matricula.insets = new Insets(0, 0, 5, 5);
				gbc_Matricula.gridx = 1;
				gbc_Matricula.gridy = 1;
				panel.add(Matricula, gbc_Matricula);
		
				matricula = new JTextField();
				GridBagConstraints gbc_matricula = new GridBagConstraints();
				gbc_matricula.gridwidth = 3;
				gbc_matricula.insets = new Insets(0, 0, 5, 0);
				gbc_matricula.fill = GridBagConstraints.HORIZONTAL;
				gbc_matricula.gridx = 2;
				gbc_matricula.gridy = 1;
				panel.add(matricula, gbc_matricula);
				matricula.setColumns(10);
		
				JLabel TipoMantenimiento = new JLabel("Tipo de mantenimiento");
				GridBagConstraints gbc_TipoMantenimiento = new GridBagConstraints();
				gbc_TipoMantenimiento.anchor = GridBagConstraints.EAST;
				gbc_TipoMantenimiento.insets = new Insets(0, 0, 5, 5);
				gbc_TipoMantenimiento.gridx = 1;
				gbc_TipoMantenimiento.gridy = 2;
				panel.add(TipoMantenimiento, gbc_TipoMantenimiento);
				
						tipoMantenimiento = new JTextField();
						GridBagConstraints gbc_tipoMantenimiento = new GridBagConstraints();
						gbc_tipoMantenimiento.gridwidth = 3;
						gbc_tipoMantenimiento.insets = new Insets(0, 0, 5, 0);
						gbc_tipoMantenimiento.fill = GridBagConstraints.HORIZONTAL;
						gbc_tipoMantenimiento.gridx = 2;
						gbc_tipoMantenimiento.gridy = 2;
						panel.add(tipoMantenimiento, gbc_tipoMantenimiento);
						tipoMantenimiento.setColumns(10);
		
				JLabel FechaMantenimiento = new JLabel("Fecha de mantenimiento");
				GridBagConstraints gbc_FechaMantenimiento = new GridBagConstraints();
				gbc_FechaMantenimiento.anchor = GridBagConstraints.EAST;
				gbc_FechaMantenimiento.insets = new Insets(0, 0, 5, 5);
				gbc_FechaMantenimiento.gridx = 1;
				gbc_FechaMantenimiento.gridy = 3;
				panel.add(FechaMantenimiento, gbc_FechaMantenimiento);
				
				dia = new JTextField();
				GridBagConstraints gbc_dia = new GridBagConstraints();
				gbc_dia.insets = new Insets(0, 0, 5, 5);
				gbc_dia.fill = GridBagConstraints.HORIZONTAL;
				gbc_dia.gridx = 2;
				gbc_dia.gridy = 3;
				panel.add(dia, gbc_dia);
				dia.setColumns(10);
				
				mes = new JTextField();
				GridBagConstraints gbc_mes = new GridBagConstraints();
				gbc_mes.insets = new Insets(0, 0, 5, 5);
				gbc_mes.fill = GridBagConstraints.HORIZONTAL;
				gbc_mes.gridx = 3;
				gbc_mes.gridy = 3;
				panel.add(mes, gbc_mes);
				mes.setColumns(10);
				
				ano = new JTextField();
				GridBagConstraints gbc_ano = new GridBagConstraints();
				gbc_ano.insets = new Insets(0, 0, 5, 0);
				gbc_ano.fill = GridBagConstraints.HORIZONTAL;
				gbc_ano.gridx = 4;
				gbc_ano.gridy = 3;
				panel.add(ano, gbc_ano);
				ano.setColumns(10);
		
				JLabel Coste = new JLabel("Coste");
				GridBagConstraints gbc_Coste = new GridBagConstraints();
				gbc_Coste.anchor = GridBagConstraints.EAST;
				gbc_Coste.insets = new Insets(0, 0, 5, 5);
				gbc_Coste.gridx = 1;
				gbc_Coste.gridy = 4;
				panel.add(Coste, gbc_Coste);
		
				coste = new JTextField();
				GridBagConstraints gbc_coste = new GridBagConstraints();
				gbc_coste.insets = new Insets(0, 0, 5, 0);
				gbc_coste.gridwidth = 3;
				gbc_coste.fill = GridBagConstraints.HORIZONTAL;
				gbc_coste.gridx = 2;
				gbc_coste.gridy = 4;
				panel.add(coste, gbc_coste);
				coste.setColumns(10);
	}

}
