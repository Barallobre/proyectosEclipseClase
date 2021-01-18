package base;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Primero.*;

public class InsertarRegistro {
	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.obtenSessionFactory();
		try {

			Session sesion = null;
			sesion = sesionFactory.openSession();

			Transaction transaccion = sesion.beginTransaction();
			System.out.println("Inserto una fila (un registro) en la tabla deClientes");
			try {

				Clientes cli = new Clientes();
				cli.setDni(99999999);
				cli.setNombreRazonSocial("Pau Gasol");
				cli.setDireccion("Barcelona");
				sesion.save(cli);

				transaccion.commit();
			} catch (Exception e1) {
				try {
					transaccion.rollback();
					System.out.println("No se ha podido insertar la fila en la tabla de Clientes");
				} catch (Exception e2) {
					System.out.println("Error al insertar el registro y recuperar el estado anterior");
				}
			} finally {

				if (sesion != null)
					sesion.close();
			}
		} catch (Exception e3) {
			System.out.println("Problemas durante la sesión de trabajo.");
		} finally {

			SessionFactoryUtil.cierraSessionFactory();
		}
	}
}
