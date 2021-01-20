package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ejemplo2URL3 {

	public static void main(String[] args) {
		URL url = null;
		URLConnection urlCon = null;
		try {
			url = new URL("https://www.xataka.com");
			urlCon = url.openConnection();
		BufferedReader in;
	
			InputStream inputStream = urlCon.getInputStream();
			in = new BufferedReader ( new InputStreamReader (inputStream));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();
	}catch(MalformedURLException e) {
		System.out.println(e);
	}catch (IOException e) {
			e.printStackTrace();
		}

	}
}