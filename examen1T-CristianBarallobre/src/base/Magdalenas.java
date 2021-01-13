/*
 * Nombre: Cristian Barallobre R�a
 * DNI: 53306579P
 */
package base;

import java.util.concurrent.Semaphore;

public class Magdalenas {
	//declaramos un semaforo en la secci�n cr�tica con el que controlaremos quien podr� hacer a ella
	Semaphore semaforo;
	//creo un sem�foro para controlar quien accede a la secci�n critica que en este caso ser� la bandeja de magdalenas
	Magdalenas(){
		this.semaforo = new Semaphore(1);
	}
	//con los m�todos tryAcquire trato de hacerme con el control de la bandeja, un m�todo ser� usados por los clientes y otro por los pasteleros
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
