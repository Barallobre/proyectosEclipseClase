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
 * Clase construida con windowbuilder que nos permite dar de baja un tipo de mantenimiento en la base de datos
 * @author Cristian Barallobre
 * @version 06-03-2020
 * 
 */
public class Bajacoleccion extends JFrame {

	private JPanel contentPane;
	private JTextField tipoMantenimiento;


	public Bajacoleccion() {
		setTitle("Baja de tipo de mantenimiento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 102);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Tipo de mantenimiento");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		tipoMantenimiento = new JTextField();
		GridBagConstraints gbc_tipoMantenimiento = new GridBagConstraints();
		gbc_tipoMantenimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_tipoMantenimiento.gridx = 5;
		gbc_tipoMantenimiento.gridy = 0;
		panel.add(tipoMantenimiento, gbc_tipoMantenimiento);
		tipoMantenimiento.setColumns(10);
		
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
		
					String tipoMantenimiento1 = tipoMantenimiento.getText();
			

					sentencia = conexion.prepareStatement("delete from tiposmantenimiento where tipoMantenimiento=?");
					sentencia.setString(1, tipoMantenimiento1);
					sentencia.execute();

					sentencia.close();
					conexion.close();

					JOptionPane.showMessageDialog(null, "Tipo de Mantenimiento borrado", "Vehículos ayuntamiento",
							JOptionPane.PLAIN_MESSAGE);
				}  catch (SQLException | ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "No se puede borrar este mantenimiento, porque figura en mantenimiento?"
							+ "\nBorre primero los mantenimientos antes de proceder al borrado del tipo de mantenimiento.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		JButton cancelar = new JButton("Cancelar");
		panel_1.add(cancelar);
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
	}

}
