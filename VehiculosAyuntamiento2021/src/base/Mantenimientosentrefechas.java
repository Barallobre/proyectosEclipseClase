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
 * Clase construida con windowbuilder que nos permite generar un informe que liste los mantenimientos que existan entre las fechas que introduzcamos
 * @author Cristian Barallobre
 * @version 06-03-2020
 * 
 */
public class Mantenimientosentrefechas extends JFrame {

	private JPanel contentPane;
	private JTextField dia;
	private JTextField mes;
	private JTextField ano;
	private JTextField diah;
	private JTextField mesh;
	private JTextField anoh;


	public Mantenimientosentrefechas() {
		setTitle("Buscar mantenimientos entre dos fechas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 136);
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
				rutaInforme += "Mantenimientosentrefechas.jasper";
				JasperReport informeVacio;
				
					informeVacio = (JasperReport) JRLoader.loadObjectFromFile(rutaInforme);
					Map<String, Object> parametros = new HashMap<String, Object>();
					String dia1=dia.getText();
					String mes1=mes.getText();
					String ano1=ano.getText();
					String dia2=diah.getText();
					String mes2=mesh.getText();
					String ano2=anoh.getText();
					String fechaDesde1 = ano1+"-"+mes1+"-"+dia1;
					String fechaHasta1 =  ano2+"-"+mes2+"-"+dia2;
					parametros.put("fechaDesde", fechaDesde1);
					parametros.put("fechaHasta", fechaHasta1);
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
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Fecha desde(d\u00EDa/mes/a\u00F1o)");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		dia = new JTextField();
		GridBagConstraints gbc_dia = new GridBagConstraints();
		gbc_dia.insets = new Insets(0, 0, 5, 5);
		gbc_dia.fill = GridBagConstraints.HORIZONTAL;
		gbc_dia.gridx = 3;
		gbc_dia.gridy = 0;
		panel_1.add(dia, gbc_dia);
		dia.setColumns(10);
		
		mes = new JTextField();
		GridBagConstraints gbc_mes = new GridBagConstraints();
		gbc_mes.insets = new Insets(0, 0, 5, 5);
		gbc_mes.fill = GridBagConstraints.HORIZONTAL;
		gbc_mes.gridx = 4;
		gbc_mes.gridy = 0;
		panel_1.add(mes, gbc_mes);
		mes.setColumns(10);
		
		ano = new JTextField();
		GridBagConstraints gbc_ano = new GridBagConstraints();
		gbc_ano.insets = new Insets(0, 0, 5, 0);
		gbc_ano.fill = GridBagConstraints.HORIZONTAL;
		gbc_ano.gridx = 5;
		gbc_ano.gridy = 0;
		panel_1.add(ano, gbc_ano);
		ano.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha hasta(d\u00EDa/mes/a\u00F1o)");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		diah = new JTextField();
		GridBagConstraints gbc_diah = new GridBagConstraints();
		gbc_diah.insets = new Insets(0, 0, 0, 5);
		gbc_diah.fill = GridBagConstraints.HORIZONTAL;
		gbc_diah.gridx = 3;
		gbc_diah.gridy = 1;
		panel_1.add(diah, gbc_diah);
		diah.setColumns(10);
		
		mesh = new JTextField();
		GridBagConstraints gbc_mesh = new GridBagConstraints();
		gbc_mesh.insets = new Insets(0, 0, 0, 5);
		gbc_mesh.fill = GridBagConstraints.HORIZONTAL;
		gbc_mesh.gridx = 4;
		gbc_mesh.gridy = 1;
		panel_1.add(mesh, gbc_mesh);
		mesh.setColumns(10);
		
		anoh = new JTextField();
		GridBagConstraints gbc_anoh = new GridBagConstraints();
		gbc_anoh.fill = GridBagConstraints.HORIZONTAL;
		gbc_anoh.gridx = 5;
		gbc_anoh.gridy = 1;
		panel_1.add(anoh, gbc_anoh);
		anoh.setColumns(10);
	}

}
