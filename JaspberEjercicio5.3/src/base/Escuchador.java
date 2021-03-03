package base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Escuchador implements ActionListener {
	String idDesde;
	String idHasta;
	private Ventana ventana;

	public Escuchador(Ventana ventana) {

		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		if (comando.equals("Mostrar informe")) {
			idDesde = ventana.idDesde.getText();
			idHasta = ventana.idHasta.getText();
			System.out.println(idDesde + idHasta);
			String rutaInforme = System.getProperty("user.dir") + System.getProperty("file.separator");
			rutaInforme += "bin" + System.getProperty("file.separator") + "sakila3.jasper";
			JasperReport informeVacio;
			try {
				informeVacio = (JasperReport) JRLoader.loadObjectFromFile(rutaInforme);

				Map<String, Object> parametros = new HashMap<String, Object>();

				parametros.put("idDesde", idDesde);
				parametros.put("idHasta", idHasta);

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sakila?serverTimezone=UTC",
						"root", "chios");
				JasperPrint informeConDatos = JasperFillManager.fillReport(informeVacio, parametros, conexion);
				JasperViewer visor = new JasperViewer(informeConDatos);
				visor.setTitle("Listado con parámetros");
				visor.setVisible(true);
			} catch (JRException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
