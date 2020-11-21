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
				bloquearOtrosHilos();
				if (this.ficheroTexto.leer()) {
					this.ficheroCogido = true;
				}
				desbloquearHilos();
			}
			leer();

			bloquearOtrosHilos();
			this.ficheroTexto.soltar();
			this.ficheroCogido = false;
			desbloquearHilos();
			
			esperar();
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
			Thread.sleep(5000);// TODO
		} catch (InterruptedException e) {
			System.err.println("Error mientras el lector " + id + " lee: " + e);
		}
	}

	private void esperar() {
		try {
			System.out.println((new Date()) + " - Lector " + id + " está esperando...");
			Thread.sleep(5000);// TODO
		} catch (InterruptedException e) {
			System.err.println("Error mientras el lector " + id + " esperando: " + e);
		}
	}
}
