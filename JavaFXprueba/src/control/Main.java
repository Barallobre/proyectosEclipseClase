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

	// ... DESPU�S DE LAS OTRAS VARIABLES ...
	// Declaro datosPersonas como una 'lista observable' de personas
	 private ObservableList<Persona> datosPersonas =
	 FXCollections.observableArrayList();
	 // Constructor
	 public Main() {
	 // A�ado datos de ejemplo
	 datosPersonas.add(new Persona("Ernesto", "Alvari�o"));
	 datosPersonas.add(new Persona("V�ctor", "Lois"));
	 datosPersonas.add(new Persona("Carlos J.", "P�rez"));
	 datosPersonas.add(new Persona("Iv�n", "Esp�rrago"));
	 datosPersonas.add(new Persona("Juan G.", "V�zquez"));
	 datosPersonas.add(new Persona("Alberto", "Ares"));
	 datosPersonas.add(new Persona("Manuel", "Queiro"));
	 datosPersonas.add(new Persona("Miguel", "Rodr�guez"));
	 datosPersonas.add(new Persona("Juan S.", "Buitrago"));
	 datosPersonas.add(new Persona("Sergio", "V�zquez"));
	 datosPersonas.add(new Persona("Rub�n", "Picado"));
	 datosPersonas.add(new Persona("Miguel", "Fern�ndez"));
	 datosPersonas.add(new Persona("Mart�n", "Carro"));
	 datosPersonas.add(new Persona("Bruno", "Fresco"));
	 datosPersonas.add(new Persona("Francisco", "Longueira"));
	 datosPersonas.add(new Persona("Estela", "Bol�var"));
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
// Carga la vista ra�z desde el fichero Raiz.fxml
// y la sit�a en el panelRaiz.
			FXMLLoader cargador = new FXMLLoader();
			cargador.setLocation(Main.class.getResource("view/Raiz.fxml"));
			panelRaiz = (BorderPane) cargador.load();
// Crea una escena con el panelRaiz, la a�ade al escenario
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
// Sit�a la vista FichaPersonal.fxml en el centro del panel de
//la vista ra�z.
			panelRaiz.setCenter(panelFichaFersonal);
			// Da al controlador acceso a la aplicaci�n principal
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