/*
 * Nombre: Cristian Barallobre Rúa
 * DNI: 53306579P
 */
package base;

import java.util.Date;
import java.util.concurrent.Semaphore;

public class Pastelero extends Thread {
	boolean bandejaCogida;
	Magdalenas bandeja;
	Integer id;
	//creamos una instancia del semaforo de la sección crítica
	static Semaphore semaforo = new Semaphore(1);

	Pastelero(Magdalenas bandeja, Integer id) {
		this.id = id;
		this.bandejaCogida = false;
		this.bandeja = bandeja;
	}

	public void run() {
		//en el método run establecemos un bucle infinito para continuamente tratarnos de hacer con el control de la bandeja cuando sea posible
		while (true) {
			while (this.bandejaCogida == false) {
				// Si no tengo la bandeja, bloqueo el resto de hilos para intentarlo
				bloquearOtrosHilos();
				// Intentamos "reponer" (tryAcquire)
				if (this.bandeja.reponer()) {
					this.bandejaCogida = true;
				}
				// ya terminé de intentar conseguir la bandeja así que libero la cola
				// para que el siguiente intente lo mismo
				desbloquearHilos();
			}
			// "reponer" mantiene la bandeja bloqueada
			// y mientras "repone" se bloquea al resto
			reponer();
			bloquearOtrosHilos();
			// al terminar liberamos la bandeja y se desbloquea la cola para el resto de
			// hilos
			this.bandeja.soltar();
			this.bandejaCogida = false;
			desbloquearHilos();
			// mientras no está en la cola hace otra acción durante otro tiempo estipulado
			esperarParaReponer();
		}
	}
	//con un método del semáforo bloqueamos la sección crítica para el resto de hilos y usarla aquí
	private void bloquearOtrosHilos() {
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			System.err.println("Error al esperar el pastelero " + this.id + " : " + e);
		}
	}
	//con un método del semáforo desbloqueamos la sección crítica para que el resto de hilos intente acceder a ella
	private void desbloquearHilos() {
		semaforo.release();
	}

	//método para hacer uso de la sección crítica durante un tiempo determinado
	private void reponer() {
		try {
			System.out.println((new Date()) + " - Pastelero " + id + " está reponiendo...");
			Thread.sleep((int) Math.floor(Math.random() * (10 - 3 + 1) + 3));
		} catch (InterruptedException e) {
			System.err.println("Error mientras el pastelero " + id + " repone: " + e);
		}
	}

	// método para establecer un tiempo de espera mientras se intenta hacer otra vez
	// con el control de la bandeja
	private void esperarParaReponer() {
		try {
			System.out.println((new Date()) + " - Pastelero " + id + " está esperando...");
			Thread.sleep(10);
		} catch (InterruptedException e) {
			System.err.println("Error mientras el pastelero " + id + " esperando: " + e);
		}
	}
}
