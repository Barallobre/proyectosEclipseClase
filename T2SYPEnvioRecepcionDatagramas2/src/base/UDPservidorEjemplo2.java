package base;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPservidorEjemplo2 {

	public static void main(String[] args) throws IOException {
		//ASOCIO EL SOCKET AL PUERTO 12345
		DatagramSocket socket = new DatagramSocket(12345);
		
		//ESPERANDO DATAGRAM
		System.out.println("Servidor esperando datagrama.......");
		DatagramPacket recibo;
		
		byte[] bufer = new byte[1024];
		recibo = new DatagramPacket(bufer, bufer.length);
		socket.receive(recibo);//RECIBO DATAGRAMA
		
		String mensaje = new String(recibo.getData()).trim();
		System.out.println("Servidor recibe: "+ mensaje);
		
		//CONTAR EL NÚMERO DE LETRAS a
		int contador = 0;
			for (int i = 0; i < mensaje.length(); i++) {
				if(mensaje.charAt(i)=='a') {
					contador++;
				}
			}
			//DIRECCION ORIGEN DEL MENSAJE
			InetAddress IPOrigen = recibo.getAddress();
			int puerto = recibo.getPort();
			
			//ENVIANDO DATAGRAMA AL CLIENTE
			System.out.println("Enviando número de apariciones de la letra a => "+contador);
			byte b = (byte) contador; //paso entero a byte
			byte [] enviados = new byte[1024];
			enviados[0] = b;
			
			DatagramPacket envio = new DatagramPacket (enviados, enviados.length, IPOrigen, puerto);
			socket.send(envio);
			//CERRAR SOCKET
			System.out.println("Cerrando conexión...");
			socket.close();
	}

}
