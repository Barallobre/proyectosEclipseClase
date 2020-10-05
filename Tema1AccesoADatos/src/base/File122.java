package base;

import java.io.File;
import java.util.Scanner;

public class File122 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String[] Provincias = { "A Coruña", "Lugo", "Ourense", "Pontevedra" };

		System.out.println("Introduzca la ruta para crear las carpetas.");
		String ruta = sc.nextLine();
		for (int i = 0; i < Provincias.length; i++) {
			new File(ruta + "\\" + Provincias[i]).mkdir();
			for (int j = 1; j < 4; j++) {
				new File(ruta + "\\" + Provincias[i] + "\\" + "Trimestre" + j).mkdir();
			}
		}
	}
}
