import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class conexionSQL {
	static Connection conexion = null;
	//static Statement sentencia;
	static String ruta = "jdbc:mysql://localhost/productos2021?serverTimezone=UTC";
	static String usuario = "root";
	static String contrasinal = "chios";
	
	public conexionSQL() {
	}
	
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(ruta, usuario, contrasinal);
			
			//sentencia = conexion.createStatement();
			System.out.println("Conexión OK");

			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conexion;
	}
	
	public Connection desconectar() throws SQLException {
		conexion.close();
		return conexion;
	}
	
	
	

	public static ArrayList<String> encher_combo() {

		ArrayList<String> listado = new ArrayList<String>();
		Statement sentencia;
		ResultSet resultado = null;
		try {
			conexionSQL conexion = new conexionSQL();
			sentencia = conexionSQL.conectar().createStatement();
			String q = "SELECT * from productos";
			resultado = sentencia.executeQuery(q);
			
			System.out.println("Combo cheo");
		
			while (resultado.next()) {
				listado.add(resultado.getString("nombre"));

			}
			resultado.close();
			sentencia.close();
			conexion.desconectar();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listado;

	}

}
