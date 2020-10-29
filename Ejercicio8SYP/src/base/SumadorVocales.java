package base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SumadorVocales {

	
	public static int sumarVocales(String letra, String nombreFicheroEntrada) {
		int numeroVocales = 0; 
		
		
		
		return numeroVocales;
	}
	
	

	public static PrintWriter getPrintWriter(String nombreFichero) throws IOException {
		FileWriter fileWriter = new FileWriter(nombreFichero);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		return printWriter;
	}

	public static ArrayList<String> getLineasFichero(String nombreFicheroEntrada) throws IOException, FileNotFoundException {
		ArrayList<String> lineas = new ArrayList<String>();
		FileReader lector = new FileReader(nombreFicheroEntrada);
		BufferedReader bfr = new BufferedReader(lector);
		String linea = bfr.readLine();
		while (linea != null) {
			lineas.add(linea);
			linea = bfr.readLine();
		}
		bfr.close();
		return lineas;
	}

	

	public static void main(String[] args) {
		String nombreFicheroEntrada = args[0];
		String letra = args[1];
		int sumaVocales = sumarVocales(letra,nombreFicheroEntrada);
		System.out.println(sumaVocales);
		System.out.flush();
	}
}
