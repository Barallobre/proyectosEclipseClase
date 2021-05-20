package utils;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import base.VentanaPrincipal;
import funciones.Consultanoleidos;

public class BotonAtras {
public static void irAtras(JButton cancelar, JPanel contentPane) {
	cancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				VentanaPrincipal frame = new VentanaPrincipal();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			contentPane.setEnabled(false);
		}
	});
}
}
