package base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MCservidor {

	public static void main(String[] args) throws Exception {
		//FLUJO PARA ENTRADA ESTANDAR
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Se crea el socket multicast.
		MulticastSocket ms = new MulticastSocket();
		
		int Puerto = 12345;//Puerto multicast
		InetAddress grupo = InetAddress.getByName("255.0.0.1");//Grupo 
		String cadena =  "";
		
		while (!cadena.trim().equals("*")){
			System.out.println("Datos a enviar al grupo: ");
			cadena = in.readLine();
			//ENVIANDO AL GRUPO
			DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, Puerto);
			ms.send(paquete);
		}
		ms.close();//cierro socket
		System.out.println("Socket cerrado...");
	}

}
