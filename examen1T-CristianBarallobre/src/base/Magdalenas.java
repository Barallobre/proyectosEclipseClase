/*
 * Nombre: Cristian Barallobre Rúa
 * DNI: 53306579P
 */
package base;

import java.util.concurrent.Semaphore;

public class Magdalenas {
	//declaramos un semaforo en la sección crítica con el que controlaremos quien podrá hacer a ella
	Semaphore semaforo;
	//creo un semáforo para controlar quien accede a la sección critica que en este caso será la bandeja de magdalenas
	Magdalenas(){
		this.semaforo = new Semaphore(1);
	}
	//con los métodos tryAcquire trato de hacerme con el control de la bandeja, un método será usados por los clientes y otro por los pasteleros
	public boolean cogerYComer() {
		return semaforo.tryAcquire();
	}
	public boolean reponer() {
		return semaforo.tryAcquire();
	}
	//con el release dejamos libre el recuros (la bandeja)
	public void soltar(){
		semaforo.release();
	}
}
