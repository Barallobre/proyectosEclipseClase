
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EscuchaBotonAlta implements ActionListener {
	VentanaAlta vta;
	Integer id;
	String producto;
	ArrayList<String> listado = new ArrayList<String>();

	public EscuchaBotonAlta(VentanaAlta v) {
		vta = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vta.btn_alta) {

			producto = vta.tf_nombre.getText();
			
			if (producto.isEmpty() || vta.tf_ID_prod.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe introducir todos los datos para dar de alta un nuevo producto", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {

				try {
					id = Integer.parseInt(vta.tf_ID_prod.getText());
					vta.tf_nombre.setText("");
					vta.tf_ID_prod.setText("");
					Connection conexion = conexionSQL.conectar();
					PreparedStatement sentencia = conexion
							.prepareStatement("insert into productos (idProducto,nombre) values(?,?)");
					sentencia.setInt(1, id);
					sentencia.setString(2, producto);
					sentencia.execute();
					VentanaMantenimiento.cb_articulos.removeAllItems();
					listado = conexionSQL.encher_combo();
					System.out.println(listado);
					for (int i = 0; i < listado.size(); i++) {
						VentanaMantenimiento.cb_articulos.addItem(listado.get(i));
					}
					VentanaMantenimiento.cb_articulos.addItem(">> Nuevo artículo <<");
					VentanaMantenimiento.cb_articulos.setSelectedItem(producto);
					System.out.println("combo actualizado");
					sentencia.close();
					conexion.close();
					vta.dispose();

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error no acceso á base de datos", "Error",
							JOptionPane.ERROR_MESSAGE);
					
				
				}catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "A id de producto debe ter formato numérico", "Error",
							JOptionPane.ERROR_MESSAGE);
					
				}
			}
			
		} else {
			listado = conexionSQL.encher_combo();
			System.out.println(listado);
			for (int i = 0; i < listado.size(); i++) {
				VentanaMantenimiento.cb_articulos.addItem(listado.get(i));
			}
			VentanaMantenimiento.cb_articulos.addItem(">> Nuevo artículo <<");
			vta.dispose();
		}
	}

}