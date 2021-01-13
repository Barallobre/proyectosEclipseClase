import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class TablaProductos extends JFrame {


	public TablaProductos() {
		setTitle("Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 416);
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		Connection conexion = conexionSQL.conectar();
		PreparedStatement sentencia;
		ResultSet resultado;

		try {
			sentencia = conexion.prepareStatement("select * from productos");
			resultado = sentencia.executeQuery();

						
			modelo.addColumn("idProducto");
			modelo.addColumn("nombre");
			modelo.addColumn("unidades");
			modelo.addColumn("CMP");
			modelo.addColumn("TOTAL");
			

			while (resultado.next()) {

				Object[] fila = new Object[5];

				for (int i = 0; i < 4; i++) {
					fila[i] = resultado.getObject(i + 1);
				}
				
				fila[4]=(Integer.parseInt(resultado.getObject(3).toString())*Float.parseFloat(resultado.getObject(4).toString()))+" €";
				modelo.addRow(fila);

			}
			
		
			scrollPane.setViewportView(tabla);
		
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
