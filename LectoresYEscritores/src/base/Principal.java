//Hay un objeto de datos(fichero de texto) que es utilizado por varios procesos, unos leen y otro que escribe.
//
//Solo puede utilizar el recurso un proceso y solo uno, es decir, 
//o bien un proceso estará escribiendo o bien leyendo, pero nunca ocurrirá simultáneamente.
//
//Consideraciones:
//
//Se considera a cada usuario(lector y escritor) como dos procesos 
//y al fichero en cuestión como un recurso. 
//De modo que, para que un proceso acceda al recurso que necesita, 
//tenemos que considerar a cada usuario (lector y escritor) como dos semáforos. 
//Estos semáforos son binarios: el recurso (fichero) está siendo utilizado por otro proceso y el recurso está disponible.

package base;


public class Principal {

	static int NUM_PROCESOS = 5;
	
	public static void main(String[] args) {
		Escritor escritores[] = new Escritor[NUM_PROCESOS];
		Lector lectores[] = new Lector[NUM_PROCESOS];
		
		
		
		// Crear los escritores
		for (int i = 0; i < NUM_PROCESOS; i++){
			escritores[i] = new Escritor();
		}
		// Crear los lectores
		for (int i = 0; i < NUM_PROCESOS; i++){
			lectores[i] = new Lector();
		}
		
		// Crear los fil—sofos y asignarles los palillos
		for (int i = 0; i < NUM_PROCESOS; i++){
		
		}
		
		// Crear los fil—sofos y asignarles los palillos
		for (int i = 0; i < NUM_FILOSOFOS; i++){
			lectores[i].start();
			escritores[i].start();
		}
	}

}
