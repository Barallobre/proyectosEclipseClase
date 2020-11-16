package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
	public static void main (String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conex = DriverManager.getConnection("jdbc:sqlite:prueba.db");
			Statement sentencia = conex.createStatement();
			ResultSet resultado = sentencia.executeQuery("select numcli, nombre from clientes where direccion<>'Madrid'");
			while(resultado.next()) {
				System.out.println("Nº cliente"+resultado.getInt(1));
				System.out.println("Nombre "+resultado.getString(2)+"\n");
			}
			resultado.close();
			sentencia.close();
			conex.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
