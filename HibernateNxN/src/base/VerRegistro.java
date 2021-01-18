package base;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Primero.Alumnos;
import Primero.Modulos;
import Primero.SessionFactoryUtil;

public class VerRegistro {

	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.obtenSessionFactory();
		Session sesion = null;
		try {
			
			sesion = sesionFactory.openSession();
			
			Alumnos alu = new Alumnos();
			alu = sesion.get(Alumnos.class, 1);
			if(alu==null) {
				System.out.println("No existe el alumno");
				
			}
			else {
				System.out.println("Nombre del alumno: "+ alu.getNombre());
				System.out.println("Módulos del alumno: "+ alu.getNombre());
				for (Iterator it = alu.getModuloses().iterator(); it.hasNext();) {
					Modulos mod = (Modulos) it.next();
					System.out.println(mod.getModulo());
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
