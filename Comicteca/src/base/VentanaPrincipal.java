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

import funciones.Agregaraleidos;
import funciones.Altaautor;
import funciones.Altacoleccion;
import funciones.Altacomic;
import funciones.Altaeditorial;
import funciones.Altasubtipos;
import funciones.Altatipos;
import funciones.Bajaautor;
import funciones.Bajacomic;
import funciones.Bajaeditorial;
import funciones.Bajasubtipos;
import funciones.Bajatipos;
import funciones.Consultacomics;
import funciones.Consultaleidos;
import funciones.Consultanoleidos;
import funciones.Modificacioncomic;

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
 * @version 19-05-2021
 * 
 */
public class VentanaPrincipal extends JFrame {

	JPanel panel;
	JMenuItem altacomic, bajacomic, modificacioncomic, consultacomics;
	JMenuItem altacoleccion, bajacoleccion;
	JMenuItem altaeditorial, bajaeditorial;
	JMenuItem altaautor, bajaautor;
	JMenuItem consultaleidos;
	JMenuItem altatipos;
	JMenuItem bajatipos;
	JMenuItem altasubtipos;
	JMenuItem bajasubtipos;

	private JLabel lblNewLabel;
	private JMenuItem ayuda;
	private JMenu Leidos;
	private JMenuItem consultanoleidos_;
	private JMenuItem consultaleidos_;
	private JMenu Tipos;
	private JMenuItem agregaraleidos;
	private JMenu subtipos;

	public VentanaPrincipal() {
		setTitle("COMICTECA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 286);

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
//------------------------------------------------------------------------------
		JMenu Colecciones = new JMenu("Colecciones");
		menuBar.add(Colecciones);

		altacoleccion = new JMenuItem("Alta");
		Colecciones.add(altacoleccion);

		bajacoleccion = new JMenuItem("Baja");
		Colecciones.add(bajacoleccion);
//------------------------------------------------------------------------------
		JMenu Editoriales = new JMenu("Editoriales");
		menuBar.add(Editoriales);

		altaeditorial = new JMenuItem("Alta");
		Editoriales.add(altaeditorial);

		bajaeditorial = new JMenuItem("Baja");
		Editoriales.add(bajaeditorial);
//------------------------------------------------------------------------------
		Tipos = new JMenu("Tipos");
		menuBar.add(Tipos);

		altatipos = new JMenuItem("Alta");
		Tipos.add(altatipos);

		bajatipos = new JMenuItem("Baja");
		Tipos.add(bajatipos);
//------------------------------------------------------------------------------	
		subtipos = new JMenu("Subtipos");
		menuBar.add(subtipos);

		altasubtipos = new JMenuItem("Alta");
		subtipos.add(altasubtipos);

		bajasubtipos = new JMenuItem("Baja");
		subtipos.add(bajasubtipos);
//------------------------------------------------------------------------------
		Leidos = new JMenu("Leidos");
		menuBar.add(Leidos);

		agregaraleidos = new JMenuItem("Alta");
		Leidos.add(agregaraleidos);

		consultaleidos_ = new JMenuItem("Le\u00EDdos");
		Leidos.add(consultaleidos_);

		consultanoleidos_ = new JMenuItem("No Le\u00EDdos");
		Leidos.add(consultanoleidos_);
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
					Bajaautor frame = new Bajaautor();
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
					Bajaeditorial frame = new Bajaeditorial();
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
// ------------------------------------------------------------------------------
		altatipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Altatipos frame = new Altatipos();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		bajatipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Bajatipos frame = new Bajatipos();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
// ------------------------------------------------------------------------------
		altasubtipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Altasubtipos frame = new Altasubtipos();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		bajasubtipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Bajasubtipos frame = new Bajasubtipos();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
//------------------------------------------------------------------------------
		consultaleidos_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Consultaleidos frame = new Consultaleidos();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		consultanoleidos_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Consultanoleidos frame = new Consultanoleidos();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		agregaraleidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Agregaraleidos frame = new Agregaraleidos();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
	}
}
