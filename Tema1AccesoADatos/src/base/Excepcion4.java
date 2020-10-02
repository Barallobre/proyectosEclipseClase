package base;

import java.io.File;
import java.io.IOException;

public class Excepcion4 {

	public static void main(String[] args) {

		try {
			crearFichero();
		} catch (IOException e) {
			System.out.println("Error al crear el fichero.");
			System.out.println(e.toString()); // as� nos ense�a el tipo de excepci�n
		}

	}

	private static void crearFichero() throws IOException {
		File fichero = new File("C:\\Users\\Usuario\\Escritorio\\ejemplo.txt");
		fichero.createNewFile();
		
	}
	
}
