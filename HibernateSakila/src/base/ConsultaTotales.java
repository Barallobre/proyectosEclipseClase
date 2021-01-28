package base;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Primero.Actor;
import Primero.SessionFactoryUtil;

public class ConsultaTotales {

	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.obtenSessionFactory();
		
		Session sesion = null;
		try {
			sesion =sesionFactory.openSession();
			
			Query consulta = sesion.createQuery("select count(actorId) from Actor");
			
			long total = (long)consulta.uniqueResult();
			
			consulta = sesion.createQuery("select max(actorId) from Actor");
			short total2 = (short) consulta.uniqueResult();
			System.out.println(total);
			System.out.println(total2);
		} catch (HibernateException e) {
			System.out.println("Error");
		}finally {
			if (sesion!=null) {
				sesion.close();
				SessionFactoryUtil.cierraSessionFactory();
			}
		}
	}

}
