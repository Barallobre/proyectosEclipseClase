package base;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class InsertaJugadores {
	public static void main(String[] args) {
//		Jugador j1 = new Jugador("Diego", "fútbol", "Cambre", 22);
//		Jugador j2 = new Jugador("Pablo", "tenis", "Coruña", 23);
//		Jugador j3 = new Jugador("Felipe", "baloncesto", "Cambre", 25);
//		Jugador j4 = new Jugador("Belén", "tenis", "Coruña", 21);

		ODB odb = ODBFactory.open("Jugadores.test");

//		odb.store(j1);
//		odb.store(j2);
//		odb.store(j3);
//		odb.store(j4);

		Objects<Jugador> objetos = odb.getObjects(Jugador.class);
		System.out.println("Nº de jugadores: " + objetos.size());

		int i = 1;
		while (objetos.hasNext()) {
			Jugador jug = objetos.next();
			System.out.println((i++) + "-" + jug.getNombre() + "-" + jug.getDeporte() + "-" + jug.getCiudad() + "-"
					+ jug.getEdad());
		}
		
		
		IQuery consulta = new CriteriaQuery(Jugador.class, Where.equal("num_cli", numero));
		Objects<Jugador> lista2 = odb.getObjects(consulta);
		Jugador jug = (Jugador) lista2.getFirst();
		if (!lista2.hasNext()) {
			jug.setPais();
		} 
		
		paises();
		odb.close();
	}

	public static void paises() {
//		Pais p1 = new Pais(1,"España");
//		Pais p2 = new Pais(2,"Argentina");
//		Pais p3 = new Pais(3,"Brasil");

		ODB odb = ODBFactory.open("Paises.bd");
//
//		odb.store(p1);
//		odb.store(p2);
//		odb.store(p3);

		Objects<Pais> objetos = odb.getObjects(Pais.class);
		System.out.println("\nNº de paises: " + objetos.size());

		while (objetos.hasNext()) {
			Pais pais = objetos.next();
			System.out.println(pais.getNumpais() + "-" + pais.getNombrepais());

		}
		Values valores = odb.getValues(
				new ValuesCriteriaQuery(Jugador.class).field("nombre").field("ciudad").field("pais.nombrepais"));
		while (valores.hasNext()) {
			ObjectValues objectValues = (ObjectValues) valores.next();
			System.out.println(objectValues.getByAlias("nombre") + ", ciudad: " + objectValues.getByIndex(1)
					+ ", país: " + objectValues.getByIndex(2));
		}
		odb.close();
	}
}