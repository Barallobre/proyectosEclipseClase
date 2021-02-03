package Primero;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//import org.hibernate.HibernateException;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryUtil {
	
    private static SessionFactory miSessionFactory = null;
	
	private static SessionFactory miSessionFactory() {
		try {
			//De este modo solo se mostrarán los mensajes cuyo nivel de error sea
			//mayor o igual que SEVERE. Para ver errores de menor importancia, se
			//puede cambiar el valor SEVERE por WARNING.
			Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			        .configure() // carga el fichero de configuración hibernate.cfg.xml
			        .build();
			try {
			    // Tras inicializar la configuración, se crea la SessionFactory (fábrica
		        // de sesiones). Normalmente se crea solo una vez en la aplicación y 
			  	// sirve para generar todas las sesiones necesarias en la aplicación.
			    miSessionFactory = new MetadataSources(registry).buildMetadata() 
					.buildSessionFactory();
			}
			catch (Exception e) {
				e.printStackTrace();
			    // El registry debería ser destruido por SessionFactory, pero si tuvimos
				// problemas construyendo la SessionFactory, deberemos destruirlo a mano
			    StandardServiceRegistryBuilder.destroy(registry);
			}
			return miSessionFactory;
		}catch (HibernateException e) {
			e.printStackTrace();
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

