package funciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.VentanaPrincipal;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import utils.AccesoBaseDatos;
import utils.BotonAtras;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
/**
 * Clase que nos permite listar en un informe los comics existentes dentro de la base de datos
 * @author Cristian Barallobre
 * @version 19-05-2021
 * 
 */
public class Consultacomics extends JFrame {

	private JPanel contentPane;

	public Consultacomics() {
		setTitle("Consulta de los comics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 104);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Generar informe con todos los comics guardados");
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton aceptar = new JButton("Aceptar");
		panel_1.add(aceptar);
		aceptar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Connection conexion = AccesoBaseDatos.conexionBaseDatos();
			String rutaInforme = System.getProperty("user.dir") + System.getProperty("file.separator");
			rutaInforme += "Comics.jasper";
			JasperReport informeVacio;
			
				informeVacio = (JasperReport) JRLoader.loadObjectFromFile(rutaInforme);

				JasperPrint informeConDatos = JasperFillManager.fillReport(informeVacio, null, conexion);
				JasperViewer visor = new JasperViewer(informeConDatos);
				
				visor.setVisible(true);
			} catch (JRException e1) {
				e1.printStackTrace();
			}
		}
		});

		JButton cancelar = new JButton("Atr�s");
		panel_1.add(cancelar);
		BotonAtras.irAtras(cancelar, panel);
	}

}
