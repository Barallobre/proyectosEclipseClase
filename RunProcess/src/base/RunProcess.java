package base;

import java.io.IOException;
import java.util.Arrays;

public class RunProcess {

	public static void main(String[] args) throws IOException{
		
		if(args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar.");
			System.exit(-1);
		}
		
		ProcessBuilder pb = new ProcessBuilder(args);
		try {
			Process process = pb.start();
			int retorno = process.waitFor(); //waitFor para que se mantenga el programa abierto
			System.out.println("La ejecuci�n de "+ 
					Arrays.toString(args)+ " devuelve "+retorno);
		}catch(IOException ex) {
			System.err.println("Excepcion de E/S");
			System.exit(-1);
		}catch(InterruptedException ex) {
			System.err.println("El proceso hijo finaliz� de forma incorrecta");
			System.exit(-1);
		}
	}
}
