/*
 * Nombre: Cristian Barallobre Rúa
 * DNI: 53306579P
 */

package base;

public class Principal {

	static int NUM_PROCESOS = 10;

	public static void main(String[] args) {
		Pastelero pasteleros[] = new Pastelero[NUM_PROCESOS];
		Cliente clientes[] = new Cliente[NUM_PROCESOS];
		// Creamos solo una instancia de la bandeja de magdalenas, ya que todos
		// repondran o
		// cogeran de la misma
		Magdalenas bandeja = new Magdalenas();

		// Crear los pasteleros y asignarles la bandeja
		for (int i = 0; i < NUM_PROCESOS; i++) {
			pasteleros[i] = new Pastelero(bandeja, i);
		}
		// Crear los clientes y asignarles la bandeja
		for (int i = 0; i < NUM_PROCESOS; i++) {
			clientes[i] = new Cliente(bandeja, i);
		}
		// Iniciamos el proceso de los pasteleros
		for (int i = 0; i < NUM_PROCESOS; i++) {
			pasteleros[i].start();
		}
		// Iniciamos el proceso de los clientes
		for (int i = 0; i < NUM_PROCESOS; i++) {
			clientes[i].start();
		}
	}
}
