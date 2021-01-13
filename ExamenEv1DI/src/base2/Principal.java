package base2;

public class Principal {
	
	public static void main(String[] args) {
		Agencia1 v1 = new Agencia1();
		EscuchaBoton eb = new EscuchaBoton (v1);
		v1.conectaEscuchaBoton(eb);
	}
}
