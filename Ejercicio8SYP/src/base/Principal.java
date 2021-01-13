package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

	static final int NUM_PROCESOS = 5;
	static final String PREFIJO_FICHEROS = "fichero";

	/*
	 * Método para lanzar un proceso en el que sumaremos las vocales de un fichero
	 */
	public static void lanzarSumadorVocales(String nombreFicheroEntrada, String letra, String nombreFicheroResultado)
			throws IOException {
		String clase = "base.SumadorVocales";
		
		File directorioSumadorVocales = new File(
				"C:\\Users\\Usuario\\proyectosEclipseClase1\\Ejercicio8SYP\\bin");
		try {
			ProcessBuilder pb = new ProcessBuilder("java", clase, nombreFicheroEntrada, letra);
			pb.directory(directorioSumadorVocales);
			pb.redirectOutput(new File(nombreFicheroResultado));
			System.out.println(nombreFicheroEntrada + letra + nombreFicheroResultado);
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Método para recoger el entero de la primera línea de un fichero de texto */
	public static int getResultadoFichero(String nombreFichero) {
		int suma = 0;
		try {
			FileInputStream fichero = new FileInputStream(nombreFichero);
			InputStreamReader fir = new InputStreamReader(fichero);
			BufferedReader br = new BufferedReader(fir);
			String linea = br.readLine();
			suma = Integer.parseInt(linea);
			return suma;

		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir " + nombreFichero);
		} catch (IOException e) {
			System.out.println("No hay nada en " + nombreFichero);
		}
		return suma;
	}

	/* Método para pasar por los distintos ficheros que se vamos a sumar */
	public static int getSumaTotal(int numFicheros) {
		int sumaTotal = 0;
		for (int i = 0; i < NUM_PROCESOS; i++) {
			sumaTotal += getResultadoFichero(PREFIJO_FICHEROS + String.valueOf(i + 1));
		}
		return sumaTotal;
	}

	/*
	 * Método main donde pasamos como argumento el fichero que queremos analizar y
	 * determinamos el nº de procesos a lanzar y finalmente la suma total del contenido de los ficheros
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		String[] vocales = { "A", "E", "I", "O", "U" };
		String letra = null;
		String nombreFicheroResultado = null;
		String nombreFicheroEntrada = args[0];

		for (int i = 0; i < vocales.length; i++) {
			letra = vocales[i];
			nombreFicheroResultado = PREFIJO_FICHEROS + String.valueOf(i + 1);
			lanzarSumadorVocales(nombreFicheroEntrada, letra, nombreFicheroResultado);
		}
		Thread.sleep(5000);
		int sumaTotal = getSumaTotal(NUM_PROCESOS);
		System.out.println("La suma total es:" + sumaTotal);
	}
}
