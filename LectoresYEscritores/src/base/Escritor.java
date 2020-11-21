package base;

import java.util.Date;
import java.util.concurrent.Semaphore;

public class Escritor extends Thread {
	boolean ficheroCogido;
	FicheroTexto ficheroTexto;
	Integer id;

	static Semaphore semaforo = new Semaphore(1);

	Escritor(FicheroTexto ficheroTexto, Integer id) {
		this.id = id;
		this.ficheroCogido = false;
		this.ficheroTexto = ficheroTexto;
	}

	public void run() {
		while (true) {
			while (this.ficheroCogido == false) {
				//Si no tengo el fichero, bloqueo el resto de hilos para intentarlo
				bloquearOtrosHilos();
				//Intentamos "escribir" en el fichero (tryAcquire)
				if (this.ficheroTexto.escribir()) {
					this.ficheroCogido = true;
				}
				//ya terminé de intentar conseguir el fichero así que libero la cola 
				//para que el siguiente intente lo mismo
				desbloquearHilos();
			}
			//"escribir"en el fichero, durante un tiempo random y mantienen el fichero bloqueado
			//y mientras "lee" se bloquea al resto
			escribir();
			bloquearOtrosHilos();
			//al terminanr liberamos el fichero y se desbloquea la cola para el resto de hilos
			this.ficheroTexto.soltar();
			this.ficheroCogido = false;
			desbloquearHilos();
			//mientras no está en la cola hace otra acción durante otro tiempo random
			esperarParaEscribir();
		}
	}

	private void bloquearOtrosHilos() {
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			System.err.println("Error al esperar el lector " + this.id + " : " + e);
		}
	}

	private void desbloquearHilos() {
		semaforo.release();
	}

	private void escribir() {
		try {
			System.out.println((new Date()) + " - Escritor " + id + " está escribiendo...");
			Thread.sleep((int) Math.floor(Math.random() * (10000 - 1000 + 1) + 1000));// TODO
		} catch (InterruptedException e) {
			System.err.println("Error mientras el escritor " + id + " escribe: " + e);
		}
	}

	private void esperarParaEscribir() {
		try {
			System.out.println((new Date()) + " - Escritor " + id + " está esperando...");
			Thread.sleep((int) Math.floor(Math.random() * (10000 - 1000 + 1) + 1000));// TODO
		} catch (InterruptedException e) {
			System.err.println("Error mientras el escritor " + id + " esperando: " + e);
		}
	}
}
