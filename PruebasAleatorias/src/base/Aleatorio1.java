package base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Aleatorio1 {

	public static void main(String[] args) {
		
		try {
			RandomAccessFile rf = new RandomAccessFile("aleat1.dat","rw");
			String[] nombre = {"Pepe","Eva","Luis"};
			byte[] edad = {24,25,26};
			
			rf.writeUTF(nombre[0]);
			rf.writeByte(edad[0]);
			rf.close();
			
			rf = new RandomAccessFile("aleat1.dat","r");
			System.out.println(rf.getFilePointer());
			System.out.println(rf.readUTF());
			System.out.println(rf.getFilePointer());
			System.out.println(rf.readByte());
			System.out.println(rf.getFilePointer());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error al crear el fichero");
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Error al grabar datos");
		}
	}

}
