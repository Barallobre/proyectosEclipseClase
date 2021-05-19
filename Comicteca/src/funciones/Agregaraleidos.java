package funciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.VentanaPrincipal;

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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.swing.JComboBox;

/**
 * Clase construida con windowbuilder que nos permite dar de alta un nuevo comic
 * en la base de datos
 * 
 * @author Cristian Barallobre
 * @version 19-05-2021
 * 
 */
public class Agregaraleidos extends JFrame {

	private JPanel contentPane;
	private JTextField _isbn;
	private JTextField _nombre;

	public Agregaraleidos() throws ClassNotFoundException {
		setTitle("Alta de comics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton aceptar = new JButton("Aceptar");
		panel_1.add(aceptar);

		JButton cancelar = new JButton("Atrás");
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
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 30, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel isbn_1 = new JLabel("ISBN");
		GridBagConstraints gbc_isbn_1 = new GridBagConstraints();
		gbc_isbn_1.anchor = GridBagConstraints.EAST;
		gbc_isbn_1.insets = new Insets(0, 0, 5, 5);
		gbc_isbn_1.gridx = 1;
		gbc_isbn_1.gridy = 1;
		panel.add(isbn_1, gbc_isbn_1);

		JComboBox _isbn_1 = new JComboBox();
		GridBagConstraints gbc__isbn_1 = new GridBagConstraints();
		gbc__isbn_1.gridwidth = 2;
		gbc__isbn_1.insets = new Insets(0, 0, 5, 0);
		gbc__isbn_1.fill = GridBagConstraints.HORIZONTAL;
		gbc__isbn_1.gridx = 3;
		gbc__isbn_1.gridy = 1;
		_isbn_1.removeAllItems();
		_isbn_1.addItem("");
		String consulta0 = "select isbn from comics";
		ArrayList<String> listado0 = llenarLista(consulta0);
		for (int i = 0; i < listado0.size(); i++) {
			_isbn_1.addItem(listado0.get(i));
		}
		panel.add(_isbn_1, gbc__isbn_1);

		JLabel leido_1 = new JLabel("Le\u00EDdo");
		GridBagConstraints gbc_leido_1 = new GridBagConstraints();
		gbc_leido_1.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc_leido_1.insets = new Insets(0, 0, 5, 5);
		gbc_leido_1.gridx = 1;
		gbc_leido_1.gridy = 3;
		panel.add(leido_1, gbc_leido_1);

		JComboBox _leido = new JComboBox();
		GridBagConstraints gbc__leido = new GridBagConstraints();
		gbc__leido.insets = new Insets(0, 0, 5, 0);
		gbc__leido.gridwidth = 2;
		gbc__leido.fill = GridBagConstraints.HORIZONTAL;
		gbc__leido.gridx = 3;
		gbc__leido.gridy = 3;
		_leido.addItem("si");
		_leido.addItem("no");
		panel.add(_leido, gbc__leido);

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conexion = DriverManager
							.getConnection("jdbc:mysql://localhost/comics?serverTimezone=UTC", "root", "chios");

					PreparedStatement sentencia;
					PreparedStatement sentencia2;
					String isbn = _isbn_1.getSelectedItem().toString();

					int leido;
					if ((_leido.getSelectedItem().toString()).equals("si")) {
						leido = 1;
					} else {
						leido = 0;
					}

					Date objDate = new Date();
					String strDateFormat = "yyyy-MM-dd";
					SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
					String fechaFinal = objSDF.format(objDate);

					Date fechaLeido = java.sql.Date.valueOf(fechaFinal);

					sentencia2 = conexion.prepareStatement("update leidos set leido=?,fecha=? where isbn=?");
					sentencia2.setInt(1, leido);
					sentencia2.setDate(2, (java.sql.Date) fechaLeido);
					sentencia2.setString(3,isbn);
					sentencia2.execute();
					sentencia2.close();

					conexion.close();

					JOptionPane.showMessageDialog(null, "Comic añadido", "Comicteca", JOptionPane.PLAIN_MESSAGE);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Error introduciendo parámetros", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Ha introducido mal algún dato.", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null, "Ha introducido mal algún dato.", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Clase no encontrada", null, JOptionPane.PLAIN_MESSAGE);
					e1.printStackTrace();
				}
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
