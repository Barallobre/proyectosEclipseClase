package control;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage escenario;
	private BorderPane panelRaiz;

	@Override
	public void start(Stage escenario) {
		this.escenario = escenario;
		this.escenario.setTitle("Agenda");
		muestraRaiz();
		muestraFichaPersonal();
	}

	public void muestraRaiz() {
		try {
// Carga la vista raíz desde el fichero Raiz.fxml
// y la sitúa en el panelRaiz.
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Main.class.getResource("view/Raiz.fxml"));
			panelRaiz = (BorderPane) cargador.load();
// Crea una escena con el panelRaiz, la añade al escenario
// y la muestra.
			Scene escena = new Scene(panelRaiz);
			escenario.setScene(escena);
			escenario.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void muestraFichaPersonal() {
		try {
// Carga la vista de la ficha personal desde el fichero .fxml.
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Main.class.getResource("view/FichaPersonal.fxml"));
			AnchorPane panelFichaFersonal = (AnchorPane) cargador.load();
// Sitúa la vista FichaPersonal.fxml en el centro del panel de
//la vista raíz.
			panelRaiz.setCenter(panelFichaFersonal);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

// Devuelve el escenario
	public Stage getEscenarioPrincipal() {
		return escenario;
	}

	public static void main(String[] args) {
		launch(args);
	}
}