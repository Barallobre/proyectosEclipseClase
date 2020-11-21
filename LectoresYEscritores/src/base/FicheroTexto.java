package base;

import java.util.concurrent.Semaphore;

public class FicheroTexto {
	Semaphore semaforo;
	
	FicheroTexto(){
		this.semaforo = new Semaphore(1);
	}
	
	public boolean leer() {
		return semaforo.tryAcquire();
	}
	public boolean escribir() {
		return semaforo.tryAcquire();
	}
	public void soltar(){
		semaforo.release();
	}
}
