/*Lista el contenido, si es posible, de la carpeta correspondiente a la ruta 
 * que el usuario proponga indicando al lado de cada elemento si es un fichero 
 * o una carpeta*/
package base;

import java.io.File;
import java.util.Scanner;

public class File123 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean rutaNoValida = false;
		do{
			System.out.println("Introduzca una ruta.");
			String ruta = sc.nextLine();
			File fichero1 = new File(ruta);
			try {
				for (int i = 0; i < fichero1.list().length; i++) {
					File fichero2 = new File(ruta + "\\" + fichero1.list()[i]);
					
					if (fichero2.isDirectory()) {
						System.out.println(fichero1.list()[i] + " es un directorio");
					} else {
						System.out.println(fichero1.list()[i] + " es un archivo");
					}
				}
			} catch (NullPointerException e) {
				rutaNoValida = true;
				System.out.println("La ruta no es v�lida.");
			}
		}while(rutaNoValida);
	}

}
//Ruta utilizada de pruebas
//C:\Users\Usuario\Dropbox\proyectosEclipseDAM2\Tema1AccesoADatos\ejerciciosFile