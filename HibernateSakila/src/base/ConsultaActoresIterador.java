package base;



import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Primero.Actor;
import Primero.SessionFactoryUtil;

public class ConsultaActoresIterador {

	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.obtenSessionFactory();
		
		Session sesion = null;
		try {
			sesion =sesionFactory.openSession();
			Actor act = new Actor();
			Query<Actor> consulta = sesion.createQuery("from Actor order by lastName asc", Actor.class);
			List <Actor> lista = consulta.list();
			Iterator <Actor> iterator = lista.iterator();
			consulta.setFetchSize(20);
			while(iterator.hasNext()) {
				act = (Actor) iterator.next();
				System.out.println(act.getActorId() + " - "+ act.getFirstName());
			}
			for (int i=0;i<lista.size();i++) {
				System.out.println(lista.get(i).getActorId()+" - "+lista.get(i).getFirstName());
				
			}
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
