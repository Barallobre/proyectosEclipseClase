package base;

public class Pais {
	private int numpais;
	private String nombrepais;

	public Pais(int numpais, String nombrepais) {
		super();
		this.numpais = numpais;
		this.nombrepais = nombrepais;
	}

	public int getNumpais() {
		return numpais;
	}

	public void setNumpais(int numpais) {
		this.numpais = numpais;
	}

	public String getNombrepais() {
		return nombrepais;
	}

	public void setNombrepais(String nombrepais) {
		this.nombrepais = nombrepais;
	}

}