package base;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPObjetoCliente1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		String Host = "localhost";
		int Puerto = 6000;//puerto remoto
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket cliente = new Socket(Host, Puerto);
		
		//Flujo de entrada para objetos
		ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());
		
		//Se recibe un objeto
		Cosa dato = (Cosa) perEnt.readObject();
		System.out.println("Recibo: "+ dato.getMaterial()+"*"+dato.getAntiguedad());
		
		//Modifico el objeto
		dato.setMaterial("Marmol");
		dato.setAntiguedad(1000);
		
		//FLUJO DE salida para objetos
		ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
		
		//Se envía el objeto
		perSal.writeObject(dato);
		System.out.println("Envío: "+dato.getMaterial()+"*"+dato.getAntiguedad());
		
		//CERRAR STREAMS Y SOCKETS
		perEnt.close();
		perSal.close();
		cliente.close();
	}

}
