/*Realiza una aplicación que permita trabajar con alumnos. De cada alumno interesa su DNI, nombre, edad y si
tiene anticuerpos del COVID-19; además, cada alumno estudia y se examina. El atributo relacionado con los
anticuerpos se utilizará para la creación del objeto, pero no será serializable.
Al comenzar, los alumnos almacenados en un fichero serán leídos y guardados en un array de alumnos. Si no
hubiera ningún alumno en el fichero, el array no contendrá datos.
Un menú permitirá insertar, modificar, eliminar, listar un alumno o mostrar todos. Las acciones asociadas al
menú se realizarán sobre el array. Al escoger la opción salir, el fichero inicial será sobrescrito con la nueva lista
de alumnos.
Requisitos mínimos: insertar un alumno y listar todos los alumnos, utilizando la consola*/
package base;

import java.io.EOFException;
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

	/*
	 * Al iniciar la aplicación escribimos en el arrayList lo que se encuentra en el
	 * fichero
	 */
	public static void main(String[] args) {
		String ruta = "alumnos.dat";
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream(ruta));
			try {
				while (true) {

					Alumno alumno = (Alumno) is.readObject();
					System.out.println(alumno.getDatos());
					alumnos.add(alumno);
				}
			} catch (EOFException e) {
			}
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		menu();
	}

	public static void menu() {
		int opc = 0;
		final int finalOpc = 6;
		do {
			System.out.println("1. Insertar alumno.");
			System.out.println("2. Modificar alumno.");
			System.out.println("3. Elimniar alumno.");
			System.out.println("4. Lista alumno.");
			System.out.println("5. Listar todos los alumnos.");
			System.out.println("6. Salir de la aplicación y volcar a archivo.");
			opc = sc.nextInt();
		} while (opc <= 0 || opc > finalOpc);
		menuSwitch(opc);

	}

	public static void menuSwitch(int opc) {
		switch (opc) {
		case 1:
			insertarAlumno(alumnos.size());
			break;
		case 2:
			modificarAlumno();
			break;
		case 3:
			eliminarAlumno();
			break;
		case 4:
			listaAlumno();
			break;
		case 5:
			listarAlumnos();
			break;
		case 6:
			salirVolcar();
			break;
		}
		menu();
	}

	/* Método para insertar un alumno nuevo */
	public static void insertarAlumno(int posicion) {

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
		System.out.println("¿Tiene anticuerpos?: ");
		String respuesta;
		respuesta = sc.next();

		if (respuesta.toUpperCase().charAt(0) == 'S') {
			tieneAnticuerpos = true;
		}
		Alumno alumno = new Alumno(DNI, nombre, edad, tieneAnticuerpos);
		alumnos.add(posicion, alumno);

		menu();
	}

	/*
	 * Método para modificar un alumno y sustituirlo en el array mediante su indice
	 */
	public static void modificarAlumno() {
		System.out.println("Indique el DNI del alumno que quiere modificar.");
		String DNI = sc.next();
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDNI().equals(DNI)) {
				alumnos.remove(i);
				insertarAlumno(i);
				
			}
		}
	}

	/*
	 * Método para eliminar un alumno del array y por tanto del fichero al volcarlo
	 */
	public static void eliminarAlumno() {
		System.out.println("Indique el DNI del alumno que quiere eliminar.");
		String DNI = sc.next();
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDNI().equals(DNI)) {
				alumnos.remove(i);
			}
		}
	}

	/* Método para lista un alumno buscado por DNI */
	public static void listaAlumno() {
		System.out.println("Indique el DNI del alumno que quiere buscar.");
		String DNI = sc.next();
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDNI().equals(DNI)) {
				System.out.println(alumnos.get(i));
			}
		}
	}

	/* Método para listar todos los alumnos del array */
	public static void listarAlumnos() {
		for (int i = 0; i < alumnos.size(); i++) {
			System.out.println(alumnos.get(i));
		}

	}

	/* Método para salir de la aplicación y volcar el arrayList en el fichero */
	public static void salirVolcar() {
		System.out.println("Saliendo de la aplicación...");
		volcarEnFichero();
		System.exit(0);
	}

	/* Método para volcar en el fichero los alumnos del array */
	public static void volcarEnFichero() {
		String ruta = "alumnos.dat";
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ruta));
			for (int i = 0; i < alumnos.size(); i++) {
				os.writeObject(alumnos.get(i));
			}
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
