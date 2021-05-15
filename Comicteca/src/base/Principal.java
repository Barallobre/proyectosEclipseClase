package base;

import javax.swing.UIManager;

/**
 * Clase principal desde la que iniciamos la ventana principal que actúa como menú para acceder a las distintas partes de la aplicación
 *@author Cristian Barallobre
 *@version 06-03-2021
 */

public class Principal {
	
	public static void main(String[] args) {
		try {
			  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch(Exception e) {
			  System.out.println("Error setting native LAF: " + e);
			}
		Barrademenu barramenu = new Barrademenu();
		barramenu.setVisible(true);
	}
}
