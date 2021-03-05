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
import javax.swing.JTextPane;
import java.awt.Font;

public class Barrademenu extends JFrame {

	JPanel panel;
	JMenuItem altamantenimientos,bajamantenimientos,modificacionmantenimientos,consultamantenimientos,mantenimientosfechas,mantenimientopormatricula;
	JMenuItem altavehiculos, bajavehiculos,modificacionvehiculos,consultavehiculos,consultatodosvehiculos,consultapordepartamento;
	JMenuItem altatiposmantenimiento, bajatiposmantenimiento, modificaciontiposmantenimiento,consultatiposmantenimiento;
	JMenuItem altadepartamentos, bajadepartamentos, modificaciondepartamentos,consultadepartamentos;
	
	public Barrademenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mantenimientos = new JMenu("Mantenimientos");
		menuBar.add(mantenimientos);
		
		altamantenimientos = new JMenuItem("Alta");
		mantenimientos.add(altamantenimientos);
		
		bajamantenimientos = new JMenuItem("Baja");
		mantenimientos.add(bajamantenimientos);
		
		modificacionmantenimientos = new JMenuItem("Modificacion");
		mantenimientos.add(modificacionmantenimientos);
		
		consultamantenimientos = new JMenuItem("Consulta");
		mantenimientos.add(consultamantenimientos);
		
		mantenimientosfechas = new JMenuItem("Mantenimientos entre dos fechas");
		mantenimientos.add(mantenimientosfechas);
		
		mantenimientopormatricula = new JMenuItem("Mantenimientos por matr\u00EDcula");
		mantenimientos.add(mantenimientopormatricula);
		
		JMenu vehiculos = new JMenu("Veh\u00EDculos");
		menuBar.add(vehiculos);
		
		altavehiculos = new JMenuItem("Alta");
		vehiculos.add(altavehiculos);
		
		bajavehiculos = new JMenuItem("Baja");
		vehiculos.add(bajavehiculos);
		
		modificacionvehiculos = new JMenuItem("Modificacion");
		vehiculos.add(modificacionvehiculos);
		
		consultavehiculos = new JMenuItem("Consulta");
		vehiculos.add(consultavehiculos);
		
		consultatodosvehiculos = new JMenuItem("Consultar todos los veh\u00EDculos");
		vehiculos.add(consultatodosvehiculos);
		
		consultapordepartamento = new JMenuItem("Consulta por departamento");
		vehiculos.add(consultapordepartamento);
		
		JMenu tiposmantenimiento = new JMenu("Tipos Mantenimiento");
		menuBar.add(tiposmantenimiento);
		
		altatiposmantenimiento = new JMenuItem("Alta");
		tiposmantenimiento.add(altatiposmantenimiento);
		
		bajatiposmantenimiento = new JMenuItem("Baja");
		tiposmantenimiento.add(bajatiposmantenimiento);
		
		modificaciontiposmantenimiento = new JMenuItem("Modificacion");
		tiposmantenimiento.add(modificaciontiposmantenimiento);
		
		consultatiposmantenimiento = new JMenuItem("Consulta");
		tiposmantenimiento.add(consultatiposmantenimiento);
		
		JMenu departamentos = new JMenu("Departamentos");
		menuBar.add(departamentos);
		
		altadepartamentos = new JMenuItem("Alta");
		departamentos.add(altadepartamentos);
		
		bajadepartamentos = new JMenuItem("Baja");
		departamentos.add(bajadepartamentos);
		
		modificaciondepartamentos = new JMenuItem("Modificacion");
		departamentos.add(modificaciondepartamentos);
		
		consultadepartamentos = new JMenuItem("Consulta");
		departamentos.add(consultadepartamentos);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		setContentPane(panel);
		
		JTextPane txtpnVehiculosAyuntamiento = new JTextPane();
		txtpnVehiculosAyuntamiento.setFont(new Font("Tahoma", Font.BOLD, 35));
		txtpnVehiculosAyuntamiento.setText("Veh\u00EDculos Ayuntamiento 2021\r\n");
		panel.add(txtpnVehiculosAyuntamiento, BorderLayout.CENTER);
	

	altamantenimientos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Altamantenimientos frame = new Altamantenimientos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	bajamantenimientos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Bajamantenimientos frame = new Bajamantenimientos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	modificacionmantenimientos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Modificacionmantenimientos frame = new Modificacionmantenimientos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	consultamantenimientos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Consultamantenimientos frame = new Consultamantenimientos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	mantenimientosfechas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Altamantenimientos frame = new Altamantenimientos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	mantenimientopormatricula.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Altavehiculos frame = new Altavehiculos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	altavehiculos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Altavehiculos frame = new Altavehiculos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	bajavehiculos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Bajavehiculos frame = new Bajavehiculos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	modificacionvehiculos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Modificacionvehiculos frame = new Modificacionvehiculos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	consultatodosvehiculos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Altavehiculos frame = new Altavehiculos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	consultatodosvehiculos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Altavehiculos frame = new Altavehiculos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	consultapordepartamento.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Altavehiculos frame = new Altavehiculos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	altatiposmantenimiento.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Altavehiculos frame = new Altavehiculos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	bajatiposmantenimiento.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Altavehiculos frame = new Altavehiculos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	modificaciontiposmantenimiento.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Altavehiculos frame = new Altavehiculos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	consultatiposmantenimiento.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Altavehiculos frame = new Altavehiculos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	altadepartamentos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Altavehiculos frame = new Altavehiculos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	bajadepartamentos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Altavehiculos frame = new Altavehiculos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	modificaciondepartamentos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Altavehiculos frame = new Altavehiculos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	consultadepartamentos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Altavehiculos frame = new Altavehiculos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	}
}
