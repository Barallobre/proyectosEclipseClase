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
	 * Al iniciar la aplicaci�n escribimos en el arrayList lo que se encuentra en el
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
			System.out.println("6. Salir de la aplicaci�n y volcar a archivo.");
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

	/* M�todo para insertar un alumno nuevo */
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
		System.out.println("�Tiene anticuerpos?: ");
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
	 * M�todo para modificar un alumno y sustituirlo en el array mediante su indice
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
	 * M�todo para eliminar un alumno del array y por tanto del fichero al volcarlo
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

	/* M�todo para lista un alumno buscado por DNI */
	public static void listaAlumno() {
		System.out.println("Indique el DNI del alumno que quiere buscar.");
		String DNI = sc.next();
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDNI().equals(DNI)) {
				System.out.println(alumnos.get(i));
			}
		}
	}

	/* M�todo para listar todos los alumnos del array */
	public static void listarAlumnos() {
		for (int i = 0; i < alumnos.size(); i++) {
			System.out.println(alumnos.get(i));
		}

	}

	/* M�todo para salir de la aplicaci�n y volcar el arrayList en el fichero */
	public static void salirVolcar() {
		System.out.println("Saliendo de la aplicaci�n...");
		volcarEnFichero();
		System.exit(0);
	}

	/* M�todo para volcar en el fichero los alumnos del array */
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
