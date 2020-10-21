package base;

import javax.swing.JOptionPane;

public class dialogosModales {

	public static void main(String[] args) {
		
		String[] opciones = {"Añadir contacto","Borrar contacto","Modificar contacto","Listar contactos","Salir"};
		JOptionPane.showInputDialog(null, "Seleccione una opción", "Opciones", JOptionPane.DEFAULT_OPTION, null,
				opciones, opciones[0]);
	}

}
