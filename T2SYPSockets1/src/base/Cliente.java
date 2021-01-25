package base;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;


public class Cliente {

	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6000;
		
		Socket Cliente = new Socket(Host, Puerto);
		
		InetAddress i = Cliente.getInetAddress();
		System.out.println("Puerto local: "+ Cliente.getLocalPort());
		System.out.println("Puerto Remoto: "+ Cliente.getPort());
		System.out.println("Nombre Host/IPO: "+ Cliente.getInetAddress());
		System.out.println("Host Remoto: "+ i.getHostName().toString());
		System.out.println("IP Host Remoto: "+i.getHostAddress().toString());
		
		Cliente.close();
	}

}
