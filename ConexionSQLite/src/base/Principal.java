package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
	public static void main (String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conex = DriverManager.getConnection("jdbc:sqlite:prueba.db");
			Statement sentencia = conex.createStatement();
			//sentencia.execute("insert into clientes values (40,'Pepe', 'León')");
			//sentencia.execute("create table ventas (numventa int primary key, venta int)");
			//sentencia.execute("insert into ventas values (1,100),(2,1500)");
			
			ResultSet resultado = sentencia.executeQuery("select numcli, nombre from clientes where direccion<>'Madrid'");
			resultado = sentencia.executeQuery("select venta from ventas");
			
//			while(resultado.next()) {
//				System.out.println(resultado.getInt(1));
//			}
			
			
			while(resultado.next()) {
				System.out.println("Nº cliente"+resultado.getInt(1));
				System.out.println("Nombre "+resultado.getString(2)+"\n");
			}
			
//			PreparedStatement sentencia2 = conex.prepareStatement("insert into clientes values(?,?,?)");
//			sentencia2.setInt(1, 50);
//			sentencia2.setString(2, "Joaquin");
//			sentencia2.setString(3, "Lugo");
//			sentencia2.execute();
			
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
