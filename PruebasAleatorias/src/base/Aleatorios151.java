package base;

import java.io.*;

public class Aleatorios151 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File fichero = new File("C:\\Users\\Usuario\\Desktop\\Empleados.dat");
		
		//Declaro el fichero de acceso aleatorio para lectura/escritura
		RandomAccessFile fichAleatorio = new RandomAccessFile(fichero, "rw");
		
		String nombre[] = { "María J.", "Diego", "Mijail", "Totó", "Juan" };
		int departamento[] = { 10, 10, 30, 20, 20 };
		double salario[] = { 1300.45, 1298.75, 1305.0, 1280.25, 1320.0 };
		
		StringBuffer buffer = null; // Buffer para guardar y completar el nombre hasta 15 caracteres
		
		for (int i = 0; i < nombre.length; i++) { // Para cada empleado...
			fichAleatorio.writeInt(i + 1); // Escribo en el fichero el nº de empleado
			buffer = new StringBuffer(nombre[i]); // Un StringBuffer es como un String al que se
			// puede modificar la longitud y el contenido
			
			buffer.setLength(15); // Aumento la longitud del nombre a 15 caracteres
			fichAleatorio.writeChars(buffer.toString()); // Convierto el buffer en String
			// normal y lo grabo en el fichero
			
			fichAleatorio.writeInt(departamento[i]); // Grabo en el fichero el nº depto.
			fichAleatorio.writeDouble(salario[i]); // Grabo en el fichero el salario
		}
		fichAleatorio.close();
		
	
	}
	
}
