package base;

import java.io.File;
import java.io.IOException;

public class Excepcion1 {
	public static void main(String[] args) {
//declaramos un objeto File�
		File fichero = new File("C:\\Usuario\\Desktop\\ejemplo.txt");
//�y creamos el fichero asociado
		try {
			fichero.createNewFile();
		} catch (IOException e) {
			System.out.println("Error al crear el fichero.");
			System.out.println(e.toString()); //as� nos ense�a el tipo de excepci�n
		}finally {
			System.out.println("He entrado en el finally");
		}
	}
}