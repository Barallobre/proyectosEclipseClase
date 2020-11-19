
package base;



import java.util.concurrent.Semaphore;

public class Palillo {
	Semaphore semaforo;
	Integer id;
	
	Palillo(Integer id){
		this.semaforo = new Semaphore(1);
		this.id = id;
	}
	
	public boolean coger(){
		// tryAcquire para no bloquear los hilos y poder dejar libres los recursos si no se usan.
		return semaforo.tryAcquire(); 
	}
	
	public void soltar(){
		semaforo.release();
	}
}
