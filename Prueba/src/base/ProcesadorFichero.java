package base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcesadorFichero {
	/**
	 * para obter os datos do fichero
	 * 
	 * @param nombreFichero
	 * @return
	 * @throws FileNotFoundException
	 */
	public static BufferedReader getBufferedReader(String nombreFichero) throws FileNotFoundException {
		FileReader lector;
		lector = new FileReader(nombreFichero);
		BufferedReader bufferedReader;
		bufferedReader = new BufferedReader(lector);
		return bufferedReader;
	}

	/**
	 * como proceso cada fichero, como o recorro
	 * 
	 * @param fichEntrada
	 * @param letra
	 * @param fichResultado
	 */
	public static int hacerRecuento(String fichEntrada, String letra) {
		int contador = 0;
		try {
			BufferedReader fichero = getBufferedReader("D:\\ProyectosEclipseSegundo\\proyectosEclipseClase\\Prueba\\"+fichEntrada);
			int caracter = fichero.read();
			while (caracter != -1) {
				
				if (caracter == letra.charAt(0) || caracter == letra.toUpperCase().charAt(0)) {
					contador += 1;
				}
				caracter = fichero.read();
			}
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contador;

	}

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String nombreFicheroEntrada = args[0];
		String letra = args[1];
		
		
		System.out.println(hacerRecuento(nombreFicheroEntrada, letra));

		System.out.flush();
		// Fin del main
	}
}
