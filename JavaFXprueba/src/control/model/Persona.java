package control.model;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {
  private final StringProperty nombre;
  private final StringProperty apellidos;
  private final StringProperty calle;
  private final StringProperty poblacion;
  private final IntegerProperty codigoPostal;
  private final ObjectProperty<LocalDate> fechaNacimiento;

  /* Constructor por defecto.
   */
  public Persona() {
    this(null, null);
  }

  /* Constructor con
   */
  public Persona(String nombre, String apellidos) {
    this.nombre = new SimpleStringProperty(nombre);
    this.apellidos = new SimpleStringProperty(apellidos);
// Algunos datos iniciales, solo para probar.
    this.calle = new SimpleStringProperty("una calle cualquiera");
    this.codigoPostal = new SimpleIntegerProperty(1234);
    this.poblacion = new SimpleStringProperty("una población");
    this.fechaNacimiento = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
  }

  public String getNombre() {
    return nombre.get();
  }

  public void setNombre(String nombre) {
    this.nombre.set(nombre);
  }

  public StringProperty propiedadNombre() {
    return nombre;
  }

  public String getApellidos() {
    return apellidos.get();
  }

  public void setApellidos(String apellidos) {
    this.apellidos.set(apellidos);
  }

  public StringProperty propiedadApellidos() {
    return apellidos;
  }

  public String getCalle() {
    return calle.get();
  }

  public void setCalle(String calle) {
    this.calle.set(calle);
  }

  public StringProperty propiedadCalle() {
    return calle;
  }

  public String getPoblacion() {
    return poblacion.get();
  }

  public void setPoblacion(String poblacion) {
    this.poblacion.set(poblacion);
  }

  public StringProperty propiedadPoblacion() {
    return poblacion;
  }

  public int getCodigoPostal() {
    return codigoPostal.get();
  }

  public void setCodigoPostal(int codigoPostal) {
    this.codigoPostal.set(codigoPostal);
  }

  public IntegerProperty propiedadCodigoPostal() {
    return codigoPostal;
  }

  public LocalDate getFechaNacimiento() {
    return fechaNacimiento.get();
  }

  public void setFechaNacimiento(LocalDate fechaNacimiento) {
    this.fechaNacimiento.set(fechaNacimiento);
  }

  public ObjectProperty<LocalDate> propiedadFechaNacimiento() {
    return fechaNacimiento;
  }

}
