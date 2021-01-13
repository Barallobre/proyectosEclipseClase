package base;

import java.io.Serializable;

public class Provincia implements Serializable {
	String ComunidadAutonoma;
	int numProvincia;
	String Provincia;
	String Poblacion;
	double Densidad;
	int Superficie;

	public Provincia(String ComunidadAutonoma, int numProvincia, String Provincia, String Poblacion, double Densidad,
			int Superficie) {
		super();
		this.ComunidadAutonoma = ComunidadAutonoma;
		this.numProvincia = numProvincia;
		this.Provincia = Provincia;
		this.Poblacion = Poblacion;
		this.Densidad = Densidad;
		this.Superficie = Superficie;
	}

	/* Métodos getters y setters */
	public String getDatos() {
		return ComunidadAutonoma + " - " + numProvincia + " - " + Provincia + " - " + Poblacion + " - " + Densidad
				+ " - " + Superficie;
	}

	public String getComunidadAutonoma() {
		return ComunidadAutonoma;
	}

	public void setComunidadAutonoma(String comunidadAutonoma) {
		ComunidadAutonoma = comunidadAutonoma;
	}

	public int getNumProvincia() {
		return numProvincia;
	}

	public void setNumProvincia(int numProvincia) {
		this.numProvincia = numProvincia;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public String getPoblacion() {
		return Poblacion;
	}

	public void setPoblacion(String poblacion) {
		Poblacion = poblacion;
	}

	public double getDensidad() {
		return Densidad;
	}

	public void setDensidad(double densidad) {
		Densidad = densidad;
	}

	public int getSuperficie() {
		return Superficie;
	}

	public void setSuperficie(int superficie) {
		Superficie = superficie;
	}

}
