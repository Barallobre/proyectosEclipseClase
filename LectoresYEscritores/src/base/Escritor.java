package base;

import java.util.Date;
import java.util.concurrent.Semaphore;

public class Escritor extends Thread{
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
				bloquearOtrosHilos();
				if (this.ficheroTexto.escribir()) {
					this.ficheroCogido = true;
				}
				desbloquearHilos();
			}
			escribir();

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

	private void escribir() {
		try {
			System.out.println((new Date()) + " - Escritor " + id + " está escribiendo...");
			Thread.sleep(5000);// TODO
		} catch (InterruptedException e) {
			System.err.println("Error mientras el escritor " + id + " escribe: " + e);
		}
	}

	private void esperar() {
		try {
			System.out.println((new Date()) + " - Escritor " + id + " está esperando...");
			Thread.sleep(5000);// TODO
		} catch (InterruptedException e) {
			System.err.println("Error mientras el escritor " + id + " esperando: " + e);
		}
	}
}
