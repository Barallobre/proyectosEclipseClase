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
//Obtengo un objeto Session utilizando la clase SessionFactory de
//Hibernate. Es decir, inicio una sesi�n (unidad de trabajo para un
//almac�n de datos concreto).
			Session sesion = null;
			sesion = sesionFactory.openSession();
//Inicio la transacci�n.
			Transaction transaccion = sesion.beginTransaction();
			System.out.println("Inserto una fila (un registro) en la tabla deClientes");
			try {
//C�digo de persistencia: creo cli, una instancia transitoria de
//Clientes, y la convierto en persistente cuando la grabo en la
//la BD mediante el m�todo save(). (Ver explicaci�n al final).
				Clientes cli = new Clientes();
				cli.setDni(99999999);
				cli.setNombreRazonSocial("Pau Gasol");
				cli.setDireccion("Barcelona");
				sesion.save(cli);
//Valido la transacci�n; si tuviera que deshacerla, utilizar�a
//el m�todo rollback().
				transaccion.commit();
			} catch (Exception e1) {
				try {
					transaccion.rollback();
					System.out.println("No se ha podido insertar la fila en la tabla de Clientes");
				} catch (Exception e2) {
					System.out.println("Error al insertar el registro y recuperar el estado anterior");
				}
			} finally {
//Tras completar la transacci�n, finalizo la sesi�n.
				if (sesion != null)
					sesion.close();
			}
		} catch (Exception e3) {
			System.out.println("Problemas durante la sesi�n de trabajo.");
		} finally {
//Tras finalizar, con o sin errores en la sesi�n, cierro la 'f�brica
//de sesiones'
			SessionFactoryUtil.cierraSessionFactory();
		}
	}
}
