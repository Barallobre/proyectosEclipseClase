package base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscuchaBoton implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals("Pulsar1")) {
			System.out.println("Hola desde el boton 1");
		} else {
			System.out.println("Hola desde el boton 2");
		}
	}
}
