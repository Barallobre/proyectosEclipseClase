package base;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPEjemploCliente {

	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6000;
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket Cliente = new Socket(Host,Puerto);
		
		//CREO FLIJO DE SALIDA AL SERVIDOR
		DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
		
		//ENVIO UN SALUDO AL SERVIDOR 
		flujoSalida.writeUTF("Saludos al SERVIDOR DESDE CLIENTE");
		
		//CREO FLUJO DE ENTRADA AL SERVIDOR
		DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
		
		//EL SERVIDOR ME ENVÍA UN MENSAJE
		System.out.println("Recibiendo del SERVIDOR: \n\t "+ flujoEntrada.readUTF());
		
		//CERRAMOS STREAMS Y SOCKETS
		flujoEntrada.close();
		flujoSalida.close();
		Cliente.close();
	}

}
