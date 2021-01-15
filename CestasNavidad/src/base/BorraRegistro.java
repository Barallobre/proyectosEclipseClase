package base;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Primero.*;

public class BorraRegistro {
	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.obtenSessionFactory();
		try {

			Session sesion = null;
			sesion = sesionFactory.openSession();

			Transaction transaccion = sesion.beginTransaction();
			int numcli = 99999999;
			System.out.println("Voy a borrar un cliente número: "+numcli);
			
			try {

				Clientes cli = new Clientes();
				cli = sesion.get(Clientes.class, numcli);
				if(cli!=null) {
					sesion.delete(cli);
				}else {
					System.out.println("El cliente no existe.");
				}
				
				transaccion.commit();
			} catch (Exception e1) {
				try {
					transaccion.rollback();
					System.out.println("No se ha podido borrar registro en la tabla de Clientes");
				} catch (Exception e2) {
					System.out.println("Error al borrar el registro y recuperar el estado anterior");
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
