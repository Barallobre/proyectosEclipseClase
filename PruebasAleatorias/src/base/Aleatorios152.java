package base;

import java.io.*;

public class Aleatorios152 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File fichero = new File("C:\\Users\\Cristian\\Desktop\\Empleados.dat");
		// File fichero = new File("C:\\Users\\Usuario\\Desktop\\Empleados.dat");

		RandomAccessFile fichAleatorio = new RandomAccessFile(fichero, "rw");

		String nombre[] = { "María J.", "Diego", "Mijail", "Totó", "Juan" };
		int departamento[] = { 10, 10, 30, 20, 20 };
		double salario[] = { 1300.45, 1298.75, 1305.0, 1280.25, 1320.0 };

		StringBuffer buffer = null;

		for (int i = 0; i < nombre.length; i++) {
			fichAleatorio.writeInt(i + 1);

			buffer = new StringBuffer(nombre[i]);
			buffer.setLength(15);

			fichAleatorio.writeChars(buffer.toString());
			fichAleatorio.writeInt(departamento[i]);
			fichAleatorio.writeDouble(salario[i]);
		}
		fichAleatorio.close();

		RandomAccessFile fichero2 = new RandomAccessFile(fichero.toString(), "rw");
		String nombre2 = "";

		for (int i = 0; i < fichero.length()/46; i++) {
			System.out.println("Nº empleado: " +fichero2.readInt());
			for (int j = 0; j < 15; j++) {
				nombre2 += String.valueOf(fichero2.readChar());
			}
			System.out.println("Nombre: "+nombre2);
			nombre2 = "";
			System.out.println("Departamento: "+fichero2.readInt());
			System.out.println("Salario: "+fichero2.readDouble()+"\n");
		}
		
		System.out.println("---------------------------------------------------------------------------------------------------------");

		int largo = (int) fichero.length();
		while (largo != 0) {
			fichero2.seek(largo - 46); // me coloco antes del ultimo nombre

			System.out.println("Nº empleado: " +fichero2.readInt());
			for (int j = 0; j < 15; j++) {
				nombre2 += String.valueOf(fichero2.readChar());
			}
			System.out.println("Nombre: "+nombre2);
			nombre2 = "";
			System.out.println("Departamento: "+fichero2.readInt());
			System.out.println("Salario: "+fichero2.readDouble()+"\n");

			largo = largo - 46;
		}
		fichero2.close();
	}
}