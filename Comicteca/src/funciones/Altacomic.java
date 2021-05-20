package funciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.VentanaPrincipal;
import utils.ComboBoxFiller;

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
public class Altacomic extends JFrame {

	private JPanel contentPane;
	private JTextField _isbn;
	private JTextField _nombre;

	public Altacomic() throws ClassNotFoundException {
		setTitle("Alta de comics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 348);
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

		JLabel nombre = new JLabel("Nombre");
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.anchor = GridBagConstraints.EAST;
		gbc_nombre.insets = new Insets(0, 0, 5, 5);
		gbc_nombre.gridx = 1;
		gbc_nombre.gridy = 1;
		panel.add(nombre, gbc_nombre);

		_nombre = new JTextField();
		_nombre.setColumns(10);
		GridBagConstraints gbc__nombre = new GridBagConstraints();
		gbc__nombre.gridwidth = 2;
		gbc__nombre.insets = new Insets(0, 0, 5, 0);
		gbc__nombre.fill = GridBagConstraints.HORIZONTAL;
		gbc__nombre.gridx = 3;
		gbc__nombre.gridy = 1;
		panel.add(_nombre, gbc__nombre);

		JLabel isbn_1 = new JLabel("ISBN");
		GridBagConstraints gbc_isbn_1 = new GridBagConstraints();
		gbc_isbn_1.anchor = GridBagConstraints.EAST;
		gbc_isbn_1.insets = new Insets(0, 0, 5, 5);
		gbc_isbn_1.gridx = 1;
		gbc_isbn_1.gridy = 2;
		panel.add(isbn_1, gbc_isbn_1);

		_isbn = new JTextField();
		GridBagConstraints gbc__isbn = new GridBagConstraints();
		gbc__isbn.gridwidth = 2;
		gbc__isbn.insets = new Insets(0, 0, 5, 0);
		gbc__isbn.fill = GridBagConstraints.HORIZONTAL;
		gbc__isbn.gridx = 3;
		gbc__isbn.gridy = 2;
		panel.add(_isbn, gbc__isbn);
		_isbn.setColumns(10);

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
		String consulta = "select * from autores";
		ArrayList<String> listado = ComboBoxFiller.llenarLista(consulta);
		for (int i = 0; i < listado.size(); i++) {
			_autor.addItem(listado.get(i));
		}
		panel.add(_autor, gbc__autor);

		JLabel editorial_1 = new JLabel("Editorial");
		GridBagConstraints gbc_editorial_1 = new GridBagConstraints();
		gbc_editorial_1.anchor = GridBagConstraints.EAST;
		gbc_editorial_1.insets = new Insets(0, 0, 5, 5);
		gbc_editorial_1.gridx = 1;
		gbc_editorial_1.gridy = 4;
		panel.add(editorial_1, gbc_editorial_1);

		JComboBox _editorial = new JComboBox();
		GridBagConstraints gbc__editorial = new GridBagConstraints();
		gbc__editorial.gridwidth = 2;
		gbc__editorial.insets = new Insets(0, 0, 5, 0);
		gbc__editorial.fill = GridBagConstraints.HORIZONTAL;
		gbc__editorial.gridx = 3;
		gbc__editorial.gridy = 4;
		_editorial.removeAllItems();
		_editorial.addItem("");
		String consulta2 = "select * from editoriales";
		ArrayList<String> listado2 = ComboBoxFiller.llenarLista(consulta2);
		for (int i = 0; i < listado2.size(); i++) {
			_editorial.addItem(listado2.get(i));
		}
		panel.add(_editorial, gbc__editorial);

		JLabel Tipo = new JLabel("Tipo");
		GridBagConstraints gbc_Tipo = new GridBagConstraints();
		gbc_Tipo.anchor = GridBagConstraints.EAST;
		gbc_Tipo.insets = new Insets(0, 0, 5, 5);
		gbc_Tipo.gridx = 1;
		gbc_Tipo.gridy = 5;

		panel.add(Tipo, gbc_Tipo);

		JComboBox _tipo = new JComboBox();
		GridBagConstraints gbc__tipo = new GridBagConstraints();
		gbc__tipo.gridwidth = 2;
		gbc__tipo.insets = new Insets(0, 0, 5, 0);
		gbc__tipo.fill = GridBagConstraints.HORIZONTAL;
		gbc__tipo.gridx = 3;
		gbc__tipo.gridy = 5;
		_tipo.removeAllItems();
		_tipo.addItem("");
		String consulta3 = "select * from tipos";
		ArrayList<String> listado3 = ComboBoxFiller.llenarLista(consulta3);
		for (int i = 0; i < listado3.size(); i++) {
			_tipo.addItem(listado3.get(i));
		}
		panel.add(_tipo, gbc__tipo);

		JLabel subtipo = new JLabel("Subtipo");
		GridBagConstraints gbc_subtipo = new GridBagConstraints();
		gbc_subtipo.anchor = GridBagConstraints.EAST;
		gbc_subtipo.insets = new Insets(0, 0, 5, 5);
		gbc_subtipo.gridx = 1;
		gbc_subtipo.gridy = 6;
		panel.add(subtipo, gbc_subtipo);

		JComboBox _subtipo = new JComboBox();
		GridBagConstraints gbc__subtipo = new GridBagConstraints();
		gbc__subtipo.gridwidth = 2;
		gbc__subtipo.insets = new Insets(0, 0, 5, 0);
		gbc__subtipo.fill = GridBagConstraints.HORIZONTAL;
		gbc__subtipo.gridx = 3;
		gbc__subtipo.gridy = 6;
		String consulta5 = "select subtipo from subtipos";
		ArrayList<String> listado5 = ComboBoxFiller.llenarLista(consulta5);
		for (int i = 0; i < listado5.size(); i++) {
			_subtipo.addItem(listado5.get(i));
		}
		panel.add(_subtipo, gbc__subtipo);

		JLabel coleccion_1 = new JLabel("Colecci\u00F3n");
		GridBagConstraints gbc_coleccion_1 = new GridBagConstraints();
		gbc_coleccion_1.anchor = GridBagConstraints.EAST;
		gbc_coleccion_1.insets = new Insets(0, 0, 5, 5);
		gbc_coleccion_1.gridx = 1;
		gbc_coleccion_1.gridy = 7;
		panel.add(coleccion_1, gbc_coleccion_1);

		JComboBox _coleccion = new JComboBox();
		GridBagConstraints gbc__coleccion = new GridBagConstraints();
		gbc__coleccion.gridwidth = 2;
		gbc__coleccion.insets = new Insets(0, 0, 5, 0);
		gbc__coleccion.fill = GridBagConstraints.HORIZONTAL;
		gbc__coleccion.gridx = 3;
		gbc__coleccion.gridy = 7;
		_coleccion.removeAllItems();
		_coleccion.addItem("");
		String consulta4 = "select * from colecciones";
		ArrayList<String> listado4 = ComboBoxFiller.llenarLista(consulta4);
		for (int i = 0; i < listado4.size(); i++) {
			_coleccion.addItem(listado4.get(i));
		}
		panel.add(_coleccion, gbc__coleccion);

		JLabel leido_1 = new JLabel("Le\u00EDdo");
		GridBagConstraints gbc_leido_1 = new GridBagConstraints();
		gbc_leido_1.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc_leido_1.insets = new Insets(0, 0, 0, 5);
		gbc_leido_1.gridx = 1;
		gbc_leido_1.gridy = 8;
		panel.add(leido_1, gbc_leido_1);

		JComboBox _leido = new JComboBox();
		GridBagConstraints gbc__leido = new GridBagConstraints();
		gbc__leido.gridwidth = 2;
		gbc__leido.fill = GridBagConstraints.HORIZONTAL;
		gbc__leido.gridx = 3;
		gbc__leido.gridy = 8;
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
					String nombre = _nombre.getText();
					String isbn = _isbn.getText();
					String autor = _autor.getSelectedItem().toString();
					String editorial = _editorial.getSelectedItem().toString();
					String tipo = _tipo.getSelectedItem().toString();
					String coleccion = _coleccion.getSelectedItem().toString();
					String subtipo = _subtipo.getSelectedItem().toString();
					int leido;
					if ((_leido.getSelectedItem().toString()).equals("si")) {
						leido = 1;
					} else {
						leido = 0;
					}

					sentencia = conexion.prepareStatement(
							"insert into comics (isbn,autor,editorial,tipo,coleccion,Nombre,subtipo) values(?,?,?,?,?,?,?)");

					sentencia.setString(1, isbn);
					sentencia.setString(2, autor);
					sentencia.setString(3, editorial);
					sentencia.setString(4, tipo);
					sentencia.setString(5, coleccion);
					sentencia.setString(6, nombre);
					sentencia.setString(7, subtipo);
					sentencia.execute();

					sentencia.close();

					Date objDate = new Date();
					String strDateFormat = "yyyy-MM-dd";
					SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
					String fechaFinal = objSDF.format(objDate);

					Date fechaLeido = java.sql.Date.valueOf(fechaFinal);

					sentencia2 = conexion.prepareStatement("insert into leidos (isbn,leido,fecha) values(?,?,?)");
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
					JOptionPane.showMessageDialog(null, "Ha introducido mal algún dato en base de datos.", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null, "Ha introducido  algún dato erroneo.", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Clase no encontrada", null, JOptionPane.PLAIN_MESSAGE);
					e1.printStackTrace();
				}
			}
		});

	}

}
