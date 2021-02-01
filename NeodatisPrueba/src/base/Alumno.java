package base;

public class Alumno {

	int numAlumno;
	String nombre;
	String ciclo;

	public Alumno(int numAlumno, String nombre, String ciclo) {
		super();
		this.numAlumno = numAlumno;
		this.nombre = nombre;
		this.ciclo = ciclo;
	}

	public int getNumAlumno() {
		return numAlumno;
	}

	public void setNumAlumno(int numAlumno) {
		this.numAlumno = numAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

}
