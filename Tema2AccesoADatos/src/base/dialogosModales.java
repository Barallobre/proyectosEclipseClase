package base;

import javax.swing.JOptionPane;

public class dialogosModales {

	public static void main(String[] args) {
		String[] contactos = null;
		panel(contactos);

	}

	public static void panel(String[] contactos) {
		String[] opciones = { "Añadir contacto", "Borrar contacto", "Modificar contacto", "Listar contactos", "Salir" };
		String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Opciones",
				JOptionPane.DEFAULT_OPTION, null, opciones, opciones[0]);
		menu(opcion, contactos);
	}

	public static void menu(String opcion,String[] contactos ) {
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
				modificarContacto();
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

	public static void agregarContacto() {
		String nombre = JOptionPane.showInputDialog(null, "Introduzca el nuevo nombre", "Añadir contacto",JOptionPane.DEFAULT_OPTION);
	}

	public static void borrarContacto() {
		String nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre que desea eliminar", "Borrar contacto",JOptionPane.DEFAULT_OPTION);
	}

	public static void modificarContacto() {

	}

	public static void listarContactos() {
		JOptionPane.showInputDialog(null, "Lista de contactos", "Contactos",
				JOptionPane.DEFAULT_OPTION, null, contactos, contactos[0]);
	}

	public static void salir() {
		System.out.println("Saliendo de la aplicación...");
		System.exit(0);
	}
}
