package funciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.VentanaPrincipal;
import utils.AccesoBaseDatos;
import utils.BotonAtras;

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
 * Clase construida con windowbuilder que nos permite dar de alta un autor
 * nuevo en la base de datos
 * 
 * @author Cristian Barallobre
 * @version 19-05-2021
 * 
 */
public class Altaautor extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;

	public Altaautor() {
		setTitle("Alta autor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel Nombre = new JLabel("Nombre");
		GridBagConstraints gbc_Nombre = new GridBagConstraints();
		gbc_Nombre.anchor = GridBagConstraints.EAST;
		gbc_Nombre.insets = new Insets(0, 0, 5, 5);
		gbc_Nombre.gridx = 2;
		gbc_Nombre.gridy = 2;
		panel.add(Nombre, gbc_Nombre);

		nombre = new JTextField();
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.insets = new Insets(0, 0, 5, 0);
		gbc_nombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombre.gridx = 4;
		gbc_nombre.gridy = 2;
		panel.add(nombre, gbc_nombre);
		nombre.setColumns(10);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton aceptar = new JButton("Aceptar");
		panel_1.add(aceptar);
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection conexion = AccesoBaseDatos.conexionBaseDatos();

					PreparedStatement sentencia;
					String Nombre_autor = nombre.getText();

					sentencia = conexion.prepareStatement("insert into autores (autor) values(?)");
					sentencia.setString(1, Nombre_autor);
					sentencia.execute();

					sentencia.close();
					conexion.close();

					JOptionPane.showMessageDialog(null, "Autor añadido", "Comicteca",
							JOptionPane.PLAIN_MESSAGE);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Error en el formato de la inserción", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error en la inserción", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
		JButton cancelar = new JButton("Atrás");
		panel_1.add(cancelar);
		BotonAtras.irAtras(cancelar, panel);
	}

}
