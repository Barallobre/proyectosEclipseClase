package control;

import java.io.IOException;

import control.model.Persona;
import control.view.ControladorFichaPersonal;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage escenario;
	private BorderPane panelRaiz;

	// ... DESPUÉS DE LAS OTRAS VARIABLES ...
	// Declaro datosPersonas como una 'lista observable' de personas
	 private ObservableList<Persona> datosPersonas =
	 FXCollections.observableArrayList();
	 // Constructor
	 public Main() {
	 // Añado datos de ejemplo
	 datosPersonas.add(new Persona("Ernesto", "Alvariño"));
	 datosPersonas.add(new Persona("Víctor", "Lois"));
	 datosPersonas.add(new Persona("Carlos J.", "Pérez"));
	 datosPersonas.add(new Persona("Iván", "Espárrago"));
	 datosPersonas.add(new Persona("Juan G.", "Vázquez"));
	 datosPersonas.add(new Persona("Alberto", "Ares"));
	 datosPersonas.add(new Persona("Manuel", "Queiro"));
	 datosPersonas.add(new Persona("Miguel", "Rodríguez"));
	 datosPersonas.add(new Persona("Juan S.", "Buitrago"));
	 datosPersonas.add(new Persona("Sergio", "Vázquez"));
	 datosPersonas.add(new Persona("Rubén", "Picado"));
	 datosPersonas.add(new Persona("Miguel", "Fernández"));
	 datosPersonas.add(new Persona("Martín", "Carro"));
	 datosPersonas.add(new Persona("Bruno", "Fresco"));
	 datosPersonas.add(new Persona("Francisco", "Longueira"));
	 datosPersonas.add(new Persona("Estela", "Bolívar"));
	 }

	// Devuelvo datosPersonas como una 'lista observable' de personas
	 public ObservableList<Persona> getDatosPersonas() {
	 return datosPersonas;
	 }

	 // ... EL RESTO DE LA CLASE ...
	
	
	
	
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
			// Da al controlador acceso a la aplicación principal
		      ControladorFichaPersonal controlador = cargador.getController();
		      controlador.setMainApp(this);
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