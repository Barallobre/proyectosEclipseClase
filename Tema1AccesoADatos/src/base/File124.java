/*
 * Lista el contenido, si es posible, de la carpeta y subcarpetas del primer nivel correspondientes a la
ruta que el usuario proponga.
Tendrá un 0,2 más sobre la nota de la primera evaluación de Acceso a Datos quien, además, liste
el contenido de todas las subcarpetas de todos los niveles y añada, al lado de cada fichero (no
de las carpetas), su tamaño en KBytes. El contenido de cada subcarpeta debe aparecer tabulado
con respecto al contenido de la carpeta contenedora.
 * */
package base;

import java.io.File;
import java.util.Scanner;

public class File124 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Introduzca la ruta.");

		accederArchivo(sc.nextLine(), "");
	}

	public static void accederArchivo(String ruta, String tabulador) {
		File archivo = new File(ruta);

		if (archivo.isDirectory()) {
			System.out.println(tabulador + "(D)" + archivo.getName());
			tabulador += "\t";
			for (int i = 0; i < archivo.list().length; i++) {
				String rutaInterna = ruta + "\\" + archivo.list()[i];
				accederArchivo(rutaInterna, tabulador);
			}
		} else {
			System.out.println(tabulador + archivo.getName() + "  (" + archivo.length() / 1000 + " Kbytes)");
		}
	}
}
