package base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ficheros136 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		File fichero1 = null;
		int contador = 0;
		String linea = "Érase una vez un alumno al que le gustaba mucho trabajar en la clase de Acceso a datos...";
		escribirFichero(fichero1, linea, contador);
	}

	public static void escribirFichero(File fichero1, String linea, int contador) {

		boolean ficheroIncorrecto = false;
		do {
			System.out.println("Introduzca el nombre del fichero.");
			String ruta = sc.nextLine();
			if (contador == 1) {
				fichero1.delete();
			}
			try {

				fichero1 = new File(ruta);

				BufferedWriter bf = new BufferedWriter(new FileWriter(fichero1));
				char[] lineaChar = linea.toCharArray();
				bf.write(lineaChar);
				bf.close();

				System.out.println("\nTexto escrito...");
			} catch (FileNotFoundException e) {
				System.out.println(e);

			} catch (IOException e) {
				System.out.println("El fichero no se encuentra disponible.");
				ficheroIncorrecto = true;

			}
		} while (ficheroIncorrecto);

		if (fichero1.exists()) {
			try {
				BufferedReader bfR = new BufferedReader(new FileReader(fichero1));

				linea = bfR.readLine();
				bfR.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println(e);
			}
			if (contador == 1) {
				System.exit(0);
			}
			contador++;
			escribirFichero(fichero1, linea, contador);
		}
	}

}
