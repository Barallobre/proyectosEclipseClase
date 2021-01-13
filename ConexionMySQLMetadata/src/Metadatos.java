
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Metadatos {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/clientes?serverTimezone=UTC",
					"root", "chios");

			ResultSet resultado;
			ResultSet resultado2;
			DatabaseMetaData objdbmd = conexion.getMetaData();
			//System.out.println(objdbmd.getDatabaseProductName()); // devuelve el nombre de la base de datos
			//System.out.println(objdbmd.getDriverName());
			//System.out.println(objdbmd.getURL());
			//System.out.println(objdbmd.getUserName());

			String[] tipo = { "TABLE" };
//			System.out.println(objdbmd.getTables(null, null, null, tipo)); // informacion de todas las tablas de todas
																			// las bases de datos; devuelve un resulset

			resultado = objdbmd.getTables("vehiculosayuntamiento2ev", null, "%vehiculo%"/* tabla que buscamos */, tipo);
			// al cubrir el primer parametro solo nos da datos de esa base de datos

			while (resultado.next()) {
				String nombreTabla = resultado.getString("TABLE_NAME");
				System.out.print(resultado.getString("TABLE_CAT") + " - ");
				System.out.println(nombreTabla);
				resultado2 = objdbmd.getColumns("vehiculosayuntamiento2ev", null, nombreTabla, null);
				while (resultado2.next()) {
					System.out.print(resultado2.getString("COLUMN_NAME") + " - ");
					System.out.print(resultado2.getString("TYPE_NAME") + ",");
					System.out.print(resultado2.getString("COLUMN_SIZE") + ",");
					System.out.print(resultado2.getString("IS_NULLABLE") + "\n");
				}
				resultado2 = objdbmd.getPrimaryKeys("vehiculosayuntamiento2ev", null, nombreTabla);
				while (resultado2.next()) {
					System.out.println("Clave primaria - " + resultado2.getString("COLUMN_NAME"));
				}
			}

			conexion.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
