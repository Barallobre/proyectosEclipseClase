package base;

public class Cliente {

	int num_cli;
	String nombre_cli;
	String direccion_cli;
	public Cliente(int num_cli, String nombre_cli, String direccion_cli) {
		super();
		this.num_cli = num_cli;
		this.nombre_cli = nombre_cli;
		this.direccion_cli = direccion_cli;
	}
	public int getNum_cli() {
		return num_cli;
	}
	public void setNum_cli(int num_cli) {
		this.num_cli = num_cli;
	}
	public String getNombre_cli() {
		return nombre_cli;
	}
	public void setNombre_cli(String nombre_cli) {
		this.nombre_cli = nombre_cli;
	}
	public String getDireccion_cli() {
		return direccion_cli;
	}
	public void setDireccion_cli(String direccion_cli) {
		this.direccion_cli = direccion_cli;
	}

	

}
