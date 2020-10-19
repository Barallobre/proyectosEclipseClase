package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class binarios141 {

	public static void main(String[] args) {
		try {
			FileInputStream origen = new FileInputStream("C:\\Users\\Usuario\\Desktop\\origen.jpg");
			FileOutputStream destino = new FileOutputStream("C:\\Users\\Usuario\\Desktop\\destino.jpg");
			int lectura;
			while ((lectura = origen.read()) != -1) {
				destino.write(lectura);
			}
			origen.close();
			System.out.println("Copiado terminado.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
