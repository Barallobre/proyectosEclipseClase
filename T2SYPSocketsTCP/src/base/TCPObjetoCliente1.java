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
		Persona dato = (Persona) perEnt.readObject();
		System.out.println("Recibo: "+ dato.getNombre()+"*"+dato.getEdad());
		
		//Modifico el objeto
		dato.setNombre("Juan Ramos");
		dato.setEdad(22);
		
		//FLUJO DE salida para objetos
		ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
		
		//Se envía el objeto
		perSal.writeObject(dato);
		System.out.println("Envío: "+dato.getNombre()+"*"+dato.getEdad());
		
		//CERRAR STREAMS Y SOCKETS
		perEnt.close();
		perSal.close();
		cliente.close();
	}

}
