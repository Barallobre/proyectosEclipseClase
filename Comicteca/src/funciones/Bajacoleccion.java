package funciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.VentanaPrincipal;
import utils.AccesoBaseDatos;
import utils.BotonAtras;
import utils.ComboBoxFiller;

import javax.swing.JButton;
import javax.swing.JComboBox;

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
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase construida con windowbuilder que nos permite dar de baja un una
 * colección en la base de datos
 * 
 * @author Cristian Barallobre
 * @version 20-05-2021
 * 
 */
public class Bajacoleccion extends JFrame {

	private JPanel contentPane;

	public Bajacoleccion() throws ClassNotFoundException {
		setTitle("Baja colección");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 139);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton aceptar = new JButton("Aceptar");
		panel_1.add(aceptar);
		JButton cancelar = new JButton("Atrás");
		panel_1.add(cancelar);
		BotonAtras.irAtras(cancelar, panel);

		JComboBox _autor = new JComboBox();
		GridBagConstraints gbc__autor = new GridBagConstraints();
		gbc__autor.gridwidth = 7;
		gbc__autor.insets = new Insets(0, 0, 5, 0);
		gbc__autor.fill = GridBagConstraints.HORIZONTAL;
		gbc__autor.gridx = 6;
		gbc__autor.gridy = 2;
		_autor.removeAllItems();

		JLabel autor_1 = new JLabel("Colección");
		GridBagConstraints gbc_autor_1 = new GridBagConstraints();
		gbc_autor_1.anchor = GridBagConstraints.EAST;
		gbc_autor_1.insets = new Insets(0, 0, 5, 5);
		gbc_autor_1.gridx = 1;
		gbc_autor_1.gridy = 2;
		panel.add(autor_1, gbc_autor_1);
		_autor.addItem("");
		String consulta = "select * from colecciones";
		ArrayList<String> listado = ComboBoxFiller.llenarLista(consulta);
		for (int i = 0; i < listado.size(); i++) {
			_autor.addItem(listado.get(i));
		}
		panel.add(_autor, gbc__autor);
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection conexion = AccesoBaseDatos.conexionBaseDatos();

					PreparedStatement sentencia;

					String autor = _autor.getSelectedItem().toString();
					sentencia = conexion.prepareStatement("delete from colecciones where coleccion=?");
					sentencia.setString(1, autor);
					sentencia.execute();

					sentencia.close();
					conexion.close();

					JOptionPane.showMessageDialog(null, "Colección borrada", "Comicteca", JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error al borrar la colección.", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}
}
