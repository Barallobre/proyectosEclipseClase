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
			String textoAEscribir = chat1.textoEnviado.getText();
			String textoRecogido = chat1.textoRecogido.getText();
			chat1.textoRecogido.setText(textoRecogido+=textoAEscribir+"\n");
			
			chat1.textoEnviado.setText("");
		} else if (comando.equals("Borrar Chat")) {
			chat1.textoRecogido.setText("");
		}

	}

}
