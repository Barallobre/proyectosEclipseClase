package base;

import java.io.File;
import java.util.Scanner;

public class File124 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Introduzca la ruta.");
		String ruta = sc.nextLine();
		// C:\Users\Usuario\Desktop
		File fichero1 = new File(ruta);
		for (int i = 0; i < fichero1.list().length; i++) {

			File fichero2 = new File(ruta + "\\" + fichero1.list()[i]);
			
			if (fichero2.isDirectory()) {
				System.out.println(fichero1.list()[i]);
				
				for (int j = 0; j < fichero2.list().length; j++) {
					File fichero3 = new File(ruta + "\\" + fichero1.list()[i] + "\\" + fichero2.list()[j]);
					System.out.println("\t"+fichero2.list()[j]);
				}
			} else {
				System.out.println(fichero1.list()[i] + " " + (fichero2.length() / 1000) + "KBytes");
			}
		}

	}
}
