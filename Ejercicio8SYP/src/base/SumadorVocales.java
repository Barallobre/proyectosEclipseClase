package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumadorVocales {

	/* Método para saber cuantas veces aparece una letra en el texto */
	public static int leerLetras(String letra, String nombreFicheroEntrada) {

		int valor = 0;
		int contador = 0;
		char caracter = letra.charAt(0);
		try {
			FileReader fich = new FileReader(nombreFicheroEntrada);
			while ((valor = fich.read()) != -1) {
				if (valor == caracter) {
					contador++;
				}
			}
			fich.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contador;
	}

	public static void main(String[] args) {

		String nombreFicheroEntrada = args[0];
		String letra = args[1];
		int sumaVocales = leerLetras(letra, nombreFicheroEntrada);
		System.out.println(sumaVocales);
		System.out.flush();
	}
}
