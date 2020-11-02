package base;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	static ArrayList<Empleado> empleado = new ArrayList<Empleado>();
	static Scanner sc = new Scanner(System.in);

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
		crearEmpleado(fichero, nombre);
		preguntarEmpleado();
	}

	public static char confirmarPeticion() {
		char respuesta;
		sc.nextLine();
		do {
			System.out.println("Quiere introducir otro?(S/N)");

			String respuestaUsuario = sc.nextLine();
			respuesta = respuestaUsuario.toUpperCase().charAt(0);
		} while (respuesta != 'S' && respuesta != 'N');
		return respuesta;
	}

	public static void preguntarEmpleado() {
		boolean numeroCorrecto = false;
		char repetirPeticion = 0;
		do {

			System.out.println("Indique el número de empleado que quiere buscar:");
			int numeroEmpleado = sc.nextInt();

			if (numeroEmpleado < 1 || numeroEmpleado > empleado.size()) {
				System.out.println("Ese número no se encuentra en la lista.");
				repetirPeticion = confirmarPeticion();
			} else {
				System.out.println(empleado.get(numeroEmpleado - 1));
				numeroCorrecto = true;
			}

		} while (!numeroCorrecto && repetirPeticion == 'S');
	}

	public static void crearEmpleado(File fichero, String[] nombre) throws FileNotFoundException {
		RandomAccessFile fichero2 = new RandomAccessFile(fichero.toString(), "rw");
		int numeroEmpleado = 0;
		String nombre1 = null;
		int departamento1 = 0;
		double salario1 = 0;

		try {
			String nombre2 = "";

			for (int j = 0; j < fichero.length() / 46; j++) {
				numeroEmpleado = fichero2.readInt();
				for (int k = 0; k < 15; k++) {
					nombre2 += String.valueOf(fichero2.readChar());
				}
				nombre1 = nombre2;
				nombre2 = "";
				departamento1 = fichero2.readInt();
				salario1 = fichero2.readDouble();
				Empleado empleadoAux = new Empleado(numeroEmpleado, nombre1, departamento1, salario1);
				empleado.add(empleadoAux);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
