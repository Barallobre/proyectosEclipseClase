package base;

import java.io.*;
import java.net.*;

public class HiloServidorAdivina extends Thread {
	ObjectInputStream fentrada;
	ObjectOutputStream fsalida;

	Socket socket = null;

	ObjetoCompartido objeto;
	int identificador;
	int intentos = 0;
	public HiloServidorAdivina(Socket s, ObjetoCompartido objeto, int id) {
		this.socket = s;
		this.objeto = objeto;
		this.identificador = id;
		try {
			fsalida = new ObjectOutputStream(socket.getOutputStream());
			fentrada = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("ERROR DE E/S en HiloServidor");
			e.printStackTrace();
		}
	}

	public void run() {

		System.out.println("Cliente conectado => " + identificador);

	
		Datos datos = new Datos(
				"Adivina en que casilla se encuentra uno de los premios. Introduce fila y columna, separados por una coma.",
				intentos,identificador);

		if (objeto.seAcabo()) {
			datos.setCadena("Lo sentimos, no quedan más premios, el juego ha terminado.");
			datos.setJuega(false);
		}

		try {
			fsalida.reset();
			fsalida.writeObject(datos);
		} catch (IOException e1) {
			System.out.println("Error en el Hilo al realizar " + "el primer envio al jugador: " + identificador);
			return;
		}

		while (!objeto.seAcabo()|| !(datos.getIntentos() == 5)) {
			String coordenadasCliente = "";
			try {

				Datos d = (Datos) fentrada.readObject();
				coordenadasCliente = d.getCadena();
			} catch (IOException e) {
				System.out.println("Error en el Hilo al leer del jugador: " + identificador);
				break;
			} catch (NumberFormatException n) {
				System.out.println("El jugador:" + identificador + " se ha desconectado");
				break;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				break;
			}

			String cad = objeto.nuevaJugada(identificador, coordenadasCliente);
			intentos++;
			datos = new Datos(cad,intentos, identificador);

			if (objeto.seAcabo()) {
				datos.setJuega(false);

			}

			try {
				fsalida.reset();
				fsalida.writeObject(datos);
			} catch (IOException n1) {
				System.out.println(
						"Error escribiendo en flujo de salida del jugador: " + identificador + " * " + n1.getMessage());
				break;
			} catch (NullPointerException n) {
				System.out.println("El jugador  " + identificador + " ha desconectado ");
				break;
			}
		}

		if (objeto.seAcabo()) {
			System.out.println("Los premios se han terminado...");
			System.out.println("\tDesconecta => " + identificador);
		}
		try {
			fsalida.close();
			fentrada.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("Error en Hilo al cerrar cliente: " + identificador);
			e.printStackTrace();
		}
	}
}