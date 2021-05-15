package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
/**
 * Clase que genera una ventana a partir de la cual accederemos a cada uno de las funciones del programa mediante una barra de menús
 * @author Cristian Barallobre
 * @version 06-03-2020
 * 
 */
public class Barrademenu extends JFrame {

	JPanel panel;
	JMenuItem altamantenimientos,bajamantenimientos,modificacionmantenimientos,consultamantenimientos,mantenimientosfechas,mantenimientopormatricula;
	JMenuItem altavehiculos, bajavehiculos,modificacionvehiculos,consultavehiculos,buscarpordepartamento,consultapordepartamento;
	JMenuItem altatiposmantenimiento, bajatiposmantenimiento, modificaciontiposmantenimiento,consultatiposmantenimiento;
	JMenuItem altadepartamentos, bajadepartamentos, modificaciondepartamentos,consultadepartamentos;
	private JLabel lblNewLabel;
	private JMenuItem ayuda;
	private JMenu Editoriales_1;
	private JMenuItem altadepartamentos_1;
	private JMenuItem bajadepartamentos_1;
	private JMenuItem modificaciondepartamentos_1;
	private JMenuItem consultadepartamentos_1;
	private JMenu Comics_1;
	private JMenuItem altamantenimientos_1;
	private JMenuItem bajamantenimientos_1;
	private JMenuItem modificacionmantenimientos_1;
	private JMenuItem consultamantenimientos_1;
	private JMenuItem mantenimientosfechas_1;
	private JMenuItem mantenimientopormatricula_1;
	
	public Barrademenu() {
		setTitle("COMICTECA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu Comics = new JMenu("Comics");
		menuBar.add(Comics);
		
		altamantenimientos = new JMenuItem("Alta");
		Comics.add(altamantenimientos);
		
		bajamantenimientos = new JMenuItem("Baja");
		Comics.add(bajamantenimientos);
		
		modificacionmantenimientos = new JMenuItem("Modificacion");
		Comics.add(modificacionmantenimientos);
		
		consultamantenimientos = new JMenuItem("Consulta");
		Comics.add(consultamantenimientos);
		
		mantenimientosfechas = new JMenuItem("Mantenimientos entre dos fechas");
		Comics.add(mantenimientosfechas);
		
		mantenimientopormatricula = new JMenuItem("Mantenimientos por matr\u00EDcula");
		Comics.add(mantenimientopormatricula);
		
		JMenu Autores = new JMenu("Autores");
		menuBar.add(Autores);
		
		altavehiculos = new JMenuItem("Alta");
		Autores.add(altavehiculos);
		
		bajavehiculos = new JMenuItem("Baja");
		Autores.add(bajavehiculos);
		
		modificacionvehiculos = new JMenuItem("Modificacion");
		Autores.add(modificacionvehiculos);
		
		consultavehiculos = new JMenuItem("Consulta");
		Autores.add(consultavehiculos);
		
		buscarpordepartamento = new JMenuItem("Buscar por departamento");
		Autores.add(buscarpordepartamento);
		
		consultapordepartamento = new JMenuItem("Consulta por departamento");
		Autores.add(consultapordepartamento);
		
		JMenu Colecciones = new JMenu("Colecciones");
		menuBar.add(Colecciones);
		
		altatiposmantenimiento = new JMenuItem("Alta");
		Colecciones.add(altatiposmantenimiento);
		
		bajatiposmantenimiento = new JMenuItem("Baja");
		Colecciones.add(bajatiposmantenimiento);
		
		modificaciontiposmantenimiento = new JMenuItem("Modificacion");
		Colecciones.add(modificaciontiposmantenimiento);
		
		consultatiposmantenimiento = new JMenuItem("Consulta");
		Colecciones.add(consultatiposmantenimiento);
		
		JMenu Editoriales = new JMenu("Editoriales");
		menuBar.add(Editoriales);
		
		altadepartamentos = new JMenuItem("Alta");
		Editoriales.add(altadepartamentos);
		
		bajadepartamentos = new JMenuItem("Baja");
		Editoriales.add(bajadepartamentos);
		
		modificaciondepartamentos = new JMenuItem("Modificacion");
		Editoriales.add(modificaciondepartamentos);
		
		consultadepartamentos = new JMenuItem("Consulta");
		Editoriales.add(consultadepartamentos);
		
		Editoriales_1 = new JMenu("Editoriales");
		menuBar.add(Editoriales_1);
		
		altadepartamentos_1 = new JMenuItem("Alta");
		Editoriales_1.add(altadepartamentos_1);
		
		bajadepartamentos_1 = new JMenuItem("Baja");
		Editoriales_1.add(bajadepartamentos_1);
		
		modificaciondepartamentos_1 = new JMenuItem("Modificacion");
		Editoriales_1.add(modificaciondepartamentos_1);
		
		consultadepartamentos_1 = new JMenuItem("Consulta");
		Editoriales_1.add(consultadepartamentos_1);
		
		Comics_1 = new JMenu("Comics");
		menuBar.add(Comics_1);
		
		altamantenimientos_1 = new JMenuItem("Alta");
		Comics_1.add(altamantenimientos_1);
		
		bajamantenimientos_1 = new JMenuItem("Baja");
		Comics_1.add(bajamantenimientos_1);
		
		modificacionmantenimientos_1 = new JMenuItem("Modificacion");
		Comics_1.add(modificacionmantenimientos_1);
		
		consultamantenimientos_1 = new JMenuItem("Consulta");
		Comics_1.add(consultamantenimientos_1);
		
		mantenimientosfechas_1 = new JMenuItem("Mantenimientos entre dos fechas");
		Comics_1.add(mantenimientosfechas_1);
		
		mantenimientopormatricula_1 = new JMenuItem("Mantenimientos por matr\u00EDcula");
		Comics_1.add(mantenimientopormatricula_1);
		
		ayuda = new JMenuItem("Ayuda");
		menuBar.add(ayuda);
		ayuda.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (!Desktop.isDesktopSupported()) {
				System.out.println("La clase Desktop no es soportada");
			} else {
				Desktop escritorio = Desktop.getDesktop();
				try {
					File archivo = new File("ayuda.chm");
					if (escritorio.isSupported(Desktop.Action.valueOf("OPEN")))
						escritorio.open(archivo);
					else
						System.out.println("La función OPEN no es soportada");
				} catch (Exception e1) {
					e1.getMessage();
				}
			}
		}
	});
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		setContentPane(panel);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("ayuntamiento_de_a_coruna_001.jpg"));
		panel.add(lblNewLabel, BorderLayout.CENTER);
	

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
				Mantenimientosentrefechas frame = new Mantenimientosentrefechas();
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
				Mantenimientospormatricula frame = new Mantenimientospormatricula();
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
	consultavehiculos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Consultavehiculos frame = new Consultavehiculos();
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
				Consultapordepartamento frame = new Consultapordepartamento();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	buscarpordepartamento.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Buscarpordepartamento frame = new Buscarpordepartamento();
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
				Altatiposmantenimiento frame = new Altatiposmantenimiento();
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
				Bajatiposmantenimiento frame = new Bajatiposmantenimiento();
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
				Modificaciontiposmantenimiento frame = new Modificaciontiposmantenimiento();
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
				Consultatiposmantenimiento frame = new Consultatiposmantenimiento();
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
				Altadepartamentos frame = new Altadepartamentos();
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
				Bajadepartamentos frame = new Bajadepartamentos();
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
				Modificaciondepartamentos frame = new Modificaciondepartamentos();
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
				Consultadepartamentos frame = new Consultadepartamentos();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	});
	}
}
