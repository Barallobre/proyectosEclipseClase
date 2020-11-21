package base;

import java.util.Date;
import java.util.concurrent.Semaphore;

public class Lector extends Thread{
	boolean ficheroCogido;
	FicheroTexto ficheroTexto;
	Integer id;

	static Semaphore semaforo = new Semaphore(1);

	Lector(FicheroTexto ficheroTexto,Integer id) {
		this.id = id;
		this.ficheroCogido = false;
		this.ficheroTexto = ficheroTexto;
	}

	public void run() {
		while (true) {
			while (this.ficheroCogido == false) {
				//Si no tengo el fichero, bloqueo el resto de hilos para intentarlo
				bloquearOtrosHilos();
				//Intentamos "leer" el fichero (tryAcquire)
				if (this.ficheroTexto.leer()) {
					this.ficheroCogido = true;
				}
				//ya terminé de intentar conseguir el fichero así que libero la cola 
				//para que el siguiente intente lo mismo
				desbloquearHilos();
			}
			//"lee" el fichero, durante un tiempo random y mantienen el fichero bloqueado
			//y mientras "lee" se bloquea al resto
			leer();
			bloquearOtrosHilos();
			//al terminanr liberamos el fichero y se desbloquea la cola para el resto de hilos
			this.ficheroTexto.soltar();
			this.ficheroCogido = false;
			desbloquearHilos();
			//mientras no está en la cola hace otra acción durante otro tiempo random
			esperarParaLeer();
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

	private void leer() {
		try {
			System.out.println((new Date()) + " - Lector " + id + " está leyendo...");
			Thread.sleep((int) Math.floor(Math.random()*(10000-1000+1)+1000));// TODO
		} catch (InterruptedException e) {
			System.err.println("Error mientras el lector " + id + " lee: " + e);
		}
	}

	private void esperarParaLeer() {
		try {
			System.out.println((new Date()) + " - Lector " + id + " está esperando...");
			Thread.sleep((int) Math.floor(Math.random()*(10000-1000+1)+1000));// TODO
		} catch (InterruptedException e) {
			System.err.println("Error mientras el lector " + id + " esperando: " + e);
		}
	}
}
