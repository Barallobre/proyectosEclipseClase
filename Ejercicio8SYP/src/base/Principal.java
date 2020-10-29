package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Principal {

	static final int NUM_PROCESOS = 5;
	static final String PREFIJO_FICHEROS = "fichero";

	public static void lanzarSumadorVocales(String nombreFicheroEntrada, String letra, String nombreFicheroResultado)
			throws IOException {
		String clase = "base.SumadorVocales";
		File directorioSumadorVocales = new File("C:\\Users\\Usuario\\proyectosEclipseClase1\\Ejercicio8SYP\\bin");
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
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String[] vocales = { "A", "E", "I", "O", "U" };
		String letra = null;
		String nombreFicheroResultado = null;
		String nombreFicheroEntrada = "vocales.txt"; //+ args[0];

		for (int i = 0; i < vocales.length; i++) {
			letra = vocales[i];
			nombreFicheroResultado = PREFIJO_FICHEROS + String.valueOf(i+1);
			lanzarSumadorVocales(nombreFicheroEntrada, letra, nombreFicheroResultado);
		}
	}
}
