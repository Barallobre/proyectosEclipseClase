package control.view;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import control.Main;
import control.model.Persona;
public class ControladorFichaPersonal {
// Los campos del archivo fxml que deben ser accedidos, deben ser
// anotados con @FXML. En realidad, solo si son privados; pero es
// mejor declararlos como privados y marcarlos con la notaci�n
 @FXML
 private TableView<Persona> tablaPersonas;
 @FXML
 private TableColumn<Persona, String> columnaNombre;
 @FXML
 private TableColumn<Persona, String> columnaApellidos;
 @FXML
 private Label etiquetaNombre;
 @FXML
 private Label etiquetaApellidos;
 @FXML
 private Label etiquetaCalle;
 @FXML
 private Label etiquetaCodigoPostal;
 @FXML
 private Label etiquetaPoblacion;
 @FXML
 private Label etiquetaFechaNacimiento;
 // Referencia al main de la aplicaci�n
 
 private Main mainApp;

 // El constructor es llamado antes del m�todo initialize()
 public ControladorFichaPersonal() {
 }
 // El m�todo initialize() -no puede ser llamado de otro modo- es
 // invocado autom�ticamente tras cargar el fxml. En ese momento,
 // todos los atributos FXML deber�an haber sido inicializados ya
 @FXML
 private void initialize() {
 // El m�todo setCellValueFactory() que aplicamos sobre las
 // columnas de la tabla, se usa para determinar qu� atributos de
 // la clase Persona deben ser usados para cada columna. La flecha
 // -> indica que estamos usando una caracter�stica de Java 8
 //denominada expresiones lambda
 columnaNombre.setCellValueFactory(cellData ->
 cellData.getValue().propiedadNombre());
 columnaApellidos.setCellValueFactory(datoCelda ->
 datoCelda.getValue().propiedadApellidos());
 }
 // Este m�todo debe ser invocado desde la clase Main, lo que nos dar�
 // la oportunidad de acceder al objeto mainApp para obtener la lista
 // de Personas, entre otras cosas
 public void setMainApp(Main mainApp) {
 this.mainApp = mainApp;
 // A�ade los datos de la lista observable a la tabla de la vista
 tablaPersonas.setItems(mainApp.getDatosPersonas());
 }
}
