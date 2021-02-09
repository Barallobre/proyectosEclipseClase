package base;

import java.io.Serializable;

public class Cosa implements Serializable {
	String material;
	int antiguedad;
	public Cosa (String material, int antiguedad) {
		super();
		this.material = material;
		this.antiguedad = antiguedad;
	}
	
	public Cosa() {
		super();
	}
	
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
}
