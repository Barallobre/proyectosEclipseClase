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
 * Clase construida con windowbuilder que nos permite dar de alta un nuevo
 * mantenimiento en la base de datos
 * 
 * @author Cristian Barallobre
 * @version 06-03-2020
 * 
 */
public class Altacomic extends JFrame {

	private JPanel contentPane;
	private JTextField _isbn;

	public Altacomic() throws ClassNotFoundException {
		setTitle("Alta de mantenimientos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton aceptar = new JButton("Aceptar");
		panel_1.add(aceptar);

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
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 30, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel isbn = new JLabel("ISBN");
		GridBagConstraints gbc_isbn = new GridBagConstraints();
		gbc_isbn.anchor = GridBagConstraints.EAST;
		gbc_isbn.insets = new Insets(0, 0, 5, 5);
		gbc_isbn.gridx = 1;
		gbc_isbn.gridy = 0;
		panel.add(isbn, gbc_isbn);

		_isbn = new JTextField();
		GridBagConstraints gbc__isbn = new GridBagConstraints();
		gbc__isbn.gridwidth = 2;
		gbc__isbn.insets = new Insets(0, 0, 5, 0);
		gbc__isbn.fill = GridBagConstraints.HORIZONTAL;
		gbc__isbn.gridx = 3;
		gbc__isbn.gridy = 0;
		panel.add(_isbn, gbc__isbn);
		_isbn.setColumns(10);

		JLabel autor = new JLabel("Autor");
		GridBagConstraints gbc_autor = new GridBagConstraints();
		gbc_autor.anchor = GridBagConstraints.EAST;
		gbc_autor.insets = new Insets(0, 0, 5, 5);
		gbc_autor.gridx = 1;
		gbc_autor.gridy = 1;
		panel.add(autor, gbc_autor);

		JComboBox _autor = new JComboBox();
		GridBagConstraints gbc__autor = new GridBagConstraints();
		gbc__autor.gridwidth = 2;
		gbc__autor.insets = new Insets(0, 0, 5, 0);
		gbc__autor.fill = GridBagConstraints.HORIZONTAL;
		gbc__autor.gridx = 3;
		gbc__autor.gridy = 1;

		String consulta = "select * from autores";
		ArrayList<String> listado = llenarLista(consulta);
		_autor.removeAllItems();
		_autor.addItem("");
		for (int i = 0; i < listado.size(); i++) {
			_autor.addItem(listado.get(i));
		}

		panel.add(_autor, gbc__autor);

		JLabel editorial = new JLabel("Editorial");
		GridBagConstraints gbc_editorial = new GridBagConstraints();
		gbc_editorial.anchor = GridBagConstraints.EAST;
		gbc_editorial.insets = new Insets(0, 0, 5, 5);
		gbc_editorial.gridx = 1;
		gbc_editorial.gridy = 2;
		panel.add(editorial, gbc_editorial);

		JComboBox _editorial = new JComboBox();
		GridBagConstraints gbc__editorial = new GridBagConstraints();
		gbc__editorial.gridwidth = 2;
		gbc__editorial.insets = new Insets(0, 0, 5, 5);
		gbc__editorial.fill = GridBagConstraints.HORIZONTAL;
		gbc__editorial.gridx = 3;
		gbc__editorial.gridy = 2;

		String consulta2 = "select * from editoriales";
		ArrayList<String> listado2 = llenarLista(consulta2);
		_editorial.removeAllItems();
		_editorial.addItem("");
		for (int i = 0; i < listado2.size(); i++) {
			_editorial.addItem(listado2.get(i));
		}

		panel.add(_editorial, gbc__editorial);

		JLabel FechaMantenimiento = new JLabel("Tipo");
		GridBagConstraints gbc_FechaMantenimiento = new GridBagConstraints();
		gbc_FechaMantenimiento.anchor = GridBagConstraints.EAST;
		gbc_FechaMantenimiento.insets = new Insets(0, 0, 5, 5);
		gbc_FechaMantenimiento.gridx = 1;
		gbc_FechaMantenimiento.gridy = 3;

		panel.add(FechaMantenimiento, gbc_FechaMantenimiento);

		JComboBox _tipo = new JComboBox();
		GridBagConstraints gbc__tipo = new GridBagConstraints();
		gbc__tipo.gridwidth = 2;
		gbc__tipo.insets = new Insets(0, 0, 5, 5);
		gbc__tipo.fill = GridBagConstraints.HORIZONTAL;
		gbc__tipo.gridx = 3;
		gbc__tipo.gridy = 3;

		String consulta3 = "select * from tipos";
		ArrayList<String> listado3 = llenarLista(consulta3);
		_tipo.removeAllItems();
		_tipo.addItem("");
		for (int i = 0; i < listado3.size(); i++) {
			_tipo.addItem(listado3.get(i));
		}

		panel.add(_tipo, gbc__tipo);

		JLabel subtipo = new JLabel("Subtipo");
		GridBagConstraints gbc_subtipo = new GridBagConstraints();
		gbc_subtipo.anchor = GridBagConstraints.EAST;
		gbc_subtipo.insets = new Insets(0, 0, 5, 5);
		gbc_subtipo.gridx = 1;
		gbc_subtipo.gridy = 4;
		panel.add(subtipo, gbc_subtipo);

		JComboBox _subtipo = new JComboBox();
		GridBagConstraints gbc__subtipo = new GridBagConstraints();
		gbc__subtipo.gridwidth = 2;
		gbc__subtipo.insets = new Insets(0, 0, 5, 5);
		gbc__subtipo.fill = GridBagConstraints.HORIZONTAL;
		gbc__subtipo.gridx = 3;
		gbc__subtipo.gridy = 4;
		panel.add(_subtipo, gbc__subtipo);

		JLabel coleccion = new JLabel("Colecci\u00F3n");
		GridBagConstraints gbc_coleccion = new GridBagConstraints();
		gbc_coleccion.anchor = GridBagConstraints.EAST;
		gbc_coleccion.insets = new Insets(0, 0, 5, 5);
		gbc_coleccion.gridx = 1;
		gbc_coleccion.gridy = 5;
		panel.add(coleccion, gbc_coleccion);

		JComboBox _coleccion = new JComboBox();
		GridBagConstraints gbc__coleccion = new GridBagConstraints();
		gbc__coleccion.gridwidth = 2;
		gbc__coleccion.insets = new Insets(0, 0, 5, 5);
		gbc__coleccion.fill = GridBagConstraints.HORIZONTAL;
		gbc__coleccion.gridx = 3;
		gbc__coleccion.gridy = 5;

		String consulta4 = "select * from colecciones";
		ArrayList<String> listado4 = llenarLista(consulta4);
		_coleccion.removeAllItems();
		_coleccion.addItem("");
		for (int i = 0; i < listado4.size(); i++) {
			_coleccion.addItem(listado4.get(i));
		}

		panel.add(_coleccion, gbc__coleccion);

		JLabel leido = new JLabel("Le\u00EDdo");
		GridBagConstraints gbc_leido = new GridBagConstraints();
		gbc_leido.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc_leido.insets = new Insets(0, 0, 5, 5);
		gbc_leido.gridx = 1;
		gbc_leido.gridy = 6;
		panel.add(leido, gbc_leido);

		JComboBox _leido = new JComboBox();
		GridBagConstraints gbc__leido = new GridBagConstraints();
		gbc__leido.gridwidth = 2;
		gbc__leido.insets = new Insets(0, 0, 5, 5);
		gbc__leido.fill = GridBagConstraints.HORIZONTAL;
		gbc__leido.gridx = 3;
		gbc__leido.gridy = 6;
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
					String isbn = _isbn.getText();
					String autor = _autor.getSelectedItem().toString();
					String editorial = _editorial.getSelectedItem().toString();
					String tipo = _tipo.getSelectedItem().toString();
					String coleccion = _coleccion.getSelectedItem().toString();

					int leido;
					if ((_leido.getSelectedItem().toString()).equals("si")) {
						leido = 1;
					} else {
						leido = 0;
					}

					sentencia = conexion.prepareStatement(
							"insert into comics (isbn,autor,editorial,tipo,coleccion) values(?,?,?,?,?)");
					sentencia.setString(1, isbn);
					sentencia.setString(2, autor);
					sentencia.setString(3, editorial);
					sentencia.setString(4, tipo);
					sentencia.setString(5, coleccion);

					sentencia.execute();

					sentencia.close();

					Date objDate = new Date();
					String strDateFormat = "yyyy-MM-dd";
					SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
					String fechaFinal = objSDF.format(objDate);

					Date fechaLeido = java.sql.Date.valueOf(fechaFinal);
					System.out.println(isbn);
					System.out.println(leido);
					System.out.println(fechaLeido);
					
					sentencia2 = conexion.prepareStatement("insert into leidos (id_leido,leido,fecha) values(?,?,?)");
					sentencia2.setString(1, isbn);
					sentencia2.setInt(2, leido);
					sentencia2.setDate(3, (java.sql.Date) fechaLeido);
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
					JOptionPane.showMessageDialog(null, null, null, JOptionPane.PLAIN_MESSAGE);
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
			System.out.println(numberOfColumns);
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

			JOptionPane.showMessageDialog(null, "Error no acceso á base de datos12", "Error",
					JOptionPane.PLAIN_MESSAGE);
		}

		return listado;

	}
}
