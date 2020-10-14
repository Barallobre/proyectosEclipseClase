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
<<<<<<< HEAD
			
			FileWriter fichero = new FileWriter("C:\\Users\\Cristian\\Desktop\\fichero.txt",true);
			System.out.println("Texto a introducir:");
			String textoIntroducido = sc.nextLine();
			fichero.write(textoIntroducido+"\n");
			fichero.close();
			System.out.println("Escritura terminada...");
=======
			FileWriter fichero = new FileWriter("C:\\Users\\Usuario\\Desktop\\fichero.txt", true);
			System.out.println("Introduzca un texto en el fichero:");
			String textoIntroducido = sc.nextLine();
			fichero.write(textoIntroducido+"\n");
			fichero.close();
			System.out.println("Texto introducido...");
>>>>>>> f6f5de10411695a1c06a46d54e1033441c3a2d08
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
