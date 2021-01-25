package base;



import java.util.Iterator;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Primero.Actor;
import Primero.SessionFactoryUtil;

public class BorrarActores {

	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.obtenSessionFactory();
		
		Session sesion = null;
		Transaction transaccion = null;
		try {
			sesion =sesionFactory.openSession();
			transaccion = sesion.beginTransaction();
			Query SENTENCIA = sesion.createQuery("delete from FilmActor where actor < 7 ");
			SENTENCIA.executeUpdate();
			Query SENTENCIA2 = sesion.createQuery("delete from Actor where actorId < 7");
			int numRegsBorrados = SENTENCIA2.executeUpdate();
			System.out.println("Se han modificado: "+ numRegsBorrados +" registros.");
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
