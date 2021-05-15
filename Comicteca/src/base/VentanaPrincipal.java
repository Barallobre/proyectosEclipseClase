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
 * Clase que genera una ventana a partir de la cual accederemos a cada uno de
 * las funciones del programa mediante una barra de menús
 * 
 * @author Cristian Barallobre
 * @version 06-03-2020
 * 
 */
public class VentanaPrincipal extends JFrame {

	JPanel panel;
	JMenuItem altacomic, bajacomic, modificacioncomic, consultacomics;
	JMenuItem altacoleccion, bajacoleccion, modificacioncoleccion, consultacolecciones;
	JMenuItem altaeditorial, bajaeditorial, modificacioneditorial, consultaeditoriales;
	JMenuItem altaautor, bajaautor, modificacionautor, consultaautores;
	private JLabel lblNewLabel;
	private JMenuItem ayuda;
	private JMenu Leidos;
	private JMenuItem altadepartamentos_1;
	private JMenuItem bajadepartamentos_1;
	private JMenuItem modificaciondepartamentos_1;
	private JMenuItem consultadepartamentos_1;
	private JMenu Tipos;
	private JMenuItem altamantenimientos_1;
	private JMenuItem bajamantenimientos_1;
	private JMenuItem modificacionmantenimientos_1;
	private JMenuItem consultamantenimientos_1;

	public VentanaPrincipal() {
		setTitle("COMICTECA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 283);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
//------------------------------------------------------------------------------
		JMenu Comics = new JMenu("Comics");
		menuBar.add(Comics);

		altacomic = new JMenuItem("Alta");
		Comics.add(altacomic);

		bajacomic = new JMenuItem("Baja");
		Comics.add(bajacomic);

		modificacioncomic = new JMenuItem("Modificacion");
		Comics.add(modificacioncomic);

		consultacomics = new JMenuItem("Consulta");
		Comics.add(consultacomics);
//------------------------------------------------------------------------------		
		JMenu Autores = new JMenu("Autores");
		menuBar.add(Autores);

		altaautor = new JMenuItem("Alta");
		Autores.add(altaautor);

		bajaautor = new JMenuItem("Baja");
		Autores.add(bajaautor);

		modificacionautor = new JMenuItem("Modificacion");
		Autores.add(modificacionautor);

		consultaautores = new JMenuItem("Consulta");
		Autores.add(consultaautores);
//------------------------------------------------------------------------------
		JMenu Colecciones = new JMenu("Colecciones");
		menuBar.add(Colecciones);

		altacoleccion = new JMenuItem("Alta");
		Colecciones.add(altacoleccion);

		bajacoleccion = new JMenuItem("Baja");
		Colecciones.add(bajacoleccion);

		modificacioncoleccion = new JMenuItem("Modificacion");
		Colecciones.add(modificacioncoleccion);

		consultacolecciones = new JMenuItem("Consulta");
		Colecciones.add(consultacolecciones);
//------------------------------------------------------------------------------
		JMenu Editoriales = new JMenu("Editoriales");
		menuBar.add(Editoriales);

		altaeditorial = new JMenuItem("Alta");
		Editoriales.add(altaeditorial);

		bajaeditorial = new JMenuItem("Baja");
		Editoriales.add(bajaeditorial);

		modificacioneditorial = new JMenuItem("Modificacion");
		Editoriales.add(modificacioneditorial);

		consultaeditoriales = new JMenuItem("Consulta");
		Editoriales.add(consultaeditoriales);
//------------------------------------------------------------------------------
		Tipos = new JMenu("Tipos");
		menuBar.add(Tipos);

		altamantenimientos_1 = new JMenuItem("Alta");
		Tipos.add(altamantenimientos_1);

		bajamantenimientos_1 = new JMenuItem("Baja");
		Tipos.add(bajamantenimientos_1);

		modificacionmantenimientos_1 = new JMenuItem("Modificacion");
		Tipos.add(modificacionmantenimientos_1);

		consultamantenimientos_1 = new JMenuItem("Consulta");
		Tipos.add(consultamantenimientos_1);
//------------------------------------------------------------------------------
		Leidos = new JMenu("Leidos");
		menuBar.add(Leidos);

		altadepartamentos_1 = new JMenuItem("Alta");
		Leidos.add(altadepartamentos_1);

		bajadepartamentos_1 = new JMenuItem("Baja");
		Leidos.add(bajadepartamentos_1);

		modificaciondepartamentos_1 = new JMenuItem("Modificacion");
		Leidos.add(modificaciondepartamentos_1);

		consultadepartamentos_1 = new JMenuItem("Consulta");
		Leidos.add(consultadepartamentos_1);
//------------------------------------------------------------------------------
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
		lblNewLabel.setIcon(new ImageIcon("D:\\proyectosJavaDAM2\\Comicteca\\comics.jpg"));
		panel.add(lblNewLabel, BorderLayout.CENTER);

		altacomic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Altacomic frame = new Altacomic();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		bajacomic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Bajacomic frame = new Bajacomic();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		modificacioncomic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Modificacioncomic frame = new Modificacioncomic();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		consultacomics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Consultacomics frame = new Consultacomics();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
//------------------------------------------------------------------------------
		altaautor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Altaautor frame = new Altaautor();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		bajaautor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Bajaeditorial frame = new Bajaeditorial();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		modificacionautor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Modificacioncoleccion frame = new Modificacioncoleccion();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		consultaautores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Consultaautores frame = new Consultaautores();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
//------------------------------------------------------------------------------
		altaeditorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Altaeditorial frame = new Altaeditorial();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		bajaeditorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Bajacoleccion frame = new Bajacoleccion();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		modificacioneditorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Modificacioneditorial frame = new Modificacioneditorial();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		consultaeditoriales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Consultacolecciones frame = new Consultacolecciones();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
//------------------------------------------------------------------------------
		altacoleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Altacoleccion frame = new Altacoleccion();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		bajacoleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Bajaautor frame = new Bajaautor();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		modificacioncoleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Modificacionautor frame = new Modificacionautor();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		consultacolecciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Consultaeditoriales frame = new Consultaeditoriales();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
//------------------------------------------------------------------------------
	}
}
