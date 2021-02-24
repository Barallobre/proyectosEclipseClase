package base;

import java.io.Serializable;

public class Datos implements Serializable {
	String cadena; 
	int identificador; 
	boolean juega;
	int intentos; 
	public Datos(String cadena,int intentos, int identificador) {
		this.cadena = cadena;
		this.identificador = identificador;
		this.intentos = intentos;
		this.juega = true;
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

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	

}
