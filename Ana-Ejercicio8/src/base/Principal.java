/*
 * Implementacion del problema de los filosofos en Java
 * solución con semaforos
  */

package base;


public class Principal {

	static int NUM_FILOSOFOS = 5;
	
	public static void main(String[] args) {
		Palillo palillos[] = new Palillo[NUM_FILOSOFOS];
		Filosofo filosofos[] = new Filosofo[NUM_FILOSOFOS];
		
		int fil_izquierda = 0;
		
		// Crear los palillos
		for (int i = 0; i < NUM_FILOSOFOS; i++){
			palillos[i] = new Palillo(i+1);
		}
		
		// Crear los fil—sofos y asignarles los palillos
		for (int i = 0; i < NUM_FILOSOFOS; i++){
			if (i == 0)
				fil_izquierda = NUM_FILOSOFOS-1;
			else
				fil_izquierda = i-1;
			
			filosofos[i] = new Filosofo(palillos[fil_izquierda], palillos[i], i+1);
		}
		
		// Crear los fil—sofos y asignarles los palillos
		for (int i = 0; i < NUM_FILOSOFOS; i++){
			filosofos[i].start();
		}
	}

}

