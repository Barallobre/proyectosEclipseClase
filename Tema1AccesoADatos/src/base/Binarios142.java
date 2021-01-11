package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Binarios142 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		DataOutputStream datos = null;
		try {

			String fichero = null;
			FileOutputStream conexion = new FileOutputStream(fichero);

			datos = new DataOutputStream(conexion);

			String nombres[] = { "Estela", "Fran", "Manuel", "Martín", "Geli" };
			int edades[] = { 20, 19, 21, 22, 101 };

			for (int i = 0; i < nombres.length; i++) {
				datos.writeUTF(nombres[i]);
				datos.writeInt(edades[i]);
			}

		} catch (IOException e) {
			e.getMessage();
		} finally {
			if (datos != null)
				try {
					datos.close();
				} catch (IOException e) {
					e.getMessage();
				}
		}
		
	}
}

