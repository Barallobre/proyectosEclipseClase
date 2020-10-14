/*
 * Crea un fichero en el escritorio formado por las cadenas de texto que en distintos momentos pueda
introducir el usuario, de manera que cada cadena se vaya a�adiendo al final del fichero.
 * */
package base;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ficheros133 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			
			FileWriter fichero = new FileWriter("C:\\Users\\Cristian\\Desktop\\fichero.txt",true);
			System.out.println("Texto a introducir:");
			String textoIntroducido = sc.nextLine();
			fichero.write(textoIntroducido+"\n");
			fichero.close();
			System.out.println("Escritura terminada...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
