package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Principal {

	public static void main(String[] args) {
		File fichero1 = new File("C:\\Users\\Usuario\\Desktop\\Ejercicio1");
		// si el fichero no existe creamos el directorio donde trabajaremos
		if (!fichero1.exists()) {
			fichero1.mkdir();
			try {
				// Con FileReader leemos el fichero y al mismo tiempo con FileWriter lo
				// guardamos en una copia
				FileReader fichero = new FileReader(
						"C:\\Users\\Usuario\\Desktop\\Ficheros para el ejercicio\\Provincias.txt");
				FileWriter fichero2 = new FileWriter("C:\\Users\\Usuario\\Desktop\\Ejercicio1\\CopiaProvincias.txt");
				int valor = 0;
				char caracter;
				// lo hacemos hasta que de -1 lo cual indica el final del fichero
				while (valor != -1) {
					valor = fichero.read();
					caracter = (char) valor;
					fichero2.write(caracter);
					System.out.print(caracter);
				}
				fichero.close();
				fichero2.close();
			} catch (IOException e) {
				System.out.println("Error de lectura del fichero");
			}
			/*-------------------------------------------------------------------------------*/
			//Con un BufferedReader leemos el fichero donde están las provincias para buscar dónde está Andalucia
			File ficheroProvincias = new File("C:\\Users\\Usuario\\Desktop\\Provincias.txt");
			BufferedReader provincias;
			try {
				provincias = new BufferedReader(new FileReader(ficheroProvincias));
				try {
					String linea = provincias.readLine();
					while (linea != null) {

						linea = provincias.readLine();
						//Si la linea que buscamos nos indica que es Andalucia trabajamos a partir de ahí con una condición
						if (linea.substring(0, 3).equals("Anda")) {
							System.out.println("aqui");
							//Creamos el fichero para luego hacerlo de acceso aleatorio
							File ficheroAndalucia = new File("C:\\Users\\Usuario\\Desktop\\Ejercicio1\\Andalucia.dat");
							
							//Declaro el fichero de acceso aleatorio para lectura/escritura
							RandomAccessFile fichAleatorio;
							try {
								fichAleatorio = new RandomAccessFile(ficheroAndalucia, "rw");
							} catch (FileNotFoundException e) {
								System.out.println("Fichero no encontrado");
							}
							
					
							
							StringBuffer bufferNombre = null; // Buffer para guardar y completar el nombre hasta 7 caracteres
							
							for (int i = 0; i < provincias.length; i++) { 
								bufferNombre = new StringBuffer(nombre[i]); // Un StringBuffer es como un String al que se
								// puede modificar la longitud y el contenido
								bufferNombre.setLength(7); // Aumento la longitud del nombre a 7 caracteres
								fichAleatorio.writeChars(bufferNombre.toString()); // Convierto el buffer en String
								// normal y lo grabo en el fichero
								fichAleatorio.writeInt(poblacion[i]); // Grabo en el fichero la poblacion.
								
							}
							fichAleatorio.close();
							
						}
					}
				} catch (IOException e) {
					System.out.println("Error en el fichero de entrada");
				}
			} catch (FileNotFoundException e1) {
				System.out.println("Fichero no encontrado");
			}

			
			

		}

	}
}
