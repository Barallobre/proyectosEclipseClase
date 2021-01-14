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
//Hibernate. Es decir, inicio una sesión (unidad de trabajo para un
//almacén de datos concreto).
			Session sesion = null;
			sesion = sesionFactory.openSession();
//Inicio la transacción.
			Transaction transaccion = sesion.beginTransaction();
			System.out.println("Inserto una fila (un registro) en la tabla deClientes");
			try {
//Código de persistencia: creo cli, una instancia transitoria de
//Clientes, y la convierto en persistente cuando la grabo en la
//la BD mediante el método save(). (Ver explicación al final).
				Clientes cli = new Clientes();
				cli.setDni(99999999);
				cli.setNombreRazonSocial("Pau Gasol");
				cli.setDireccion("Barcelona");
				sesion.save(cli);
//Valido la transacción; si tuviera que deshacerla, utilizaría
//el método rollback().
				transaccion.commit();
			} catch (Exception e1) {
				try {
					transaccion.rollback();
					System.out.println("No se ha podido insertar la fila en la tabla de Clientes");
				} catch (Exception e2) {
					System.out.println("Error al insertar el registro y recuperar el estado anterior");
				}
			} finally {
//Tras completar la transacción, finalizo la sesión.
				if (sesion != null)
					sesion.close();
			}
		} catch (Exception e3) {
			System.out.println("Problemas durante la sesión de trabajo.");
		} finally {
//Tras finalizar, con o sin errores en la sesión, cierro la 'fábrica
//de sesiones'
			SessionFactoryUtil.cierraSessionFactory();
		}
	}
}
