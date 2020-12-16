package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Parte2 {
	static Scanner sc = new Scanner(System.in);
/*Desde el main de la clase llamamos a los distintos métodos de cada apartado*/
	public static void main(String[] args) {
//Al llamar a los metodos los metemos en un try catch ya que gestionamos las excepciones en el main
		try {
			//creamos la conexion a la base de datos y a cada metodo le enviamos como parametro la conexion
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager
					.getConnection("jdbc:mysql://localhost/cuentas_a_cobrar?serverTimezone=UTC", "root", "chios");
			apartadoA(conexion);
			apartadoB(conexion);
			apartadoC(conexion);
			apartadoD(conexion);
		} catch (ClassNotFoundException e) {
			System.out.println("Error en la clase introducida.");
			e.printStackTrace();
		} catch (SQLException e1) {
			System.out.println("Error al acceder a la base de datos.");
			e1.printStackTrace();
		}
	}
//método que mediante Statement crea una sentencia que será ejecutada por la base de datos
	public static void apartadoA(Connection conexion) throws ClassNotFoundException, SQLException {

		Statement sentencia = conexion.createStatement();
		sentencia.execute("insert into deudores values (30,'Cristian','Madrid',1200) ");

	}
	//método que mediante Statement crea una sentencia que será ejecutada por la base de datos
	public static void apartadoB(Connection conexion) throws ClassNotFoundException, SQLException {
		System.out.println("Introduzca el codigo que desea modificar: ");
		int codigo = sc.nextInt();
		Statement sentencia = conexion.createStatement();
		sentencia.execute("update Deudores set TotalDeuda=0 where CodDeudor="+codigo);
	}
	//método que mediante Statement crea una sentencia que será ejecutada por la base de datos
	public static void apartadoC(Connection conexion) throws ClassNotFoundException, SQLException {
		Statement sentencia = conexion.createStatement();
		sentencia.execute("delete from deudores where codDeudor=30");
	}
	//método que mediante Statement y un Resulset crea una sentencia que hará una consulta a la base de datos
	public static void apartadoD(Connection conexion) throws ClassNotFoundException, SQLException {
		Statement sentencia = conexion.createStatement();
		ResultSet resultado = sentencia.executeQuery("select*from deudores where Provincia=\"Lugo\" and TotalDeuda>=6000 order by 1 desc");
		//el resultado debe leerse con un while para ir pasado por cada tipo de dato
		while(resultado.next()) {
			System.out.println("Código "+resultado.getInt(1));
			System.out.println("Nombre "+resultado.getString(2));
			System.out.println("Provincia "+resultado.getString(3));
			System.out.println("Deuda "+resultado.getInt(4));
		}
	}
}