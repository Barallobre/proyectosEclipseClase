
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class EscuchaBotonMantenimiento implements ActionListener {
	VentanaMantenimiento vta;
	int numMov;
	int idProducto;
	String nombreProducto;
	float pCoste = 0;
	float pVenta = 0;
	int unidadesStock;
	int unidadesInOut;
	float CMP;
	String tipoMov;
	java.util.Date uDate = new java.util.Date();
	java.sql.Date sDate = new java.sql.Date(uDate.getTime());
	DateFormat df = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss.SS");
	String fecha = df.format(uDate);
	boolean grabarMov = true;

	public EscuchaBotonMantenimiento(VentanaMantenimiento v) {
		vta = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vta.btn_aceptar) {

			if ((vta.rb_compra.isSelected() && !vta.cb_articulos.getSelectedItem().toString().equals("")&& !vta.tf_unidades.getText().equals("") && !vta.tf_precio.getText().equals(""))
					|| (vta.rb_venta.isSelected() && !vta.cb_articulos.getSelectedItem().toString().equals("")&& !vta.tf_unidades.getText().equals(""))) {

				Connection conexion = conexionSQL.conectar();
				PreparedStatement sentencia;
				try {

					nombreProducto = vta.cb_articulos.getSelectedItem().toString();
					sentencia = conexion.prepareStatement("select * from productos where nombre=?");
					sentencia.setString(1, nombreProducto);
					ResultSet resultado = sentencia.executeQuery();

					// do que temos en stock
					while (resultado.next()) {
						idProducto = resultado.getInt(1);

						unidadesStock = resultado.getInt(3);
						CMP = resultado.getFloat(4);
					}
					unidadesInOut = Integer.parseInt(vta.tf_unidades.getText()); // obteño unidades que entran do tf da
																					// ventana;

					if (vta.rb_compra.isSelected()) {
						grabarMov = true;
						tipoMov = "compra";
						pCoste = Float.parseFloat(vta.tf_precio.getText());
						pVenta=0;
						if (unidadesStock > 0) {
							CMP = ((CMP * unidadesStock) + (pCoste * unidadesInOut)) / (unidadesStock + unidadesInOut);

						} else {
							CMP = pCoste;
						}

						// UPDATE DE CMP e unidadesStock en productos

						unidadesStock += unidadesInOut;
						sentencia = conexion.prepareStatement("update productos set unidades =?, CMP=? where idProducto=?");
						sentencia.setInt(1, unidadesStock);
						sentencia.setFloat(2, CMP);
						sentencia.setInt(3, idProducto);
						sentencia.executeUpdate();

					} else {
						tipoMov = "venta";
						if ((unidadesStock - unidadesInOut >= 0)&&unidadesInOut>0) {
							grabarMov = true;
							pVenta = ((CMP * 21) / 100) + CMP;
							pCoste=0;
							
							// update de unidadesStock en productos
							unidadesStock -= unidadesInOut;
							sentencia = conexion.prepareStatement("update productos set unidades =? where idProducto=?");
							sentencia.setInt(1, unidadesStock);
							sentencia.setInt(2, idProducto);
							sentencia.executeUpdate();

						} else {
							if(unidadesInOut<=0) {
								JOptionPane.showMessageDialog(null, "El número de unidades que se venden tiene que ser mayor que 0.",
										"Error", JOptionPane.ERROR_MESSAGE);
								
							}else {
							JOptionPane.showMessageDialog(null, "No hay unidades disponibles del producto escogido",
									"Error", JOptionPane.ERROR_MESSAGE);
							}
							grabarMov = false;

						}

					}

					if (grabarMov) {
						// para obter o numMov do novo movemento
						sentencia = conexion.prepareStatement("select MAX(numMov) as maxNumMov from movimientos");
						resultado = sentencia.executeQuery();

						if (resultado.next()) {
							numMov = resultado.getInt("maxNumMov") + 1;
							System.out.println(numMov);
						}

						// INSERT
						sentencia = conexion.prepareStatement(
								"insert into movimientos (numMov,fechaMov,idProducto,pCoste,pVenta,unidades,tipoMov) values(?,?,?,?,?,?,?)");
						sentencia.setInt(1, numMov);
						sentencia.setString(2, fecha);
						sentencia.setInt(3, idProducto);
						sentencia.setFloat(4, pCoste);
						sentencia.setFloat(5, pVenta);
						sentencia.setInt(6, unidadesInOut);
						sentencia.setString(7, tipoMov);
						sentencia.execute();

						/*******************************************************************************/
						// meto o SELECT e o resulset para comprobacións (QUITAR E tamén os sysouts)
						/*sentencia = conexion.prepareStatement("select * from movimientos");
						resultado = sentencia.executeQuery();

						while (resultado.next()) {
							System.out.println(resultado.getInt(1));
							System.out.println(resultado.getString(2));
							System.out.println(resultado.getInt(3));
							System.out.println(resultado.getFloat(4));
							System.out.println(resultado.getFloat(5));
							System.out.println(resultado.getInt(6));
							System.out.println(resultado.getString(7));

						}*/

						/************************************************************************************/
						JOptionPane.showMessageDialog(null,
								"El movimiento ha sido grabado en la base de datos correctamente", "Confirmación", 1);
						TablaMovimientos v1 = new TablaMovimientos();
						TablaProductos v2 = new TablaProductos();
						v1.setVisible(true);
						v1.setLocation(0, 0);
						v2.setVisible(true);
						v2.setLocation(1170, 0);

					}
					resultado.close();
					sentencia.close();
					conexion.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch (NumberFormatException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "El valor numérico introducido es incorrecto", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Hay campos vacíos, debe rellenar todos los campos", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {

			vta.dispose();
			System.exit(0);
		}

	}
}