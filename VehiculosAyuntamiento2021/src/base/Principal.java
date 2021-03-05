package base;

public class Principal {

	public static void main(String[] args) {
		Barrademenu barramenu = new Barrademenu();
		barramenu.setVisible(true);
		Escuchador e = new Escuchador(barramenu);
		barramenu.asignarEscuchador(e);
	}
}
