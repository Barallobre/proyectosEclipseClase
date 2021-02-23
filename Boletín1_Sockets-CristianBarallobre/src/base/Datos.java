package base;

import java.io.Serializable;

public class Datos implements Serializable {
	String cadena; //cadena que se intercambia con el servidor
	int identificador; //id del jugador
	boolean gana; //true si el jugador adivina el numero
	boolean juega; //true si el jugador juega, false juego finalizado
	
	public Datos(String cadena, int identificador) {		
		this.cadena = cadena;
		this.identificador=identificador;
		this.gana=false;
		this.juega=true;		
	}	
	
	public Datos() {
		super();		
	}

	public boolean isJuega() {
		return juega;
	}

	public void setJuega(boolean juega) {
		this.juega = juega;
	}

	public boolean isGana() {
		return gana;
	}

	public void setGana(boolean gana) {
		this.gana = gana;
	}


	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getCadena() {
		return cadena;
	}
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

}
