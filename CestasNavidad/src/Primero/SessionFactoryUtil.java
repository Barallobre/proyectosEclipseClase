package Primero;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryUtil {
	private static SessionFactory miSessionFactory = null;

	private static SessionFactory miSessionFactory() {
		try {
			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // carga el
																										// fichero de
																										// configuraci�n
																										// hibernate.cfg.xml
					.build();
			try {
				// Tras inicializar la configuraci�n, se crea la SessionFactory (f�brica
				// de sesiones). Normalmente se crea solo una vez en la aplicaci�n y
				// sirve para generar todas las sesiones necesarias en la aplicaci�n.
				miSessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			} catch (Exception e) {
				// El registry deber�a ser destruido por SessionFactory, pero si tuvimos
// problemas construyendo la SessionFactory, deberemos destruirlo a mano
				StandardServiceRegistryBuilder.destroy(registry);
			}
			return miSessionFactory;
		} catch (HibernateException e) {
			System.out.println("Error al iniciar Hibernate");
			return null;
		}
	}

	public static SessionFactory obtenSessionFactory() {
		return miSessionFactory();
	}

	public static void cierraSessionFactory() {
		if (miSessionFactory != null)
			miSessionFactory.close();
	}
}
