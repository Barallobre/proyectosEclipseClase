package base;

import java.io.Serializable;

public class Alumno implements Serializable {
	String DNI;
	String nombre;
	int edad;
	transient boolean tieneAnticuerpos;

	public Alumno(String dNI, String nombre, int edad, boolean tieneAnticuerpos) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.edad = edad;
		this.tieneAnticuerpos = tieneAnticuerpos;
	}

	/* Métodos getters y setters */
	public String getDatos() {
		return DNI + " - " + nombre + " - " + edad + " - " + tieneAnticuerpos;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean getTieneAnticuerpos() {
		return tieneAnticuerpos;
	}

	public void setTieneAnticuerpos(boolean tieneAnticuerpos) {
		this.tieneAnticuerpos = tieneAnticuerpos;
	}

	/* Métodos del alumno */
	public void estudiar() {

	}

	public void seExamina() {

	}

	@Override
	public String toString() {
		String sb = "\nDNI: " + this.DNI + "\nNombre: " + this.nombre + "\nEdad: " + this.edad;
		return sb;
	}

}
