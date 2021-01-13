package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumadorVocales {

	/* Método para saber cuantas veces aparece una letra en el texto */
	public static int leerLetras(String letra, String nombreFicheroEntrada) {
		int contador = 0;
		int valor;
		try {

			FileReader fich = new FileReader(
					"C:\\Users\\Usuario\\Desktop\\" + nombreFicheroEntrada);
			while ((valor = fich.read()) != -1) {

				if ((String.valueOf((char) valor).toUpperCase()).equals(letra)) {
					contador += 1;
				}
			}

			fich.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}
		return contador;
	}

	/*
	 * Método main por el que entran las argumentos y en el que invocamos el método
	 * que sumara las vocales
	 */
	public static void main(String[] args) {
		String nombreFicheroEntrada = args[0];
		String letra = (String) args[1];
		int sumaVocales = leerLetras(letra, nombreFicheroEntrada);
		System.out.println(sumaVocales);

		System.out.flush();
	}
}
