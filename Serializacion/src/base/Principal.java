package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Principal {

	public static void main(String[] args) {
		Coche coche1 = new Coche("1234DGT", "Corolla Verso", 20000);
		String ruta = "coches.dat";
		try {
//			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ruta));
//			os.writeObject(coche1);
//			os.close();

			ObjectInputStream is = new ObjectInputStream(new FileInputStream(ruta));
			Coche miCoche = (Coche) is.readObject();
			System.out.println(miCoche.getDatos());
			is.close();

		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("Error al acceder al fichero");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al leer el fichero de coches.");
		}
	}
}
