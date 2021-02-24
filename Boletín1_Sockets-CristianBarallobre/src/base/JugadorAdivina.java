package base;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class JugadorAdivina {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String Host = "localhost";
		int Puerto = 44444;
		Socket Cliente = new Socket(Host, Puerto);

		ObjectOutputStream fsalida = new ObjectOutputStream(Cliente.getOutputStream());
		ObjectInputStream fentrada = new ObjectInputStream(Cliente.getInputStream());

		// FLUJO PARA ENTRADA ESTANDAR
		Scanner sc = new Scanner(System.in);
		String cadena = "";

		// OBTENER PRIMER OBJETO ENVIADO POR EL SERVIDOR
		Datos datos = (Datos) fentrada.readObject();

		int identificador = datos.getIdentificador();
		System.out.println("Id jugador: " + identificador);
		System.out.println(datos.getCadena());

		cadena = "";
	
		if (!datos.isJuega())
			cadena = "*";

		while (datos.isJuega() && !cadena.trim().equals("*")) {
			System.out.print("Intento: " + (datos.getIntentos() + 1) + "\n");
			cadena = sc.nextLine();
			Datos d = new Datos();
			if (!validarCadena(cadena)) {
				System.out.println("Dato incorrecto, introduzca el formato indicado.");
				continue;
			}

			d.setCadena(cadena);

			fsalida.reset();
			fsalida.writeObject(d);

			datos = (Datos) fentrada.readObject();
			System.out.println("\t" + datos.getCadena());
			if (datos.getIntentos() >= 4) {
				System.out.println("\tNo tienes más intentos.");
				cadena = "*";
			}
			if (!(datos.isJuega())) {
				System.out.println("El juego ha terminado, ya no quedan premios!");
				cadena = "*";
			}
		}

		fsalida.close();
		fentrada.close();
		System.out.println("Fin de proceso... ");
		sc.close();
		Cliente.close();
	}

	private static boolean validarCadena(String cadena) {
		return cadena.matches("^[0-2]\\,[0-3]$");
	}
}
