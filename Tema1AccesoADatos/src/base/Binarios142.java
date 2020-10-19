package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Binarios142 {

	public static void main(String[] args) {
		File fichero = new File("C:\\Users\\Cristian\\Desktop\\datos.dat");
		DataOutputStream datos = null;
		try {

			// Establezco conexión con el fichero
			FileOutputStream conexion = new FileOutputStream(fichero);

			// y habilito la conexión para la transmisión de datos de tipo primitivo
			datos = new DataOutputStream(conexion);
			String nombres[] = { "Estela", "Fran", "Manuel", "Martín", "Geli" };
			int edades[] = { 20, 19, 21, 22, 101 };
			for (int i = 0; i < nombres.length; i++) {
				datos.writeUTF(nombres[i]); // Escribe un nombre en el fichero
				System.out.print(nombres[i]+" ");
				datos.writeInt(edades[i]); // Escribe una edad en el fichero
				System.out.print(edades[i]+" ");
			}
		} catch (IOException e) {
			e.getMessage();
		} finally {
			if (datos != null)
				try {
					datos.close(); // Se cierra la conexión si existe
				} catch (IOException e) {
					e.getMessage();
				}
		}
			leerFichero();	
	}
	public static void leerFichero() {
		File fichero = new File("C:\\Users\\Cristian\\Desktop\\datos.dat");
		DataInputStream datos = null;
		try {
			FileInputStream conexion = new FileInputStream(fichero);
			datos = new DataInputStream(conexion);
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
