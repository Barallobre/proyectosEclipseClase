package base;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Primero.Clientes;
import Primero.SessionFactoryUtil;

public class ConsultaClientes {

	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.obtenSessionFactory();
		
		Session sesion = null;
		try {
			sesion =sesionFactory.openSession();
			
			Query <Clientes> consulta = sesion.createQuery("from clientes order by DNI asc", Clientes.class);
			List <Clientes> lista = consulta.list();
			for (int i=0;i<lista.size();i++) {
				System.out.println(lista.get(i).getDni()+" - "+lista.get(i).getNombreRazonSocial());
				
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