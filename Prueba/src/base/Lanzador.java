package base;

import java.io.File;
import java.io.IOException;

public class Lanzador {


	public void lanzaProceso(String fichEntrada, String letra, String fichResultado) {
	String clase = "base.ProcesadorFichero";
	File directorioFich;
	directorioFich = new File("D:\\ProyectosEclipseSegundo\\proyectosEclipseClase\\Prueba\\bin");
	ProcessBuilder pb;
	try {
		pb = new ProcessBuilder("java", clase,fichEntrada, letra);
		pb.directory(directorioFich);
		pb.redirectError(new File("errores.txt")); // Si hay algún error, almacenarlo en un fichero
		pb.redirectOutput(new File(fichResultado));
		pb.start();
	} catch (Exception e) {
//TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String fichEntrada= "vocales.txt";
		String[] vocales = { "A", "E", "I", "O", "U" };
		Lanzador l = new Lanzador();
		
		System.out.println("Ok");
		/* Se lanzan los procesos */
		for (int i = 0; i < vocales.length; i++) {
			String fichErrores = "Errores_" + vocales[i] + ".txt";
			l.lanzaProceso(fichEntrada, vocales[i], "letras"+vocales[i]+".txt");
			System.out.println(vocales[i]);
			// Fin del for
		}
		/* Esperamos un poco */
		Thread.sleep(3000);
		
	}
}
