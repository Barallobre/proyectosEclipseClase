/*
 Realizar una aplicaci�n en java para lectura y escritura de un fichero de texto. 
 El objetivo es partir de un documento de texto en el que se incluyen los datos de los socios del gimnasio musculitos.com . 
 Para almacenar las cuotas de pago, el fichero incluir� la siguiente informaci�n: 
-	N�mero de socio.
-	Nombre completo.
-	Tel�fono.
-	Email.
-	Fecha de alta.
-	Tarifa.
Han de ser todos datos validados. Esta estructura de socio deber� estar definida en su clase correspondiente, 
que le permitir� interactuar con el fichero de datos. A medida que se vayan dando de alta los socios se a�adir�n al final del fichero. 
Y se mantendr�n el resto de datos de socios dados de alta anteriormente. La aplicaci�n para poder realizar estas acciones ha de incluir el siguiente men�:
-	Alta de socio.
-	Mostrar listado de socios.
-	Editar el tel�fono del socio localiz�ndolo por n�mero de socio.
-	Mostrar la ficha de un socio en concreto localizado a trav�s del n�mero de socio.
-	Salir.

 */
package base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Principal {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Socio> listaSocios = new ArrayList<Socio>();

	/* Men� principal de la aplicaci�n */
	public static void menu() {
		int opc = 0;
		final int topeOpc = 4;
		do {
			System.out.println("1. Alta de socio");
			System.out.println("2. Mostrar listado de socios");
			System.out.println("3. Editar tel�fono de socio");
			System.out.println("4. Mostrar ficha de socio a trav�s de n�mero de socio");
			System.out.println("5. Salir.");
			opc = sc.nextInt();
			if (opc < 1 || opc > topeOpc) {
				System.out.println("Escoja una opci�n correcta.");
			}
		} while (opc < 1 || opc > topeOpc);
		switchMenu(opc);
	}

	/* M�todo switch del men� principal */
	public static void switchMenu(int opc) {
		switch (opc) {
		case 1:
			darAltaSocio();
			break;
		case 2:
			mostrarListadoSocios();
			break;
		case 3:
			editarTelefonoSocio();
			break;
		case 4:
			mostrarFichaPorNumeroSocio();
			break;
		case 5:
			salir();
			break;
		}
		menu();
	}

	/* M�todo para dar de alta un socio dentro de un fichero */
	public static void darAltaSocio() {
		String nombreFichero = pedirNombreFichero("fichero origen");

		try {
			String lineaSocio = "";

			BufferedWriter bwFicheroSalida = new BufferedWriter(new FileWriter(nombreFichero, true));

			System.out.println("--->> Pulse intro para introducir una ficha de Socio: ");
			sc.nextLine();

			lineaSocio = altaSocio();

			bwFicheroSalida.write(lineaSocio);

			bwFicheroSalida.newLine();

			bwFicheroSalida.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Escritura completada.");
	}

	/* M�todo para indicar el nombre del fichero donde vamos a escribir */
	public static String pedirNombreFichero(String mensaje) {
		String nombreFichero;
		boolean existeFichero = true;

		sc.nextLine();
		do {
			existeFichero = true;
			System.out.println("Introduce el nombre del " + mensaje + ": ");
			nombreFichero = sc.nextLine();
			if (!new File(nombreFichero).exists()) {
				System.out.println("No he encontrado: " + nombreFichero);
				existeFichero = false;
			}
		} while (!existeFichero);
		return nombreFichero;
	}

	/* M�todo para dar de alta cada uno de los datos de un socio */
	public static String altaSocio() {

		String numero, nombre;
		String telefono = null;
		String email = null;
		Date fechaAlta = null;
		int tarifa;
		boolean emailValido;
		boolean telefonoValido;
		Socio socioAux = new Socio();
		System.out.println("Introduzca numero: ");
		numero = sc.nextLine();
		System.out.println("Introduzca nombre: ");
		nombre = sc.nextLine();
		do {
			System.out.println("Introduzca telefono: ");
			String telefono1 = sc.nextLine();
			telefonoValido = socioAux.validarTelefono(telefono1);
			if (telefonoValido) {
				telefono = telefono1;
			}
		} while (!telefonoValido);
		do {
			System.out.println("Introduzca email: ");
			String email1 = sc.nextLine();
			emailValido = socioAux.validarEmail(email1);
			if (emailValido) {
				email = email1;
			}
		} while (!emailValido);
		System.out.println("Introduzca fecha de alta: ");
		String fecha;
		boolean correcto = false;
		do {
			try {
				fecha = sc.nextLine();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				sdf.setLenient(false);

				fechaAlta = sdf.parse(fecha);
				correcto = true;
			} catch (ParseException e) {
				System.out.println("=>Error la fecha introducida es incorrecta : " + e.getMessage());
			}
		} while (!correcto);
		System.out.println("Introduzca tarifa: ");
		tarifa = sc.nextInt();

		socioAux = new Socio(numero, nombre, telefono, email, fechaAlta, tarifa);

		String linea = numero + ";" + nombre + ";" + telefono + ";" + email + ";" + fechaAlta + ";" + tarifa;

		return linea;
	}

	/* M�todo para mostrar el listado de socios agregados */
	public static void mostrarListadoSocios() {

		leerFichero();

		for (int i = 0; i < listaSocios.size(); i++) {
			System.out.println(listaSocios.get(i));
		}
		listaSocios.clear();
	}

	/* M�todo para leer el fichero donde est�n guardados los socios */
	public static void leerFichero() {
		String nombreFichero = pedirNombreFichero("fichero");
		System.out.println("Leyendo fichero de texto...");

		try {
			BufferedReader ficheroEntrada = new BufferedReader(new FileReader(nombreFichero));

			// Leemos una l�nea entera
			String linea = ficheroEntrada.readLine();
			int contadorLinea = 1;
			// Bucle que se repite hasta que linea sea null, que es el valor de final de
			// fichero o fichero vac�o
			while (linea != null) {

				// Saltamos la primera linea del fichero porque contiene los titulos de los
				// campos
				if (contadorLinea > 1) {
					// gestionar cada producto que se encuentra en una linea
					// del fichero leo un tipo de dato String -> linea
					// y lo guardo ArrayList<Producto> -> listaProductos
					convertirStringAProducto(linea);
				}
				// Leemos una l�nea entera
				linea = ficheroEntrada.readLine();
				contadorLinea++;
			}

			// Al acabar de leer, se cierra el fichero
			ficheroEntrada.close();

		} catch (EOFException eof) { // control de error al abrir el fichero
			System.out.println("No se puede abrir el fichero " + nombreFichero);
			System.out.println(eof.getMessage());
		} catch (IOException e) { // control de error en lectura o escritura
			System.out.println(e.getMessage());
		}
	}

	/* M�todo para convertir los String del fichero en un arrayList */
	public static void convertirStringAProducto(String linea) {
		String campos[] = linea.split(";");
		String numero = campos[0];
		String nombre = campos[1];
		String telefono = campos[2];
		String email = campos[3];
		Date fechaAlta = ParseFecha(campos[4]);
		int tarifa = Integer.parseInt(campos[5]);

		Socio socioAux = new Socio(numero, nombre, telefono, email, fechaAlta, tarifa);

		listaSocios.add(socioAux);
	}

	/* M�todo para convertir un String a un Date */
	public static Date ParseFecha(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(fecha);
		} catch (ParseException e) {
			System.out.println(e);
		}
		return fechaDate;
	}

	public static void editarTelefonoSocio() {

	}

	public static void mostrarFichaPorNumeroSocio() {

	}

	/* M�todo para salir de la aplicaci�n */
	public static void salir() {
		System.out.println("Saliendo de la aplicaci�n...");
		System.exit(0);
	}

	public static void main(String[] args) {
		menu();

	}

}
