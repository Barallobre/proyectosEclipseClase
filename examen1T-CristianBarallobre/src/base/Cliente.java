/*
 * Nombre: Cristian Barallobre R�a
 * DNI: 53306579P
 */
package base;

import java.util.Date;
import java.util.concurrent.Semaphore;

public class Cliente extends Thread {
	boolean bandejaCogida;
	Magdalenas bandeja;
	Integer id;
	//creamos una instancia del semaforo de la secci�n cr�tica
	static Semaphore semaforo = new Semaphore(1);

	Cliente(Magdalenas bandeja, Integer id) {
		this.id = id;
		this.bandejaCogida = false;
		this.bandeja = bandeja;
	}

	public void run() {
		//en el m�todo run establecemos un bucle infinito para continuamente tratarnos de hacer con el control de la bandeja cuando sea posible
		while (true) {
			while (this.bandejaCogida == false) {
				// Si no tengo la bandeja, bloqueo el resto de hilos para intentarlo
				bloquearOtrosHilos();
				// Intentamos "coger" de la bandeja (tryAcquire)
				if (this.bandeja.cogerYComer()) {
					this.bandejaCogida = true;
				}
				// ya termin� de intentar conseguir la bandeja as� que libero la cola
				// para que el siguiente intente lo mismo
				desbloquearHilos();
			}
			// "coge y come" de la bandeja, durante un tiempo establecido y mantienen la
			// bandeja bloqueada
			// y mientras "come" se bloquea al resto
			cogerYComer();
			bloquearOtrosHilos();
			// al terminar liberamos la bandeja y se desbloquea la cola para el resto de
			// hilos
			this.bandeja.soltar();
			this.bandejaCogida = false;
			desbloquearHilos();
			// mientras no est� en la cola hace otra acci�n durante otro tiempo
			esperarParaCoger();
		}
	}
	//con un m�todo del sem�foro bloqueamos la secci�n cr�tica para el resto de hilos y usarla aqu�
	private void bloquearOtrosHilos() {
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			System.err.println("Error al esperar el cliente " + this.id + " : " + e);
		}
	}
	//con un m�todo del sem�foro desbloqueamos la secci�n cr�tica para que el resto de hilos intente acceder a ella
	private void desbloquearHilos() {
		semaforo.release();
	}

	// m�todo para hacer uso de la secci�n cr�tica durante un tiempo determinado
	private void cogerYComer() {
		try {
			System.out.println((new Date()) + " - Cliente " + id + " est� comiendo...");
			Thread.sleep((int) Math.floor(Math.random() * (5 - 3 + 1) + 3));
		} catch (InterruptedException e) {
			System.err.println("Error mientras el cliente " + id + " come: " + e);
		}
	}

	// m�todo para establecer un tiempo de espera mientras se intenta hacer otra vez
	// con el control de la bandeja
	private void esperarParaCoger() {
		try {
			System.out.println((new Date()) + " - Cliente " + id + " est� esperando...");
			Thread.sleep(10);
		} catch (InterruptedException e) {
			System.err.println("Error mientras el cliente " + id + " esperando: " + e);
		}
	}
}
