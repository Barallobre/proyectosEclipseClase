package base;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Cristian Barallobre
 * @version 06-03-2020
 * Clase construida con windowbuilder que nos permite generar un informe de los mantenimientos al introducir una matrícula en concreto
 */
public class Mantenimientospormatricula extends JFrame {

	private JPanel contentPane;
	private JTextField matricula;


	public Mantenimientospormatricula() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 112);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Matr\u00EDcula");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		matricula = new JTextField();
		GridBagConstraints gbc_matricula = new GridBagConstraints();
		gbc_matricula.fill = GridBagConstraints.HORIZONTAL;
		gbc_matricula.gridx = 5;
		gbc_matricula.gridy = 0;
		panel.add(matricula, gbc_matricula);
		matricula.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton aceptar = new JButton("Aceptar");
		panel_1.add(aceptar);
		aceptar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sakila?serverTimezone=UTC",
					"demo", "password");
			String rutaInforme = System.getProperty("user.dir") + System.getProperty("file.separator");
			rutaInforme += "Mantenimientospormatricula.jasper";
			JasperReport informeVacio;
			
				informeVacio = (JasperReport) JRLoader.loadObjectFromFile(rutaInforme);
				Map<String, Object> parametros = new HashMap<String, Object>();
				String matricula1 = matricula.getText();
				parametros.put("Matricula", matricula1);
				JasperPrint informeConDatos = JasperFillManager.fillReport(informeVacio, parametros, conexion);
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
		panel_1.add(cancelar);
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
	}

}
