package base;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

	public static void main(String[] args) throws IOException {
		// ASOCIO EL SOCKET AL PUERTO 12345
		DatagramSocket socket = new DatagramSocket(12345);
		for (int i = 0; i < 3; i++) {
			// ESPERANDO DATAGRAM
			System.out.println("Servidor esperando datagrama.......");
			DatagramPacket recibo;

			byte[] bufer = new byte[1024];
			recibo = new DatagramPacket(bufer, bufer.length);
			socket.receive(recibo);// RECIBO DATAGRAMA

			String mensaje = new String(recibo.getData()).trim();
			System.out.println("Servidor recibe: " + mensaje);

			// SUMAR LOS NÚMEROS QUE RECIBIMOS
			String[] numeros = mensaje.split(",");
			String numeroString1 = numeros[0];
			int numero1 = Integer.parseInt(numeroString1);
			String numeroString2 = numeros[1];
			int numero2 = Integer.parseInt(numeroString2);
			int resultado = numero1 + numero2;

			// DIRECCION ORIGEN DEL MENSAJE
			InetAddress IPOrigen = recibo.getAddress();
			int puerto = recibo.getPort();

			// ENVIANDO DATAGRAMA AL CLIENTE
			System.out.println("Enviando la suma de los números => " + resultado);
			byte b = (byte) resultado; // paso entero a byte
			byte[] enviados = new byte[1024];
			enviados[0] = b;

			DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
			socket.send(envio);
		}
		// CERRAR SOCKET
		System.out.println("Cerrando conexión...");
		socket.close();
	}

}
