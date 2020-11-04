/*Realiza una aplicaci�n que permita trabajar con alumnos. De cada alumno interesa su DNI, nombre, edad y si
tiene anticuerpos del COVID-19; adem�s, cada alumno estudia y se examina. El atributo relacionado con los
anticuerpos se utilizar� para la creaci�n del objeto, pero no ser� serializable.
Al comenzar, los alumnos almacenados en un fichero ser�n le�dos y guardados en un array de alumnos. Si no
hubiera ning�n alumno en el fichero, el array no contendr� datos.
Un men� permitir� insertar, modificar, eliminar, listar un alumno o mostrar todos. Las acciones asociadas al
men� se realizar�n sobre el array. Al escoger la opci�n salir, el fichero inicial ser� sobrescrito con la nueva lista
de alumnos.
Requisitos m�nimos: insertar un alumno y listar todos los alumnos, utilizando la consola*/
package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	static ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		int opc = 0;
		final int finalOpc = 6;
		do {
			System.out.println("1. Insertar alumno.");
			System.out.println("2. Modificar alumno.");
			System.out.println("3. Elimniar alumno.");
			System.out.println("4. Lista alumnos.");
			System.out.println("5. Listar todos los alumnos.");
			System.out.println("6. Salir de la aplicaci�n y volcar a archivo.");
			opc = sc.nextInt();
		} while (opc <= 0 || opc > finalOpc);
		menuSwitch(opc);

	}

	public static void menuSwitch(int opc) {
		switch (opc) {
		case 1:
			insertarAlumno();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:

			break;
		case 5:
			listarAlumnos();
			break;
		case 6:
			salirVolcar();
			break;
		}
	}

	public static void insertarAlumno() {

		String DNI;
		String nombre;
		int edad;
		boolean tieneAnticuerpos = false;

		System.out.println("Introduzca el DNI: ");
		DNI = sc.next();
		System.out.println("Introduzca edad: ");
		edad = sc.nextInt();
		System.out.println("Introduzca nombre: ");
		nombre = sc.next();
		System.out.println("�Tiene anticuerpos?: ");
		String respuesta;
		respuesta = sc.next();

		if (respuesta.toUpperCase().charAt(0) == 'S') {
			tieneAnticuerpos = true;
		}
		String ruta = "alumnos.dat";
		Alumno alumno = new Alumno(DNI, nombre, edad, tieneAnticuerpos);
		ObjectOutputStream os;

		menu();
	}

	public static void listarAlumnos() {
		String ruta = "alumnos.dat";
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream(ruta));
			Alumno alumno = (Alumno) is.readObject();
			System.out.println(alumno.getDatos());
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void salirVolcar() {

		Alumno alumno = new Alumno(DNI, nombre, edad, tieneAnticuerpos);
		try {
			os = new ObjectOutputStream(new FileOutputStream(ruta));
			os.writeObject(alumno);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
