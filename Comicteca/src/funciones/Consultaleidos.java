package funciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
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

import javax.swing.JButton;
import javax.swing.JLabel;
/**
 * Clase construida mediante window builder que nos permite generar un informe donde vemos los comics que hemos leído
 * @author Cristian Barallobre
 * @version 20-05-2021
 * 
 */
public class Consultaleidos extends JFrame {

	private JPanel contentPane;


	public Consultaleidos() {
		setTitle("Consulta de los comics leídos.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 105);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Generar informe de los comics leídos.");
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
			rutaInforme += "Leidos.jasper";
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
		JButton cancelar = new JButton("Atrás");
		panel_1.add(cancelar);
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
	}

}
