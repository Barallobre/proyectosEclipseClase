package base;


public class ObjetoCompartido {
	private String[][] premios; 
	private boolean acabo;
	private int ganador;
	private int premiosGanados=0;
	public ObjetoCompartido(String[][] premios) {
		this.premios = premios; 
		this.acabo = false;
	}

	public String[][] getPremios() {
		return premios;
	}

	public void setPremios(String[][] premios) {
		this.premios = premios;
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
	

			if (premios[Fila][Columna].equals("        ")) {
				cad = "No hay premios en esa casilla, siga probando";
				
			}else {
				cad = "Jugador " + jugador + " ha ganado: " + premios[Fila][Columna];
				System.out.println(cad);
				premios[Fila][Columna] = ("        ");
				premiosGanados++;
				}
			if(premiosGanados==4)
				acabo=true;

		} else
			cad = "Ya no quedan más premios.";

		return cad;
	}
}