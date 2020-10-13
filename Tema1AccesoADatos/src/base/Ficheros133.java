/*
 * Crea un fichero en el escritorio formado por las cadenas de texto que en distintos momentos pueda
introducir el usuario, de manera que cada cadena se vaya añadiendo al final del fichero.
 * */
package base;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ficheros133 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			FileWriter fichero = new FileWriter("C:\\Users\\Usuario\\Desktop\\fichero.txt", true);
			System.out.println("Introduzca un texto en el fichero:");
			String textoIntroducido = sc.nextLine();
			fichero.write(textoIntroducido+"\n");
			fichero.close();
			System.out.println("Texto introducido...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
