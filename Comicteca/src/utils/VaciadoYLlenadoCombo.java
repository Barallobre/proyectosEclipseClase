package utils;

import java.util.ArrayList;

import javax.swing.JComboBox;

public class VaciadoYLlenadoCombo {
	public static void consultaParaLlenadodeCombo(String consulta, JComboBox param) {
		param.removeAllItems();
		param.addItem("");
		ArrayList<String> listado;
		try {
			listado = ComboBoxFiller.llenarLista(consulta);
			for (int i = 0; i < listado.size(); i++) {
				param.addItem(listado.get(i));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
