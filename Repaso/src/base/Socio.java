package base;

import java.util.Date;

public class Socio {
	String numero, nombre, telefono, email;
	Date fechaAlta;
	int tarifa;

	/**
	 * Constructor vacío
	 */
	public Socio() {
		super();
	}

	/**
	 * Constructor con todos los parametros
	 * 
	 * @param numero
	 * @param nombre
	 * @param telefono
	 * @param email
	 * @param fechaAlta
	 * @param tarifa
	 */

	public Socio(String numero, String nombre, String telefono, String email, Date fechaAlta, int tarifa) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.fechaAlta = fechaAlta;
		this.tarifa = tarifa;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	// Método para validar el numero de teléfono
	public boolean validarTelefono(String telefono) {
		return telefono.matches("^(9|8|7|6){1}[0-9]{8}$");
	}

	// Método para validar el formato del email
	public boolean validarEmail(String email) {
		return email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,4})$");
	}

	// Sobreescritura del toString()
	@Override
	public String toString() {
		String sb = "\nNumero: " + this.numero + "\nNombre: " + this.nombre + "\nTeléfono: " + this.telefono
				+ "\nEmail: " + this.email + "\nFecha alta: " + this.fechaAlta + "\nTarifa: " + this.tarifa;
		return sb;
	}
}
