package base;

public class ObjetoCompartido {
	private String[][] premios; // array con los premios
	private boolean acabo;
	private int ganador;

	public ObjetoCompartido(String[][] premios) {
		this.premios = premios; // array a adivinar
		this.acabo = false;
	}

	public boolean seAcabo() {
		return acabo;
	}

	public int getGanador() {
		return ganador;
	}

	public synchronized String nuevaJugada(int jugador, String coordenadasCliente) {
		String cad = "";

		if (!seAcabo()) {
			String coordenadasClientePartes[] = coordenadasCliente.split(",");
			int Fila = Integer.parseInt(coordenadasClientePartes[0]);
			int Columna = Integer.parseInt(coordenadasClientePartes[1]);

			if (premios[Fila][Columna] == "Crucero" || premios[Fila][Columna] == "Entradas"
					|| premios[Fila][Columna] == "Masaje" || premios[Fila][Columna] == "1000€") {
				cad = "Ha ganado un premio";
			}

		} else
			cad = "Jugador " + ganador + " adivinó un premio ";

		return cad;
	}
}