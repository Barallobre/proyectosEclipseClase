package base;


/**
 * Clase principal desde la que iniciamos la ventana principal que actúa como menú para acceder a las distintas partes de la aplicación
 *@author Cristian Barallobre
 *@version 06-03-2021
 */

public class Principal {

	public static void main(String[] args) {
		Barrademenu barramenu = new Barrademenu();
		barramenu.setVisible(true);
	}
}
