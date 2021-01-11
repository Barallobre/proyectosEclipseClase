import java.awt.EventQueue;

public class Principal {
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMantenimiento v = new VentanaMantenimiento();
					EscuchaBotonMantenimiento eb = new EscuchaBotonMantenimiento(v);
					v.setLocationRelativeTo(null);
					v.conectaEscuchaBoton(eb);
					v.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
