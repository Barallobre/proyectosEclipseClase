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

public class Altadepartamentos extends JFrame {

	private JPanel contentPane;
	private JTextField numeroDepartamento;
	private JTextField nombreDepartamento;


	public Altadepartamentos() {
		setTitle("Alta de departamentos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 132);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero de departamento");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		numeroDepartamento = new JTextField();
		GridBagConstraints gbc_numeroDepartamento = new GridBagConstraints();
		gbc_numeroDepartamento.insets = new Insets(0, 0, 5, 0);
		gbc_numeroDepartamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_numeroDepartamento.gridx = 5;
		gbc_numeroDepartamento.gridy = 0;
		panel.add(numeroDepartamento, gbc_numeroDepartamento);
		numeroDepartamento.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de departamento");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		nombreDepartamento = new JTextField();
		GridBagConstraints gbc_nombreDepartamento = new GridBagConstraints();
		gbc_nombreDepartamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreDepartamento.gridx = 5;
		gbc_nombreDepartamento.gridy = 1;
		panel.add(nombreDepartamento, gbc_nombreDepartamento);
		nombreDepartamento.setColumns(10);
		
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
					int numeroDepartamento1 = Integer.parseInt(numeroDepartamento.getText());
					String nombreDepartamento1=nombreDepartamento.getText();

					sentencia = conexion.prepareStatement("insert into departamentos (numDepartamento,nombreDepartamento) values(?,?)");
					sentencia.setInt(1, numeroDepartamento1);
					sentencia.setString(2, nombreDepartamento1);
					sentencia.execute();

					sentencia.close();
					conexion.close();

					JOptionPane.showMessageDialog(null, "Departamento a�adido", "Veh�culos ayuntamiento",
							JOptionPane.PLAIN_MESSAGE);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "El n�mero de departamento debe ser un n�mero", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Ya existe un departamento con ese N�mero de departamento", "ERROR",
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
