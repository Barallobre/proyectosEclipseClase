import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.Panel;
import java.awt.Component;

public class VentanaMantenimiento extends JFrame {

	private JPanel contentPane;
	public JTextField tf_unidades;
	public JTextField tf_precio;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lb_precio;
	public JButton btn_aceptar;
	public JButton btn_cerrar;
	public static JComboBox<String> cb_articulos;
	public ArrayList<String> listado = new ArrayList<String>();
	public JRadioButton rb_compra;
	public JRadioButton rb_venta;
	public JButton btn_alta;
	public JButton btn_cancelar;
	

	public VentanaMantenimiento() {
		
		listado = conexionSQL.encher_combo();
		
		setTitle("Almacen Ch\u00EDos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("<html><br>ALMACEN CH\u00CDOS S.L.<br><br></html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));

		JPanel panel_3 = new JPanel();
		panel_5.add(panel_3);

		rb_compra = new JRadioButton("Compra");
		buttonGroup.add(rb_compra);
		panel_3.add(rb_compra);

		rb_compra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rb_compra.isSelected()) {
					lb_precio.setVisible(true);
					tf_precio.setVisible(true);
				}
			}
		});
		
		rb_venta = new JRadioButton("venta");
		buttonGroup.add(rb_venta);
		panel_3.add(rb_venta);
		
		rb_venta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rb_venta.isSelected()) {
					lb_precio.setVisible(false);
					tf_precio.setVisible(false);
				}
			}
		});

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);

		JLabel lblNewLabel_1_1 = new JLabel("<html>Art\u00EDculo<br></html>");
		lblNewLabel_1_1.setPreferredSize(new Dimension(60, 14));
		panel_6.add(lblNewLabel_1_1);

		
		cb_articulos = new JComboBox<String>();
		cb_articulos.setAlignmentX(Component.LEFT_ALIGNMENT);
		cb_articulos.removeAllItems(); 
		cb_articulos.setEditable(false);
		cb_articulos.setPreferredSize(new Dimension(150, 22));
		
		cb_articulos.addItem("");
		for (int i = 0; i < listado.size(); i++) {
			cb_articulos.addItem(listado.get(i));
		}
		cb_articulos.addItem(">> Nuevo artículo <<");
		cb_articulos.setSelectedItem("");
		
		panel_6.add(cb_articulos);

		cb_articulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cb_articulos.getSelectedItem().equals(">> Nuevo artículo <<")) {
					//String producto;
					cb_articulos.removeAllItems(); 
					VentanaAlta v1 = new VentanaAlta();
					EscuchaBotonAlta eb = new EscuchaBotonAlta(v1);
					v1.conectaEscuchaBoton(eb);
					v1.setLocation(1148, 296);
					v1.setVisible(true);
					System.out.println("???");
												
				}
			}
		});

		JPanel panel_2_2 = new JPanel();
		panel_5.add(panel_2_2);

		JLabel lb_unidades = new JLabel("<html>Unidades<br></html>");
		lb_unidades.setPreferredSize(new Dimension(60, 14));
		panel_2_2.add(lb_unidades);

		tf_unidades = new JTextField();
		tf_unidades.setPreferredSize(new Dimension(150, 20));
		panel_2_2.add(tf_unidades);

		JPanel panel_2_2_1 = new JPanel();
		panel_5.add(panel_2_2_1);

		lb_precio = new JLabel("<html>Precio<br></html>");
		lb_precio.setVisible(false);
		lb_precio.setPreferredSize(new Dimension(60, 14));
		panel_2_2_1.add(lb_precio);

		tf_precio = new JTextField();
		tf_precio.setVisible(false);
		tf_precio.setPreferredSize(new Dimension(150, 20));
		panel_2_2_1.add(tf_precio);

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.SOUTH);

		btn_aceptar = new JButton("Aceptar");

		btn_aceptar.setMnemonic('a');
		panel_4.add(btn_aceptar);

		btn_cerrar = new JButton("Cancelar");
		btn_cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_cerrar.setMnemonic('c');
		panel_4.add(btn_cerrar);
		
		Panel panel_2 = new Panel();
		panel_2.setPreferredSize(new Dimension(100, 100));
		contentPane.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon("chios.png"));
		lblNewLabel_1.setBounds(20,0, 100, 238);
		panel_2.add(lblNewLabel_1);
	}

	public void conectaEscuchaBoton(EscuchaBotonMantenimiento eb) {
		btn_aceptar.addActionListener(eb);
		btn_cerrar.addActionListener(eb);

	}
	
		
}
