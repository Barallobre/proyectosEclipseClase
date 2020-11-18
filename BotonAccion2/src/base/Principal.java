package base;

public class Principal {
	
	public static void main(String[] args) {
		VentanaConBotonEscuchador v1 = new VentanaConBotonEscuchador();
		EscuchaBoton eb = new EscuchaBoton(v1);
		v1.conectaEscuchaBoton(eb);
	}
}
