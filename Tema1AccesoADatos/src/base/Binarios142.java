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
		
		
		/*--------------------------------------------------------------*/
		DataInputStream datos2 = null;

		int contador;

		try {
			
			String nombres1;
			int edades1;
			FileInputStream conexion = new FileInputStream(fichero);
			datos2 = new DataInputStream(conexion);
			int i = 0;
			while ((contador = datos2.read()) != -1) {
				String[] nombres= {" "};
				int[] edades= {};
				nombres1 = datos2.readUTF();
				edades1 = datos2.readInt();
				nombres[i]=nombres1;
				System.out.println(nombres[i]);
				edades[i]=edades1;
				System.out.println(edades[i]);
				i++;
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

