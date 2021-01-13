package base;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Principal {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String ComunidadAutonoma;
		int numProvincia;
		String Provincia;
		String Poblacion;
		double Densidad;
		int Superficie;

		System.out.println("Introduzca Comunidad Autonoma: ");
		ComunidadAutonoma = sc.next();
		System.out.println("Introduzca Número de Provincia: ");
		numProvincia = sc.nextInt();
		System.out.println("Introduzca Provincia: ");
		Provincia = sc.next();
		System.out.println("Introduzca Población: ");
		Poblacion = sc.next();
		System.out.println("Introduzca Densidad: ");
		Densidad = sc.nextDouble();
		System.out.println("Introduzca Superficie: ");
		Superficie = sc.nextInt();

		Provincia provincia = new Provincia(ComunidadAutonoma, numProvincia, Provincia, Poblacion, Densidad,
				Superficie);
     //dentro de un try catch grabamos el objeto de provincia dentre de un fichero llamado Provincia.dat
		try {
			ObjectOutputStream os = new ObjectOutputStream(
					new FileOutputStream("C:\\Users\\Usuario\\Desktop\\BarallobreRuaCristian\\Provincia.dat"));
			os.writeObject(provincia);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String ruta = "C:\\Users\\Usuario\\Desktop\\BarallobreRuaCristian\\Provincia.dat";
		ObjectInputStream is;
		// dentro de un try catch leemos el objeto de provincia que se encuentra dentro
		// de un fichero llamado Provincia.dat
		try {
			is = new ObjectInputStream(new FileInputStream(ruta));
			try {
				while (true) {

					Provincia provincia1 = (Provincia) is.readObject();
					System.out.println(provincia1.getDatos());

				}
			} catch (EOFException e) {
			}
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
