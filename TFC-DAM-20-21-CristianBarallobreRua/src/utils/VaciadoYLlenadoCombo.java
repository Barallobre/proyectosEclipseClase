package utils;

import java.util.ArrayList;

import javax.swing.JComboBox;
/**
 * Clase para vaciar primero el combo para rellenarlo con la información actualizada
 * 
 * @author Cristian Barallobre
 * @version 19-05-2021
 * 
 */
public class VaciadoYLlenadoCombo {
	public static void consultaParaLlenadodeCombo(String consulta, JComboBox param) {
		param.removeAllItems();
		param.addItem("");
		ArrayList<String> listado;
		listado = ComboBoxFiller.llenarLista(consulta);
		for (int i = 0; i < listado.size(); i++) {
			param.addItem(listado.get(i));
		}

	}

}
