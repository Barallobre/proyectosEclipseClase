package base;

import javax.swing.JOptionPane;

public class dialogosModales {

	public static void main(String[] args) {
		
		String[] opciones = {"A�adir contacto","Borrar contacto","Modificar contacto","Listar contactos","Salir"};
		JOptionPane.showInputDialog(null, "Seleccione una opci�n", "Opciones", JOptionPane.DEFAULT_OPTION, null,
				opciones, opciones[0]);
	}

}
