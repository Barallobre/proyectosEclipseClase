package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ficheros131 {

	public static void main(String[] args) {
		int valor = 0;
		try {
			FileReader fich = new FileReader("aviso.txt");
			while ((valor=fich.read()) != -1) {
				System.out.print((char)valor);
			}
			fich.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
