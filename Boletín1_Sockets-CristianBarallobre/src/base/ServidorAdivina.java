package base;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorAdivina {
	public static void main(String args[]) throws IOException {

		ServerSocket servidor = new ServerSocket(44444);
		System.out.println("Servidor iniciado...");

		// Premios a adivinar dentro de un array bidimensional
		String premios[][] = { { "        ", "        ", "        ", "        " },
				{ "        ", "        ", "        ", "        " },
				{ "        ", "        ", "        ", "        " } };
		int premioColocado = 0;
		ArrayList<String> nombrePremios = new ArrayList<String>();
		ArrayList<String> coordenadasPremios = new ArrayList<String>();
		nombrePremios.add("Crucero ");
		nombrePremios.add("Masaje  ");
		nombrePremios.add("1000€   ");
		nombrePremios.add("Entradas");

		while (premioColocado < 4) {
			for (int i = 0; i < nombrePremios.size(); i++) {
				int fila = (int) ((Math.random() * 3));
				int columna = (int) ((Math.random() * 4));
				if (premios[fila][columna] == "        ") {
					premios[fila][columna] = nombrePremios.get(i);
					nombrePremios.remove(i);
					coordenadasPremios.add(fila + "," + columna);
					premioColocado++;
				}
			}
		}
		System.out.println("Premios=> ");
		for (int i = 0; i < premios.length; i++) {
			for (int j = 0; j < premios[0].length; j++) {
				System.out.print("|" + premios[i][j] + "|");
			}
			System.out.println("");
		}
		System.out.print("\nPosiciones con premio: ");
		for (int i = 0; i < coordenadasPremios.size(); i++) {
			System.out.print("[");
			System.out.print(coordenadasPremios.get(i));
			System.out.print("]");
			System.out.print(" ");

		}

		// Todos los hilos comparten el objeto
		ObjetoCompartido objeto = new ObjetoCompartido(premios);
		int id = 0;
		while (true) {
			Socket cliente = new Socket();
			cliente = servidor.accept();
			id++;
			HiloServidorAdivina hilo = new HiloServidorAdivina(cliente, objeto, id);
			hilo.start();
		}
	}
}
