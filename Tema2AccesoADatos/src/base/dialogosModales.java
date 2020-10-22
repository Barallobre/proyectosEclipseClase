package base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class dialogosModales {
	Scanner sc = new Scanner(System.in);
	static ArrayList<String> contactos = new ArrayList<String>();

	public static void main(String[] args) {
		panel();
	}

	public static void panel() {
		String[] opciones = { "Añadir contacto", "Borrar contacto", "Modificar contacto", "Listar contactos", "Salir" };
		String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Opciones",
				JOptionPane.DEFAULT_OPTION, null, opciones, opciones[0]);
		menu(opcion);
	}

	public static void menu(String opcion) {
		if (opcion == null) {
			salir();
		} else {
			switch (opcion) {
			case "Añadir contacto":
				agregarContacto();
				break;
			case "Borrar contacto":
				borrarContacto();
				break;
			case "Modificar contacto":
				// modificarContacto();
				break;
			case "Listar contactos":
				listarContactos();
				break;
			case "Salir":
				salir();
				break;

			}
			panel();
		}
	}

	/*
	 * Agregar contacto a un archivo de texto desde donde accederemos para
	 * listarlos, borrarlos y/o modificarlos
	 */
	public static void agregarContacto() {
		String nombre = JOptionPane.showInputDialog(null, "Introduzca el nuevo nombre", "Añadir contacto",
				JOptionPane.DEFAULT_OPTION);
		try {
			BufferedWriter bfw = new BufferedWriter(new FileWriter("contactos.txt", true));
			bfw.write(nombre);
			bfw.newLine();
			bfw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Borrar contacto que este en la lista antes creada */
	public static void borrarContacto() {
		String nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre que desea eliminar", "Borrar contacto",
				JOptionPane.DEFAULT_OPTION);
		try {
			BufferedReader bfr = new BufferedReader(new FileReader("contactos.txt"));

			String linea = bfr.readLine();

			while (linea != null) {
				contactos.add(linea);
				linea = bfr.readLine();

			}
			bfr.close();
//preguntar si querer borrarlo

			int respuesta;
			respuesta = (int) JOptionPane.showConfirmDialog(null, "¿Está seguro de querer borrarlo?", "Borrar contacto",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (respuesta == JOptionPane.YES_OPTION) {
				for (int i = 0; i < contactos.size(); i++) {
					if (nombre.equals(contactos.get(i))) {
						contactos.remove(i);
					}
				}
			} else {
				panel();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {

			BufferedWriter bfw = new BufferedWriter(new FileWriter("contactos.txt"));

			for (int i = 0; i < contactos.size(); i++) {
				bfw.write(contactos.get(i));
				bfw.newLine();
			}
			bfw.close();
			contactos.clear();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void modificarContacto() {
		String nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre que desea modificar", "Borrar contacto",
				JOptionPane.DEFAULT_OPTION);
	}

	/* Listar contactos en una lista desplegable */
	public static void listarContactos() {
		String[] contactos1 = null;
		try {
			BufferedReader bfr = new BufferedReader(new FileReader("contactos.txt"));

			String linea = bfr.readLine();

			while (linea != null) {
				contactos.add(linea);
				linea = bfr.readLine();

			}
			bfr.close();
			contactos1 = new String[contactos.size()];
			for (int i = 0; i < contactos.size(); i++) {
				contactos1[i] = contactos.get(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		JOptionPane.showInputDialog(null, "Lista de contactos", "Contactos", JOptionPane.DEFAULT_OPTION, null,
				contactos1, contactos1[0]);
	}

	/* Saliendo de la aplicación */
	public static void salir() {
		System.exit(0);
	}

}
