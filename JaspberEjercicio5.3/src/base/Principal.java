package base;

public class Principal {

	public static void main(String[] args) {
		Ventana ventana1 = new Ventana();
		ventana1.setVisible(true);
		Escuchador e = new Escuchador(ventana1);
		ventana1.asignarEscuchador(e);
	}
}
