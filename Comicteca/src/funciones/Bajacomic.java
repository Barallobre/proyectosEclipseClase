package funciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.VentanaPrincipal;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.FlowLayout;
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
 * Clase construida con windowbuilder que nos permite dar de baja un comic en la
 * base de datos
 * 
 * @author Cristian Barallobre
 * @version 19-05-2021
 * 
 */
public class Bajacomic extends JFrame {

	private JPanel contentPane;
	private JTextField numMantenimiento;

	public Bajacomic() throws ClassNotFoundException {
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

		JLabel autor_1 = new JLabel("Título");
		GridBagConstraints gbc_autor_1 = new GridBagConstraints();
		gbc_autor_1.anchor = GridBagConstraints.EAST;
		gbc_autor_1.insets = new Insets(0, 0, 5, 5);
		gbc_autor_1.gridx = 1;
		gbc_autor_1.gridy = 3;
		panel.add(autor_1, gbc_autor_1);

		JComboBox _titulo = new JComboBox();
		GridBagConstraints gbc__autor = new GridBagConstraints();
		gbc__autor.gridwidth = 2;
		gbc__autor.insets = new Insets(0, 0, 5, 0);
		gbc__autor.fill = GridBagConstraints.HORIZONTAL;
		gbc__autor.gridx = 3;
		gbc__autor.gridy = 3;
		_titulo.removeAllItems();
		_titulo.addItem("");
		String consulta = "select Nombre from comics";
		ArrayList<String> listado = llenarLista(consulta);
		for (int i = 0; i < listado.size(); i++) {
			_titulo.addItem(listado.get(i));
		}
		panel.add(_titulo, gbc__autor);

		JButton aceptar = new JButton("Aceptar");
		panel.add(aceptar);
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conexion = DriverManager
							.getConnection("jdbc:mysql://localhost/comics?serverTimezone=UTC", "root", "chios");

					PreparedStatement sentencia;
					PreparedStatement sentencia2;
					String titulo = _titulo.getSelectedItem().toString();

					sentencia = conexion
							.prepareStatement("delete from leidos where isbn=(select isbn from comics where Nombre=?)");
					sentencia.setString(1, titulo);
					sentencia.execute();

					sentencia.close();

					sentencia2 = conexion.prepareStatement("delete from comics where Nombre=?");
					sentencia2.setString(1, titulo);
					sentencia2.execute();

					sentencia2.close();
					conexion.close();

					JOptionPane.showMessageDialog(null, "Comic borrado", "Comicteca", JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error al borrar el comic.", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		JButton cancelar = new JButton("Atrás");
		panel.add(cancelar);
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

	public static ArrayList<String> llenarLista(String consulta) throws ClassNotFoundException {

		ArrayList<String> listado = new ArrayList<String>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/comics?serverTimezone=UTC",
					"root", "chios");

			Statement sentencia = conexion.createStatement();

			ResultSet resultado = sentencia.executeQuery(consulta);

			ResultSetMetaData metadata = resultado.getMetaData();
			int numberOfColumns = metadata.getColumnCount();
			while (resultado.next()) {
				int i = 1;
				while (i <= numberOfColumns) {
					listado.add(resultado.getString(i++));
				}
			}
			resultado.close();
			sentencia.close();
			conexion.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Error en el acceso a base de datos", "Error",
					JOptionPane.PLAIN_MESSAGE);
		}

		return listado;

	}
}
