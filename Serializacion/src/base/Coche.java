package base;

import java.io.Serializable;

public class Coche implements Serializable {
	String matricula;
	String modelo;
	transient double precioParaEmpleados;

	public Coche(String matricula, String modelo, double precioParaEmpleados) {
		super();
		this.matricula = matricula;
		this.modelo = modelo;
		this.precioParaEmpleados = precioParaEmpleados;
	}

	public String getDatos() {
		return matricula + "-" + modelo + "-" + precioParaEmpleados;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecioParaEmpleados() {
		return precioParaEmpleados;
	}

	public void setPrecioParaEmpleados(double precioParaEmpleados) {
		this.precioParaEmpleados = precioParaEmpleados;
	}

}
