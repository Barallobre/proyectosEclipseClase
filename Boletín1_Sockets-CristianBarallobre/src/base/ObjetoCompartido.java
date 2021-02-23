package base;

import java.util.ArrayList;

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
			ArrayList<String> premios2 = new ArrayList<String>();
			premios2.add("Crucero ");
			premios2.add("Entradas");
			premios2.add("Masaje  ");
			premios2.add("1000€   ");
			int premiosAcertados = 0;
			if (premios[Fila][Columna] == premios2.get(0)) {
				if(premios[Fila][Columna] == premios2.get(0)) {
					cad = "Ha ganado un Crucero";
					premiosAcertados++;
					premios2.remove(0);
				}else {
					cad="El Crucero ya ha sido ganado";
				}
				
			}else if(premios[Fila][Columna] == premios2.get(1)) {
				
				if(premios[Fila][Columna] == premios2.get(1)) {
					cad = "Ha ganado unas Entradas";
					premios2.remove(1);
					premiosAcertados++;
					System.out.println(premiosAcertados);
				}else {
					cad="Las Entradas ya han sido ganadas";
				}
				
			}else if( premios[Fila][Columna] == premios2.get(2)) {
				if(premios[Fila][Columna] == premios2.get(2)) {
					cad = "Ha ganado un Masaje";
					premios2.remove(2);
					premiosAcertados++;
				}else {
					cad="El Masaje ya ha sido ganado";
				}
			}else if(premios[Fila][Columna] == premios2.get(3)) {
				if(premios[Fila][Columna] == premios2.get(3)) {
					cad = "Ha ganado 1000€";
					premios2.remove(3);
					premiosAcertados++;
				}else {
					cad="Los 1000€ ya han sido ganados";
				}
			}
			if(premiosAcertados == 4) {
				acabo = true;
			}
		} else
			cad = "Jugador " + ganador + " siga probando. ";

		return cad;
	}
}