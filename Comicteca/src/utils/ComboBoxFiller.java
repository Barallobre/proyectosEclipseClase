package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ComboBoxFiller {
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
