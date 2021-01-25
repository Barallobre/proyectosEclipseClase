package base;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException {
		int Puerto = 6000;
		ServerSocket Servidor = new ServerSocket(Puerto);
		
		System.out.println("Escuchando en Puerto: 6000");
		
		Socket cliente1 = Servidor.accept();
		
		Socket cliente2 = Servidor.accept();
		
		
		
		Servidor.close();
	}

}
