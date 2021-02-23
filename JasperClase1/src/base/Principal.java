package base;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sakila?serverTimezone=UTC","root","chios");
					Ventana vta = new Ventana();
					vta.setVisible(true);
					EscuchaBoton eb = new EscuchaBoton(vta,conexion);
					vta.asignaEscuchadores(eb);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
