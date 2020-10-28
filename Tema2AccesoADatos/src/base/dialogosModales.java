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

	/*
	 * Método que nos mostrará en un panel las distintas opciones de la aplicación
	 */
	public static void panel() {
		String[] opciones = { "Añadir contacto", "Borrar contacto", "Modificar contacto", "Listar contactos", "Salir" };
		String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Opciones",
				JOptionPane.DEFAULT_OPTION, null, opciones, opciones[0]);
		menu(opcion);
	}

	/* A partir del panel entramos en el switch a las diferentes opciones */
	public static void menu(String opcion) {
		if (opcion == null) {
			salir();
		} else {
			switch (opcion) {
			case "Añadir contacto":
				agregarContacto();
				break;
			case "Borrar contacto":
				try {
					borrarContacto();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "IOException", "Error", JOptionPane.WARNING_MESSAGE);
				}
				break;
			case "Modificar contacto":
				try {
					modificarContacto();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "IOException", "Error", JOptionPane.WARNING_MESSAGE);
				}
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

	/* Agregar contacto a un archivo de texto */
	public static void agregarContacto() {
		String nombre = JOptionPane.showInputDialog(null, "Introduzca el nuevo nombre", "Añadir contacto",
				JOptionPane.DEFAULT_OPTION);

		agregarContacto2(nombre);

		panel();
	}

	/* Añadir el contacto al fichero */
	public static void agregarContacto2(String nombre) {
		try {
			BufferedWriter bfw = new BufferedWriter(new FileWriter("contactos.txt", true));
			bfw.write(nombre);
			bfw.newLine();
			bfw.close();
			contactos.clear();
		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, "IOException", "Error", JOptionPane.WARNING_MESSAGE);
			panel();
		}
	}

	/* Borrar contacto que este en la lista antes creada */
	public static void borrarContacto() throws IOException {
		String nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre que desea eliminar", "Borrar contacto",
				JOptionPane.DEFAULT_OPTION);
		pasarListaAArray();
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

		BufferedWriter bfw = new BufferedWriter(new FileWriter("contactos.txt"));

		for (int i = 0; i < contactos.size(); i++) {
			bfw.write(contactos.get(i));
			bfw.newLine();
		}
		bfw.close();
		contactos.clear();

	}

	/* Convertimos la lista del documento en un arrayList */
	public static void pasarListaAArray() {

		try {
			BufferedReader bfr = new BufferedReader(new FileReader("contactos.txt"));

			String linea = bfr.readLine();

			while (linea != null) {
				contactos.add(linea);
				linea = bfr.readLine();

			}
			bfr.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "IOException", "Error", JOptionPane.WARNING_MESSAGE);
			panel();
		}
	}

	/* Modificamos el contacto cambiando el nombre si existe en el fichero */
	public static void modificarContacto() throws IOException {
		int posicion = 0;
		boolean hayContacto = false;
		String nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre que desea modificar",
				"Modificar contacto", JOptionPane.DEFAULT_OPTION);
		pasarListaAArray();
		for (int i = 0; i < contactos.size(); i++) {
			if (contactos.get(i).equals(nombre)) {
				posicion = i;
				hayContacto = true;
			}
		}

		if (hayContacto) {
			String nombreNuevo = JOptionPane.showInputDialog(null, "Introduzca el nuevo nombre", "Modificar contacto",
					JOptionPane.DEFAULT_OPTION);
			contactos.remove(posicion);
			contactos.add(posicion, nombreNuevo);

			BufferedWriter bfw = new BufferedWriter(new FileWriter("contactos.txt"));

			for (int i = 0; i < contactos.size(); i++) {
				bfw.write(contactos.get(i));
				bfw.newLine();
			}
			bfw.close();
			contactos.clear();

		} else {
			JOptionPane.showMessageDialog(null, "El usuario que busca no se encuentra en la lista",
					"Modificar contacto", JOptionPane.WARNING_MESSAGE);
			contactos.clear();
		}

	}

	/* Listar contactos en una lista desplegable */
	public static void listarContactos() {
		try {
			String[] contactos1 = null;
			pasarListaAArray();
			contactos1 = new String[contactos.size()];
			for (int i = 0; i < contactos.size(); i++) {
				contactos1[i] = contactos.get(i);
			}

			JOptionPane.showInputDialog(null, "Lista de contactos", "Contactos", JOptionPane.DEFAULT_OPTION, null,
					contactos1, contactos1[0]);
			contactos.clear();
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "No hay contactos todavía en la lista.", "Lista de contactos",
					JOptionPane.WARNING_MESSAGE);
			panel();
		}
	}

	/* Saliendo de la aplicación */
	public static void salir() {
		System.exit(0);
	}

}
