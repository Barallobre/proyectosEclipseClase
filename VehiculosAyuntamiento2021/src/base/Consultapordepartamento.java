package base;

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

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JButton;
import javax.swing.JLabel;
/**
 *  Clase creada en window builder que nos permite listar en un informe los vehÝculos que hay en cada departamento
 * @author Cristian Barallobre
 * @version 06-03-2020
 *
 */
public class Consultapordepartamento extends JFrame {

	private JPanel contentPane;


	public Consultapordepartamento() {
		setTitle("Consulta de veh\u00EDculos por departamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 111);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton aceptar = new JButton("Aceptar");
		panel.add(aceptar);
		aceptar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sakila?serverTimezone=UTC",
					"demo", "password");
			String rutaInforme = System.getProperty("user.dir") + System.getProperty("file.separator");
			rutaInforme += "Vehiculospordepartamento.jasper";
			JasperReport informeVacio;
			
				informeVacio = (JasperReport) JRLoader.loadObjectFromFile(rutaInforme);

				JasperPrint informeConDatos = JasperFillManager.fillReport(informeVacio, null, conexion);
				JasperViewer visor = new JasperViewer(informeConDatos);
				
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
		});
		JButton cancelar = new JButton("Cancelar");
		panel.add(cancelar);
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Barrademenu frame = new Barrademenu();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Generar informe de vehiculos por departamento.");
		panel_1.add(lblNewLabel);
	}

}
