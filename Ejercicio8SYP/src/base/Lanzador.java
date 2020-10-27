package base;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Lanzador {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String nombreFicheroEntrada = args[0];
		String letra = args[1];
		String nombreFicheroResultado = args[2];
		hacerRecuento(nombreFicheroEntrada, letra, nombreFicheroResultado);
		// Fin del main
	}
}
