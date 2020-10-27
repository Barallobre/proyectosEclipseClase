package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcesadorFichero {

	public static void main(String[] args) {

	}
	public static ArrayList<String> getLineasFichero(String nombreFichero) throws IOException {
		ArrayList<String> lineas = new ArrayList<String>();
		BufferedReader bfr = getBufferedReader(nombreFichero);
		String linea = bfr.readLine();
		while (linea != null) {
			lineas.add(linea);
			linea = bfr.readLine();
		}
		return lineas;
	}
}
