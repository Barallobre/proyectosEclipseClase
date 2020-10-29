package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Principal {

	static final int NUM_PROCESOS = 5;
	static final String PREFIJO_FICHEROS = "fichero";

	public static void lanzarSumadorVocales(String nombreFicheroEntrada, String letra, String nombreFicheroResultado)
			throws IOException {
		String comando = "base.SumadorVocales";
		File directorioSumadorVocales = new File("C:\\Users\\Usuario\\proyectosEclipseClase1\\Ejercicio8SYP\\bin");
		File fichResultado = new File(nombreFicheroResultado);

		try {
			ProcessBuilder pb = new ProcessBuilder("java", comando, nombreFicheroEntrada, letra);
			pb.directory(directorioSumadorVocales);
			pb.redirectOutput(fichResultado);
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String[] vocales = { "A", "E", "I", "O", "U" };
		String letra = null;
		String nombreFicheroResultado = null;
		String nombreFicheroEntrada = "C:\\Users\\Usuario\\proyectosEclipseClase1\\Ejercicio8SYP\\" + args[0];
		for (int i = 0; i < vocales.length; i++) {
			letra = vocales[i];
			nombreFicheroResultado = PREFIJO_FICHEROS + String.valueOf(i);
		}

		lanzarSumadorVocales(nombreFicheroEntrada, letra, nombreFicheroResultado);
		// Fin del main
	}
}
