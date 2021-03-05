package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Barrademenu extends JFrame {

	JPanel panel;


	public Barrademenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mantenimientos = new JMenu("Mantenimientos");
		menuBar.add(mantenimientos);
		
		JMenuItem altamantenimientos = new JMenuItem("Alta");
		mantenimientos.add(altamantenimientos);
		
		JMenuItem bajamantenimientos = new JMenuItem("Baja");
		mantenimientos.add(bajamantenimientos);
		
		JMenuItem modificacionmantenimientos = new JMenuItem("Modificacion");
		mantenimientos.add(modificacionmantenimientos);
		
		JMenuItem consultamantenimientos = new JMenuItem("Consulta");
		mantenimientos.add(consultamantenimientos);
		
		JMenu vehiculos = new JMenu("Veh\u00EDculos");
		menuBar.add(vehiculos);
		
		JMenuItem altavehiculos = new JMenuItem("Alta");
		vehiculos.add(altavehiculos);
		
		JMenuItem bajavehiculos = new JMenuItem("Baja");
		vehiculos.add(bajavehiculos);
		
		JMenuItem modificacionvehiculos = new JMenuItem("Modificacion");
		vehiculos.add(modificacionvehiculos);
		
		JMenuItem consultavehiculos = new JMenuItem("Consulta");
		vehiculos.add(consultavehiculos);
		
		JMenu tiposmantenimiento = new JMenu("Tipos Mantenimiento");
		menuBar.add(tiposmantenimiento);
		
		JMenuItem altatiposmantenimiento = new JMenuItem("Alta");
		tiposmantenimiento.add(altatiposmantenimiento);
		
		JMenuItem bajatiposmantenimiento = new JMenuItem("Baja");
		tiposmantenimiento.add(bajatiposmantenimiento);
		
		JMenuItem modificaciontiposmantenimiento = new JMenuItem("Modificacion");
		tiposmantenimiento.add(modificaciontiposmantenimiento);
		
		JMenuItem consultatiposmantenimiento = new JMenuItem("Consulta");
		tiposmantenimiento.add(consultatiposmantenimiento);
		
		JMenu departamentos = new JMenu("Departamentos");
		menuBar.add(departamentos);
		
		JMenuItem altadepartamentos = new JMenuItem("Alta");
		departamentos.add(altadepartamentos);
		
		JMenuItem bajadepartamentos = new JMenuItem("Baja");
		departamentos.add(bajadepartamentos);
		
		JMenuItem modificaciondepartamentos = new JMenuItem("Modificacion");
		departamentos.add(modificaciondepartamentos);
		
		JMenuItem consultadepartamentos = new JMenuItem("Consulta");
		departamentos.add(consultadepartamentos);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		setContentPane(panel);
	}

	public void asignarEscuchador(Escuchador e) {
		verde.addActionListener(e);

	}
//	ActionListener fondoListener = new ActionListener() {
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == verde) {
//			panel.setBackground(Color.GREEN);
//		}
//		if (e.getSource() == rojo) {
//			panel.setBackground(Color.RED);
//		}
//	}
//};
//verde.addActionListener(fondoListener);
}
