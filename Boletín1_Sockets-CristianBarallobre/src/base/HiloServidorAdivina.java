package base;

import java.io.*;
import java.net.*;

public class HiloServidorAdivina extends Thread {
	ObjectInputStream fentrada;
	ObjectOutputStream fsalida;

	Socket socket = null;

	ObjetoCompartido objeto;
	int identificador;
	

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
	}// ..

	// ----------------------------------------------------------------
	public void run() {
				
		System.out.println("=>Cliente conectado: " + identificador);

		//PREPARAR PRIMER ENVIO AL CLIENTE	
		Datos datos = new Datos("Adivina en que casilla se encuentra uno de los premios",identificador);
		
		if (objeto.seAcabo()) {
			datos.setCadena("LO SENTIMOS, EL JUEGO HA TERMINADO, NO QUEDAN MÁS PREMIOS");
			datos.setJuega(false); 
		}

		try {
			fsalida.reset();
			fsalida.writeObject(datos);
		} catch (IOException e1) {
			System.out.println("Error en el Hilo al realizar " + 
		                  "el primer envio al jugador: " + identificador);
			return;
		}

		while (!objeto.seAcabo()) { 
			String coordenadasCliente = ""; 
			try {
				//recibir datos del cliente
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
			
			datos = new Datos(cad, identificador);

			if (objeto.seAcabo()) {
				datos.setJuega(false); 
				if (identificador == objeto.getGanador())
					datos.setGana(true);				
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

		} // fin while

		if (objeto.seAcabo()) {
			System.out.println("EL JUEGO SE HA ACABADO.....");
			System.out.println("\t==>Desconecta: " + identificador);
		}
		try {
			fsalida.close();
			fentrada.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("Error en Hilo al cerrar cliente: " + identificador);
			e.printStackTrace();
		}

	}// run

}// ..