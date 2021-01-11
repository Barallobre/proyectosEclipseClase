

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;


public class VentanaAlta extends JFrame {
	
	public JPanel contentPane;
	public JTextField tf_ID_prod;
	public JTextField tf_nombre;
	public JButton btn_alta;
	public JButton btn_cancelar;



	public VentanaAlta() {
		setTitle("Alta Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_centro = new JPanel();
		contentPane.add(panel_centro, BorderLayout.CENTER);
		panel_centro.setLayout(new BoxLayout(panel_centro, BoxLayout.Y_AXIS));
		
		JPanel panel_id = new JPanel();
		panel_centro.add(panel_id);
		
		JLabel lblNewLabel = new JLabel("Introduzca ID producto:");
		lblNewLabel.setPreferredSize(new Dimension(150, 14));
		panel_id.add(lblNewLabel);
		
		tf_ID_prod = new JTextField();
		tf_ID_prod.setPreferredSize(new Dimension(150, 20));
		panel_id.add(tf_ID_prod);
		
		JPanel panel = new JPanel();
		panel_centro.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre producto:");
		lblNewLabel_1.setPreferredSize(new Dimension(150, 14));
		panel.add(lblNewLabel_1);
		
		tf_nombre = new JTextField();
		tf_nombre.setPreferredSize(new Dimension(150, 20));
		tf_nombre.setMinimumSize(new Dimension(150, 20));
		panel.add(tf_nombre);
		
		JPanel panel_sur = new JPanel();
		contentPane.add(panel_sur, BorderLayout.SOUTH);
		
		btn_alta = new JButton("Dar de alta");
		panel_sur.add(btn_alta);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setPreferredSize(new Dimension(85, 23));
		panel_sur.add(btn_cancelar);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("<html><br>ALMACEN CH\u00CDOS S.L.<br><br></html>");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(lblNewLabel_2);
	}
	
	public void conectaEscuchaBoton(EscuchaBotonAlta eb) {
		btn_alta.addActionListener(eb);
		btn_cancelar.addActionListener(eb);

	}

}
