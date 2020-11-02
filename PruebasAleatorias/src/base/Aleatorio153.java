package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Aleatorio153 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File fichero = new File("C:\\Users\\Usuario\\Desktop\\Empleados.dat");

		RandomAccessFile fichero2 = new RandomAccessFile(fichero.toString(), "rw");

		String nombre2 = "";
		boolean empleadoBuscadoFinal = false;
		char respuesta = 0;
		do {
		System.out.println("Qué número de empleado quiere buscar?");
		int numeroEmpleado = sc.nextInt();
		int empleadoBuscado = 46*(numeroEmpleado-1);
		if(empleadoBuscado >((fichero2.length())-46)||empleadoBuscado<0) {
			System.out.println("Ese número de empleado no existe");
			do {
			System.out.println("Quiere introducir otro?(S/N)");
			sc.nextLine();
			respuesta = sc.nextLine().toUpperCase().charAt(0);
			if(respuesta != 'S' && respuesta != 'N') {
				System.out.println("Escriba una respuesta correcta!");
			}
			}while (respuesta != 'S' && respuesta != 'N');
		}else {
			fichero2.seek(empleadoBuscado);
			System.out.println("Nº empleado: " + fichero2.readInt());
			for (int j = 0; j < 15; j++) {
				nombre2 += String.valueOf(fichero2.readChar());
			}
			System.out.println("Nombre: " + nombre2);
			nombre2 = "";
			System.out.println("Departamento: " + fichero2.readInt());
			System.out.println("Salario: " + fichero2.readDouble() + "\n");
			empleadoBuscadoFinal = true;
			
			}
		}while(respuesta=='S' && !empleadoBuscadoFinal);
		fichero2.close();
	}
}