package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoBaseDatos {
	public static Connection conexionBaseDatos() {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conexion = DriverManager.getConnection("jdbc:mysql://localhost/comics?serverTimezone=UTC", "root", "chios");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}
}
