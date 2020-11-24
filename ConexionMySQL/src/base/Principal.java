package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Principal {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/clientes?serverTimezone=UTC",
					"root", "chios");
			
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("select * from clientes");
		
			
			
			while(resultado.next()) {
				System.out.println("Nº cliente"+resultado.getInt(1));
				System.out.println("Nombre "+resultado.getString(2)+"\n");
			}
			
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
