package base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Escuchador implements ActionListener {

	private Chat chat1;

	public Escuchador(Chat chat1) {
	
		this.chat1 = chat1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		if (comando.equals("Enviar")) {
			chat1.textoRecogido.setText(chat1.textoEnviado.getText());
		} else if (comando.equals("Borrar Chat")) {
			chat1.textoRecogido.setText("");
		}

	}

}
