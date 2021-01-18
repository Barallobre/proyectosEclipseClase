package base;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Primero.Alumnos;
import Primero.Modulos;
import Primero.SessionFactoryUtil;

public class VerModuloAlumnos {

	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.obtenSessionFactory();
		Session sesion = null;
		try {
			
			sesion = sesionFactory.openSession();
			
			Modulos mod = new Modulos();
			mod = sesion.get(Modulos.class,"Acceso a datos" );
			if(mod==null) {
				System.out.println("No existe el alumno");
				
			}
			else {
				System.out.println("Nombre del alumno: "+ mod.getAlumnoses());
				System.out.println("Módulos del alumno: "+ mod.getModulo());
				for (Iterator it = mod.getAlumnoses().iterator(); it.hasNext();) {
					Alumnos alu = (Alumnos) it.next();
					System.out.println(alu.getNombre());
				}
					
				}
		} catch (Exception e3) {	
			System.out.println("Problemas durante la sesión de trabajo.");
		} finally {
			if (sesion != null)
				sesion.close();
			SessionFactoryUtil.cierraSessionFactory();
		}

	}

}
