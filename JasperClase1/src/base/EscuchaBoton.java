package base;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class EscuchaBoton implements ActionListener {
	Ventana vta;
	private Connection conexion;

	public EscuchaBoton(Ventana vta, Connection conexion) {
		this.vta = vta;
		this.conexion = conexion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vta.boton1) {

			// Devuelve la ruta del proyecto + e l separador \ + “bin” + el separador \ + el
			// nombre del informe
			String rutaInforme = "VentasClientes.jasper";
			JasperReport informeVacio;
			try {
				informeVacio = (JasperReport) JRLoader.loadObjectFromFile(rutaInforme);
				JasperPrint informeConDatos = JasperFillManager.fillReport(informeVacio, null, conexion);
				JasperViewer visor = new JasperViewer(informeConDatos);
				visor.setVisible(true);
			} catch (JRException e1) {
				JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}
	}
}
