import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class TablaMovimientos extends JFrame {


	public TablaMovimientos() {
		setTitle("Movementos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 606);
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = new JTable(modelo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		Connection conexion = conexionSQL.conectar();
		PreparedStatement sentencia;
		ResultSet resultado;

		try {
			sentencia = conexion.prepareStatement("select * from movimientos");
			resultado = sentencia.executeQuery();
		
			modelo.addColumn("NºMov.");
			modelo.addColumn("fecha");
			modelo.addColumn("id Prod.");
			modelo.addColumn("precio Coste");
			modelo.addColumn("precio Venta");
			modelo.addColumn("Unidades");
			modelo.addColumn("Tipo Mov.");
			
	
			while (resultado.next()) {

				Object[] fila = new Object[7];

				for (int i = 0; i < 7; i++) {
					fila[i] = resultado.getObject(i + 1);
				}

				modelo.addRow(fila);

			}
			
			
			TableColumn columna = tabla.getColumn("NºMov.");
			columna.setPreferredWidth(30);
			columna = tabla.getColumn("fecha");
			columna.setPreferredWidth(90);
			columna = tabla.getColumn("id Prod.");
			columna.setPreferredWidth(30);
			columna = tabla.getColumn("precio Coste");
			columna.setPreferredWidth(30);
			columna = tabla.getColumn("precio Venta");
			columna.setPreferredWidth(30);
			columna = tabla.getColumn("Unidades");
			columna.setPreferredWidth(30);
			columna = tabla.getColumn("Tipo Mov.");
			columna.setPreferredWidth(30);
		
			scrollPane.setViewportView(tabla);
		
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
