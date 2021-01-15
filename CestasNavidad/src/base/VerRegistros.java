package base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Primero.Clientes;
import Primero.SessionFactoryUtil;

public class VerRegistros {

	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.obtenSessionFactory();
		Session sesion = null;
		try {

			
			sesion = sesionFactory.openSession();
			
			Clientes cli = new Clientes();
			cli = sesion.load(Clientes.class, 99999999);
			if(cli!=null) {
			System.out.println("Nombre del cliente: "+ cli.getNombreRazonSocial());
			}else {
				System.out.println("Alumno no encontado");
			}
			
	
	} catch (Exception e3) {
		System.out.println("Problemas durante la sesión de trabajo.");
	} finally {
		if(sesion != null)
			sesion.close();
		SessionFactoryUtil.cierraSessionFactory();
	}
 }
}