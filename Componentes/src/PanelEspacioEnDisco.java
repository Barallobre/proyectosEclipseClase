import java.io.IOException;
import java.nio.file.*;
import javax.swing.*;

public class PanelEspacioEnDisco extends JPanel {
	JLabel espacioEnDisco = new JLabel("Espacio en disco: ");
	JLabel espacio = new JLabel();

	public PanelEspacioEnDisco() {
		super();
		add(espacioEnDisco);
		add(espacio);
		try {
			calculaEspacioEnDisco();
		} catch (IOException e) {
			espacio.setText("Error al calcular el espacio en disco");
		}
	}

//Declaramos el método 'calculaEspacioEnDisco' como final
//para evitar que se reemplace en una subclase;
//es necesario para que 'PanelEspacioEnDisco' sea un componente de la GUI
	private final void calculaEspacioEnDisco() throws IOException {
//El método get(String) convierte una cadena en una ruta. Si la cadena es “”,
//devuelve la ruta de la carpeta actual en la que se ejecuta la aplicación
		Path actual = Paths.get("");
//Obtenemos la unidad de disco actual del ordenador en el que se ejecuta el programa
		FileStore unidad = Files.getFileStore(actual);
//Obtenemos el espacio total y el espacio libre en GB y el % de espacio libre
		long espacioTotal = unidad.getTotalSpace() / (1024 * 1024 * 1024);
		long espacioLibre = unidad.getUsableSpace() / (1024 * 1024 * 1024);
		double porcentaje = (double) espacioLibre / (double) espacioTotal * 100;
//para que el % solo muestre como mucho 2 decimales
		porcentaje = (int) (porcentaje * 100) / (double) 100;
//Definimos el texto de la etiqueta 'espacio'
		espacio.setText(espacioLibre + " GB libres de " + espacioTotal + " GB (" + porcentaje + "%)");
	}
}
