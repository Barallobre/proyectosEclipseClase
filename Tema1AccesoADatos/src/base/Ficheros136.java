package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ficheros136 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean ficheroIncorrecto = false;
		do {
			System.out.println("Introduzca la ruta");
			String ruta = sc.nextLine();
			try {

				File fichero1 = new File(ruta);

				BufferedReader bf = new BufferedReader(new FileReader(fichero1));
				String linea;
				while ((linea = bf.readLine()) != null) {
					System.out.println(linea);

				}
				bf.close();
				System.out.println("\nFin de fichero...");
			} catch (FileNotFoundException e) {
				System.out.println(e);

			} catch (IOException e) {
				System.out.println("El fichero no se encuentra disponible.");
				ficheroIncorrecto = true;

			}
		} while (ficheroIncorrecto);

	}
}