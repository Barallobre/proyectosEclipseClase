package base;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorAdivina {
  public static void main(String args[]) throws IOException  {

	ServerSocket servidor = new ServerSocket(4444);
	System.out.println("Servidor iniciado...");	
	
	//Premios a adivinar dentro de un array bidimensional
	String premios[][] = {{"Crucero","","",""},{"","","Entradas",""},{"Masaje","","","1000€"}};
	System.out.println("Premios=> ");
	for (int i = 0; i < premios.length; i++) {
		for (int j = 0; j < premios[0].length; j++) {
			System.out.print("|"+ premios[i][j] + "|");
		}
		System.out.println("");
	}
	
	//Todos los hilos comparten el objeto
	ObjetoCompartido objeto = new ObjetoCompartido(premios);
	int id = 0;
	while (true) {	
		Socket cliente = new Socket();
		cliente = servidor.accept(); //esperando cliente
		id++;			
		HiloServidorAdivina hilo = new 
                           HiloServidorAdivina(cliente, objeto, id);
		hilo.start();		
	}	
  }
}//..
