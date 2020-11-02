package base;

public class Empleado {

	int numeroEmpleado;
	String nombre;
	int departamento;
	double salario;

	public Empleado() {
		super();
	}

	public Empleado(int numeroEmpleado, String nombre, int departamento, double salario) {
		super();
		this.numeroEmpleado = numeroEmpleado;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
	}

	public int getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(int numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		String sb = "\nNumero: " + this.numeroEmpleado + "\nNombre: " + this.nombre + "\nDepartamento: "
				+ this.departamento + "\nSalario: " + this.salario;
		return sb;
	}

}
