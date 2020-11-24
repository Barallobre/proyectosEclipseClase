package base;

public class Principal {

	public static void main(String[] args) {
		Chat chat1 = new Chat();
		chat1.setVisible(true);
		Escuchador e = new Escuchador(chat1);
		chat1.asignarEscuchador(e);
	}
}
