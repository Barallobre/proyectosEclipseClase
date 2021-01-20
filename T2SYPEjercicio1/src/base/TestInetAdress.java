package base;
import java.net.*;
import java.util.Scanner;
public class TestInetAdress {
static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		InetAddress dir = null;
		System.out.println("---------------------------------");
		System.out.println("Salida para localhost: ");
		try {
			//localhost
			String direccion;
			System.out.println("Introduzca una direccion");
			direccion = sc.nextLine();
			dir = InetAddress.getByName(direccion);
			pruebaMetodos(dir);
			
			//URL www.google.es
			System.out.println("-----------------------------");
			System.out.println("Salida para una URL: ");
			dir = InetAddress.getByName("www.google.es");
			pruebaMetodos(dir);
			
			//Array de tipo InetAdress con todas las direcciones IP asignadas a google.es
			System.out.println("\tDIRECCIONES IP PARA: "+ dir.getHostName());
			InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
			for (int i = 0; i < direcciones.length; i++) {
				System.out.println("\t\t"+direcciones[i].toString());
				
			}
			System.out.println("---------------------------------------------");
			
		} catch (UnknownHostException 	e) {	
			e.printStackTrace();
		}
		
	}//main
	
	private static void pruebaMetodos(InetAddress dir) {
		System.out.println("\tMetodo getLocalHost(): "+ dir);
		InetAddress dir2;
		try {
		dir2 = InetAddress.getLocalHost();
		System.out.println("\tMetodo getLocalHost(): "+ dir2);
		}catch (UnknownHostException e) {
			e.printStackTrace();
		}
		//USAMOS METODOS DE LA CLASE
		System.out.println("\tMetodo getHostName():" + dir.getHostName());
		System.out.println("\tMetodo getHostAdress()"+ dir.getHostAddress());
		System.out.println("\tMetodo toString() "+ dir.toString());
		System.out.println("\tMetodo getCanonicalHostName(): "+ dir.getCanonicalHostName());
	}//pruebaMetodos
}//Fin
