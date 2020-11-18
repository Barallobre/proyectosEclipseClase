package base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscuchaBoton implements ActionListener {
	VentanaConBotonEscuchador vta;
	public EscuchaBoton(VentanaConBotonEscuchador v) {
		vta = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vta.boton) {
		
			System.out.println("Hola desde el boton 1");
		} else {
			System.out.println("Hola desde el boton 2");
		}
	}
}
