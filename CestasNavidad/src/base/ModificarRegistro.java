package base;

import java.math.BigDecimal;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Primero.*;

public class ModificarRegistro {
	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.obtenSessionFactory();
		try {

			Session sesion = null;
			sesion = sesionFactory.openSession();

			Transaction transaccion = sesion.beginTransaction();
			int numcli = 66666666;
			int codProducto = 1;
			System.out.println("Voy a modificar un cliente número: "+numcli);
			
			try {

				Clientes cli = new Clientes();
				cli = sesion.get(Clientes.class, numcli);
				if(cli!=null) {
					System.out.println("Modificando...");
					cli.setNombreRazonSocial("Pepe");
					sesion.update(cli);
				}else {
					System.out.println("El cliente no existe.");
				}
				
				Productos pro = new Productos();
				pro = sesion.get(Productos.class, codProducto);
				if(cli!=null) {
					System.out.println("Modificando...");
					pro.setDescripcion("Torreznos");
					pro.setPrecio(new BigDecimal(35));
					sesion.update(pro);
				}else {
					System.out.println("El producto no existe.");
				}
				
				transaccion.commit();
			} catch (Exception e1) {
				try {
					transaccion.rollback();
					System.out.println("No se ha podido modificar el registro ");
				} catch (Exception e2) {
					System.out.println("Error al modificar el registro ");
				}
			} finally {

				if (sesion != null)
					sesion.close();
			}
		} catch (Exception e3) {
			System.out.println("Problemas durante la sesión de trabajo.");
		} finally {

			SessionFactoryUtil.cierraSessionFactory();
		}
	}
}
