package base;



import java.util.Iterator;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import Primero.SessionFactoryUtil;

public class ModificaClientes {

	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.obtenSessionFactory();
		
		Session sesion = null;
		Transaction transaccion = null;
		try {
			sesion =sesionFactory.openSession();
			 transaccion = sesion.beginTransaction();
			Query SENTENCIA = sesion.createQuery("update Clientes set Direccion = 'Coristanco' where DNI = '11111111'");
			int numRegsModificados = SENTENCIA.executeUpdate();
			System.out.println("Se han modificado: "+ numRegsModificados +" registros.");
			transaccion.commit();
		} catch (HibernateException e) {
			transaccion.rollback();
			System.out.println("Error");
		}finally {
			if (sesion!=null) {
				sesion.close();
				SessionFactoryUtil.cierraSessionFactory();
			}
		}
	}

}
