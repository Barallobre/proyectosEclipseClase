package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ficheros132 {

	public static void main(String[] args) {
		int valor = 0;
		try {
			FileReader fich = new FileReader("chiquito.txt");

			char cbuf[] = new char[30];
			while ((valor = fich.read(cbuf, 0, 30)) != -1) {
				System.out.println(cbuf);
			}

			fich.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
