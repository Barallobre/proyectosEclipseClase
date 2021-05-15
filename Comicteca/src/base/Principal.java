package base;

import java.awt.EventQueue;

import javax.swing.UIManager;

/**
 * Clase principal desde la que iniciamos la ventana principal que act�a como
 * men� para acceder a las distintas partes de la aplicaci�n
 * 
 * @author Cristian Barallobre
 * @version 06-03-2021
 */

public class Principal {
	
	public static void main(String[] args) {
		try {
			  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch(Exception e) {
			  System.out.println("Error setting native LAF: " + e);
			}
		VentanaPrincipal barramenu = new VentanaPrincipal();
		barramenu.setVisible(true);
	}
}
