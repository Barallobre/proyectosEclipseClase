package utils;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import base.VentanaPrincipal;
import funciones.Consultanoleidos;
/**
 * Clase para volver a la pantalla principla cada vez que se pulse cancelar
 * 
 * @author Cristian Barallobre
 * @version 19-05-2021
 * 
 */
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
			Window w = SwingUtilities.getWindowAncestor(contentPane);
			w.setVisible(false);
		}
	});
}
}
