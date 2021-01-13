package base2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EscuchaBoton implements ActionListener {
	
	Agencia1 v1;
	Agencia2 v2;
	
	public EscuchaBoton (Agencia1 v) {
		v1 = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== v1.btnCancelar) {
			v1.dispose();
			System.exit(0);
		}else 
		if (e.getSource()== v1.btnAceptar) {
			v1.setVisible(false);		
			String gustos ="<html><ul>";
			if (v1.chkComer.isSelected())
				gustos += "<li>Comer</li>";
			if (v1.chkCopas.isSelected())
				gustos += "<li>Ir de copas</li>";		
			if (v1.chkNadar.isSelected())
				gustos += "<li>Nadar</li>";
			if (v1.chkCompras.isSelected())
				gustos += "<li>Ir de compras</li>";
			if (v1.chkCallejear.isSelected())
				gustos += "<li>Callejear</li>";
			if (v1.chkMuseos.isSelected())
				gustos += "<li>Ver museos</li>";
			gustos +="</ul></html>";
			v2 = new Agencia2(v1.txtNombre.getText(), v1.cmbDestino.getSelectedItem().toString(), gustos);
			v2.conectaEscuchaBoton(this);
		}else 
		if (e.getSource()== v2.btnCancelar) {
			v2.dispose();
			v1.setVisible(true);
		} else
		if (e.getSource()== v2.btnAceptar) {				
			String cadena = "<html><p style='font-family: Verdana;font-size:14;font-weight:bold;text-align:center'><br>¡¡Encantados de conocerte ";
			cadena += v1.txtNombre.getText();	
			cadena += "!! <br><br>No olvidaremos que también te gusta <br>";
			cadena += v2.txtArea.getText();
			cadena += ".<br><br></p></html>";
			JOptionPane.showMessageDialog(v1, cadena, "Otros gustos", JOptionPane.INFORMATION_MESSAGE);
	//		v1.dispose();
		}
	}

}
