package base;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPObjetoServidor1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		int numeroPuerto = 6000; //Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		
		System.out.println("Esperando cliente...");
		Socket cliente = servidor.accept();
		
		//Se prepara un flujo de salida para objetos
		ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
		
		//Se prepara un objeto y se envía
		Cosa per = new Cosa ("Granito",2000);
		outObjeto.writeObject(per);//enviando objeto
		System.out.println("Envio: "+per.getMaterial() + "*"+per.getAntiguedad());
		
		//Se obtiene un stream para leer objetos
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		Cosa dato = (Cosa) inObjeto.readObject();
		
		System.out.println("Recibido: "+dato.getMaterial()+"*"+dato.getAntiguedad());
		
		//CERRAR STREAMS Y SOCKETS
		outObjeto.close();
		inObjeto.close();
		cliente.close();
		servidor.close();
	}

}
