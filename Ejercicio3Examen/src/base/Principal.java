package base;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {
		// creamos la conexion a la base de datos dentro de un try catch
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager
					.getConnection("jdbc:mysql://localhost/cuentas_a_cobrar?serverTimezone=UTC", "root", "chios");
			ResultSet resultado1;
			ResultSet resultado;
			ResultSet resultado2;
			DatabaseMetaData objdbmd = conexion.getMetaData();

			String[] tipo = { "TABLE" };
			// buscamos que tablas forman parte de la base de datos
			resultado1 = objdbmd.getTables("cuentas_a_cobrar", null, null, tipo);
			System.out.println("Tablas dentro de Cuentas a cobrar: ");
			while (resultado1.next()) {
				String nombreTabla = resultado1.getString("TABLE_NAME");
				System.out.println(nombreTabla);
			}
			System.out.println("\n");

			/*---------------------------------------------------------------------------------------*/
			// recorremos expecificamente la tabla que hemos buscado
			resultado = objdbmd.getTables("cuentas_a_cobrar", null, "deudores", tipo);

			while (resultado.next()) {
				String nombreTabla = resultado.getString("TABLE_NAME");
				System.out.print(resultado.getString("TABLE_CAT") + " - ");
				System.out.println(nombreTabla);
				//y dentro de la tabla buscada, buscamos las columnas que la forma, el tipo de dato, el tamaño y si pude ser null
				resultado2 = objdbmd.getColumns("cuentas_a_cobrar", null, nombreTabla, null);

				while (resultado2.next()) {
					System.out.print(resultado2.getString("COLUMN_NAME") + " - ");
					System.out.print(resultado2.getString("TYPE_NAME") + ",");
					System.out.print(resultado2.getString("COLUMN_SIZE") + ",");
				}
				//aquí buscamos cuál es su clave primaria
				resultado2 = objdbmd.getPrimaryKeys("cuentas_a_cobrar", null, nombreTabla);
				while (resultado2.next()) {
					System.out.println("Clave primaria - " + resultado2.getString("COLUMN_NAME"));
				}
			}
			conexion.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Error el buscar la clase");
		} catch (SQLException e1) {
			System.out.println("Error en la base de datos");
		}
	}
}
