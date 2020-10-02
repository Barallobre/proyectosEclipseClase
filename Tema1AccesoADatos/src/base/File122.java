package base;

import java.io.File;
import java.util.Scanner;

public class File122 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String[] Provincias = { "A Coruña", "Lugo", "Ourense", "Pontevedra" };
		String[] Trimestres = { "Trimestre1", "Trimestre2", "Trimestre3", "Trimestre4" };

		System.out.println("Introduzca la ruta para crear las carpetas.");
		String ruta = sc.nextLine();
		for (int i = 0; i < Provincias.length; i++) {
			new File(ruta + "\\" + Provincias[i]).mkdir();
			for (int j = 0; j < Trimestres.length; j++) {
				new File(ruta + "\\" + Provincias[i] + "\\" + Trimestres[j]).mkdir();
			}
		}
	}
}
