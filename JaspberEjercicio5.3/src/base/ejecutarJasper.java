package base;
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

public class ejecutarJasper {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, JRException {
		String rutaInforme = System.getProperty("user.dir") + System.getProperty("file.separator");rutaInforme+="bin"+System.getProperty("file.separator")+"sakila3.jasper";
		JasperReport informeVacio = (JasperReport) JRLoader.loadObjectFromFile(rutaInforme);
		String idDesde="12";
		String idHasta="20";

		Map<String,Object> parametros = new HashMap<String,Object>();

		parametros.put("idDesde",idDesde);parametros.put("idHasta",idHasta);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sakila?serverTimezone=UTC","root", "chios");
		JasperPrint informeConDatos = JasperFillManager.fillReport(informeVacio, parametros, conexion);
		JasperViewer visor = new JasperViewer(informeConDatos);
		visor.setTitle("Listado con parámetros");
		visor.setVisible(true);
	}
}
