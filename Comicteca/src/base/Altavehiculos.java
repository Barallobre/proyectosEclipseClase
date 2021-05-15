package base;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
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
 * Clase construida con windowbuilder que nos permite dar de alta un vehículo nuevo en la base de datos
 * @author Cristian Barallobre
 * @version 06-03-2020
 * 
 */
public class Altavehiculos extends JFrame {

	private JPanel contentPane;
	private JTextField matricula;
	private JTextField modelo;
	private JTextField observaciones;
	private JTextField numDepartamento;
	private JTextField marca;


	public Altavehiculos() {
		setTitle("Alta veh\u00EDculos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel Matrícula = new JLabel("Matr\u00EDcula");
		GridBagConstraints gbc_Matrícula = new GridBagConstraints();
		gbc_Matrícula.anchor = GridBagConstraints.EAST;
		gbc_Matrícula.insets = new Insets(0, 0, 5, 5);
		gbc_Matrícula.gridx = 2;
		gbc_Matrícula.gridy = 0;
		panel.add(Matrícula, gbc_Matrícula);
		
		matricula = new JTextField();
		GridBagConstraints gbc_matricula = new GridBagConstraints();
		gbc_matricula.insets = new Insets(0, 0, 5, 0);
		gbc_matricula.fill = GridBagConstraints.HORIZONTAL;
		gbc_matricula.gridx = 4;
		gbc_matricula.gridy = 0;
		panel.add(matricula, gbc_matricula);
		matricula.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Modelo");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		modelo = new JTextField();
		GridBagConstraints gbc_modelo = new GridBagConstraints();
		gbc_modelo.insets = new Insets(0, 0, 5, 0);
		gbc_modelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_modelo.gridx = 4;
		gbc_modelo.gridy = 1;
		panel.add(modelo, gbc_modelo);
		modelo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Obervaciones");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		observaciones = new JTextField();
		GridBagConstraints gbc_observaciones = new GridBagConstraints();
		gbc_observaciones.insets = new Insets(0, 0, 5, 0);
		gbc_observaciones.fill = GridBagConstraints.HORIZONTAL;
		gbc_observaciones.gridx = 4;
		gbc_observaciones.gridy = 2;
		panel.add(observaciones, gbc_observaciones);
		observaciones.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Numero de departamento");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		numDepartamento = new JTextField();
		GridBagConstraints gbc_numDepartamento = new GridBagConstraints();
		gbc_numDepartamento.insets = new Insets(0, 0, 5, 0);
		gbc_numDepartamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_numDepartamento.gridx = 4;
		gbc_numDepartamento.gridy = 3;
		panel.add(numDepartamento, gbc_numDepartamento);
		numDepartamento.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Marca");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		marca = new JTextField();
		GridBagConstraints gbc_marca = new GridBagConstraints();
		gbc_marca.fill = GridBagConstraints.HORIZONTAL;
		gbc_marca.gridx = 4;
		gbc_marca.gridy = 4;
		panel.add(marca, gbc_marca);
		marca.setColumns(10);
		
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
					String matricula1=matricula.getText();
					
					String modelo1 =modelo.getText();
					String observaciones1=observaciones.getText();
					int numDepartamento1=Integer.parseInt(numDepartamento.getText());
					String marca1=marca.getText();
					
					
					
					
					sentencia = conexion.prepareStatement("insert into vehiculos (matricula,modelo,Observaciones,NumDepartamento,marca) values(?,?,?,?,?)");
					sentencia.setString(1, matricula1);
					sentencia.setString(2, modelo1);
					sentencia.setString(3, observaciones1);
					sentencia.setInt(4, numDepartamento1);
					sentencia.setString(5, marca1);
					sentencia.execute();

					sentencia.close();
					conexion.close();

					JOptionPane.showMessageDialog(null, "Vehiculo añadido", "Vehículos ayuntamiento",
							JOptionPane.PLAIN_MESSAGE);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "El número de departamento debe ser un número", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "No existe ningún departamento con ese número.", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (ClassNotFoundException e1) {
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
	}

}
