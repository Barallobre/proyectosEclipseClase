package base;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Principal {

	public static void main(String[] args) {
		Alumno alu1 = new Alumno(4,"Pepe","DAM");
//		Alumno alu2 = new Alumno(2,"Eva","DAM");
//		Alumno alu3 = new Alumno(3,"Luis","DAM");
		
		ODB	odb = ODBFactory.open("Alumnos.db");
		
		IQuery consulta = new CriteriaQuery(Alumno.class, Where.equal("numAlumno", 4));
		Objects<Alumno> lista2 = odb.getObjects(consulta);
		if(!lista2.hasNext()) {
			odb.store(alu1);
		}else {
			System.out.println("El alumno ya existe.");
		}
		
		
//		odb.store(alu2);
//		odb.store(alu3);
		
		
		Objects<Alumno> lista = odb.getObjects(Alumno.class);
		while(lista.hasNext()) {
			Alumno alu = lista.next();
			System.out.println(alu.getNombre()+" "+alu.getCiclo());
		}
		odb.close();
	}

}
