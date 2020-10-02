package base;

import java.io.File;
import java.io.IOException;

public class File121 {

	public static void main(String[] args) {

		// creamos los dos directorios/carpetas con mkdirs()
		new File("./ejerciciosFile/ficheros").mkdirs();

		// con estoy solo declaramos los ficheros no los creamos
		File fich1 = new File("./ejerciciosFile/ficheros/Fichero1.txt");
		File fich2 = new File("./ejerciciosFile/ficheros/Fichero2.txt");
		File File2 = new File("./ejerciciosFile/ficheros/File2.txt");
		
		// ahora creamos los ficheros con el método createNewFile()
		try {
			fich1.createNewFile();
		} catch (IOException e) {
			System.out.println("Error al crear el fichero.");
			System.out.println(e);
		}
		try {
			fich2.createNewFile();
		} catch (IOException e) {
			System.out.println("Error al crear el fichero.");
			e.printStackTrace();
		}
		// comprobamos que existe el fichero1
		System.out.println(fich1.exists() + " -El fichero1 aún no ha sido borrado");

		// borramos el fichero1
		fich1.delete();

		// comprobamos que existe después de borrarlo
		System.out.println(fich1.exists()+" -El fichero1 ha sido borrado");

		// renombramos el Fichero2
		fich2.renameTo(File2);
	}

}
