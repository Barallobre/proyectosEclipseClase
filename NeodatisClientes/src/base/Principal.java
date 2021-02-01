package base;

import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Principal {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ODB odb = ODBFactory.open("Clientes.db");
		Menu(odb);
	}

	public static void Menu(ODB odb) {
		int opcMenu;
		do {
		System.out.println(
				"\nEscoja una opción del menú: \n1.- Listar Clientes\n2.- Agregar Cliente\n3.- Eliminar Cliente\n4.- Modificar Cliente\n5.- Salir");
		opcMenu = sc.nextInt();
		if(opcMenu<1 || opcMenu>5) {
			System.out.println("Introduzca un número correcto.");
		}
		}while(opcMenu<1 || opcMenu>5);
		switch (opcMenu) {
		case 1:
			listarClientes(odb);
			break;
		case 2:
			agregarCliente(odb);
			break;
		case 3:
			eliminarCliente(odb);
			break;
		case 4:
			modificarCliente(odb);
			break;
		case 5:
			salir(odb);
			break;
		}
		Menu(odb);
	}

	public static void modificarCliente(ODB odb) {
		int numero;
		System.out.println("Introduzca número cliente para modificar: ");
		numero = sc.nextInt();
		IQuery consulta = new CriteriaQuery(Cliente.class, Where.equal("num_cli", numero));
		Objects<Cliente> lista2 = odb.getObjects(consulta);

		if (!lista2.hasNext()) {
			System.out.println("El cliente no existe.");
		} else {
			Cliente cli = (Cliente) lista2.getFirst();
			int opc;
			do {
			System.out.println("Qué quiere modificar?\n1. Nombre\n2. Dirección");
			opc = sc.nextInt();
			switch (opc) {
			case 1:
				System.out.println("Introduzca nuevo nombre: ");
				String nombre = sc.next();
				cli.setNombre_cli(nombre);
				break;
			case 2:
				System.out.println("Introduzca nueva dirección: ");
				String direccion = sc.next();
				cli.setDireccion_cli(direccion);
				break;
			}
			if(opc<1 || opc>2) {
				System.out.println("Introduzca un número correcto.");
			}
			}while(opc<1 || opc>2);
			odb.store(cli);
		}
	}

	public static void eliminarCliente(ODB odb) {
		int numero;
		System.out.println("Introduzca número cliente para eliminar: ");
		numero = sc.nextInt();
		IQuery consulta = new CriteriaQuery(Cliente.class, Where.equal("num_cli", numero));
		Objects<Cliente> lista2 = odb.getObjects(consulta);

		if (!lista2.hasNext()) {
			System.out.println("El cliente no existe.");
		} else {
			Cliente cli = (Cliente) lista2.getFirst();
			odb.delete(cli);
		}
	}

	public static void agregarCliente(ODB odb) {
		int numero;
		String nombre;
		String direccion;
		System.out.println("Introduzca número cliente para agregar: ");
		numero = sc.nextInt();
		System.out.println("Introduzca nombre cliente para agregar: ");
		nombre = sc.next();
		System.out.println("Introduzca dirección cliente para agregar: ");
		direccion = sc.next();
		Cliente cli = new Cliente(numero, nombre, direccion);

		IQuery consulta = new CriteriaQuery(Cliente.class, Where.equal("num_cli", numero));
		Objects<Cliente> lista2 = odb.getObjects(consulta);
		if (!lista2.hasNext()) {
			odb.store(cli);
		} else {
			System.out.println("El cliente ya existe.");
		}
	}

	public static void listarClientes(ODB odb) {
		Objects<Cliente> lista = odb.getObjects(Cliente.class);
		while (lista.hasNext()) {
			Cliente cli = lista.next();
			System.out.println(cli.getNum_cli() + " - " + cli.getNombre_cli() + " - " + cli.getDireccion_cli());
		}

	}

	public static void salir(ODB odb) {
		odb.close();
		System.out.println("Base de datos cerrada. Saliendo de la aplicación...");
		System.exit(0);
	}
}
