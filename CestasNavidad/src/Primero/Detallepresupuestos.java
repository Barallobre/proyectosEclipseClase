package Primero;
// Generated 18 ene. 2021 9:58:01 by Hibernate Tools 5.4.21.Final

/**
 * Detallepresupuestos generated by hbm2java
 */
public class Detallepresupuestos implements java.io.Serializable {

	private DetallepresupuestosId id;
	private Presupuestos presupuestos;
	private Productos productos;

	public Detallepresupuestos() {
	}

	public Detallepresupuestos(DetallepresupuestosId id) {
		this.id = id;
	}

	public Detallepresupuestos(DetallepresupuestosId id, Presupuestos presupuestos, Productos productos) {
		this.id = id;
		this.presupuestos = presupuestos;
		this.productos = productos;
	}

	public DetallepresupuestosId getId() {
		return this.id;
	}

	public void setId(DetallepresupuestosId id) {
		this.id = id;
	}

	public Presupuestos getPresupuestos() {
		return this.presupuestos;
	}

	public void setPresupuestos(Presupuestos presupuestos) {
		this.presupuestos = presupuestos;
	}

	public Productos getProductos() {
		return this.productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

}
