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
 * Clase construida con windowbuilder que nos permite generar un informe al introducir un departamento 
 * @author Cristian Barallobre
 * @version 06-03-2020
 * 
 */
public class Buscarpordepartamento extends JFrame {

	private JPanel contentPane;
	private JTextField nombreDepartamento;


	public Buscarpordepartamento() {
		setTitle("Buscar veh\u00EDculos por departamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 105);
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
			rutaInforme += "Buscarpordepartamento.jasper";
			JasperReport informeVacio;
			
				informeVacio = (JasperReport) JRLoader.loadObjectFromFile(rutaInforme);
				Map<String, Object> parametros = new HashMap<String, Object>();
				String departamento = nombreDepartamento.getText();
				parametros.put("Departamento", departamento);
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
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre departamento");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		nombreDepartamento = new JTextField();
		GridBagConstraints gbc_nombreDepartamento = new GridBagConstraints();
		gbc_nombreDepartamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreDepartamento.gridx = 5;
		gbc_nombreDepartamento.gridy = 0;
		panel_1.add(nombreDepartamento, gbc_nombreDepartamento);
		nombreDepartamento.setColumns(10);
	}

}
