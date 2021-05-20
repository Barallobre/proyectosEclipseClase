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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase construida con windowbuilder que nos permite dar de baja un tipo en la
 * base de datos
 * 
 * @author Cristian Barallobre
 * @version 19-05-2021
 * 
 */
public class Bajatipos extends JFrame {

	private JPanel contentPane;

	public Bajatipos() throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 103);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel autor_1 = new JLabel("Autor");
		GridBagConstraints gbc_autor_1 = new GridBagConstraints();
		gbc_autor_1.anchor = GridBagConstraints.EAST;
		gbc_autor_1.insets = new Insets(0, 0, 5, 5);
		gbc_autor_1.gridx = 1;
		gbc_autor_1.gridy = 3;
		panel.add(autor_1, gbc_autor_1);

		JComboBox _autor = new JComboBox();
		GridBagConstraints gbc__autor = new GridBagConstraints();
		gbc__autor.gridwidth = 2;
		gbc__autor.insets = new Insets(0, 0, 5, 0);
		gbc__autor.fill = GridBagConstraints.HORIZONTAL;
		gbc__autor.gridx = 3;
		gbc__autor.gridy = 3;
		_autor.removeAllItems();
		_autor.addItem("");
		String consulta = "select * from tipos";
		ArrayList<String> listado = ComboBoxFiller.llenarLista(consulta);
		for (int i = 0; i < listado.size(); i++) {
			_autor.addItem(listado.get(i));
		}
		panel.add(_autor, gbc__autor);

		JButton aceptar = new JButton("Aceptar");
		panel.add(aceptar);
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection conexion = AccesoBaseDatos.conexionBaseDatos();

					PreparedStatement sentencia;

					String autor = _autor.getSelectedItem().toString();
					sentencia = conexion.prepareStatement("delete from tipos where tipo=?");
					sentencia.setString(1, autor);
					sentencia.execute();

					sentencia.close();
					conexion.close();

					JOptionPane.showMessageDialog(null, "Tipo borrado", "Comicteca", JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error al borrar el tipo en base de datos.", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		JButton cancelar = new JButton("Cancelar");
		panel.add(cancelar);
		BotonAtras.irAtras(cancelar, panel);
	}
}
