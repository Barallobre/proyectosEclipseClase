package base;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorAdivina {

	public static void main(String[] args) throws IOException {
		
		ServerSocket servidor = new ServerSocket(6001);
		System.out.println("Servidor iniciando...");
		
		//Número a adivinar entre 1 y 25
		int numero = (int) (1+25*Math.random());
		System.out.println("NUMERO A ADIVINAR=> " +numero);
		
		//Todos los hilos comparten el objeto
		ObjetoCompartido objeto = new ObjetoCompartido(numero);
		int id = 0;
		while(true) {
			Socket cliente = new Socket();
			cliente = servidor.accept(); //esperando cliente
			id++; //identificador para el cliente
			HiloServidorAdivina hilo = new HiloServidorAdivina(cliente, objeto, id);
			hilo.start();
		}
	}

}
