package base;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class InsertaPaises {
	public static void main(String[] args) {
		Pais p1 = new Pais(1,"España");
		Pais p2 = new Pais(2,"Argentina");
		Pais p3 = new Pais(3,"Brasil");

		ODB odb = ODBFactory.open("Paises.bd");

		odb.store(p1);
		odb.store(p2);
		odb.store(p3);


		Objects<Pais> objetos = odb.getObjects(Pais.class);
		System.out.println("Nº de paises: " + objetos.size());

		
		while (objetos.hasNext()) {
			Pais pais = objetos.next();
			System.out.println( pais.getNumpais() + "-" + pais.getNombrepais());
					
		}

		odb.close();
	}
}