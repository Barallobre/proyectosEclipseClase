import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana1 extends JFrame {

	private JPanel contentPane;
	private JTextField textDireccion;
	private JTextField textNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 frame = new Ventana1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana1() {
		setBounds(new Rectangle(200, 200, 400, 250));
		setResizable(false);
		setTitle("Primera ventana con WB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel subpanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) subpanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(subpanel, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Aceptar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textNombre.getText());
				System.out.println(textDireccion.getText());
			}
		});
		btnNewButton_1.setMnemonic('A');
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		subpanel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setMnemonic('C');
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		subpanel.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel Nombre = new JLabel("Nombre completo:");
		Nombre.setForeground(Color.DARK_GRAY);
		Nombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Nombre.setBounds(65, 120, 113, 14);
		panel.add(Nombre);
		
		JLabel Direccion = new JLabel("Direcci\u00F3n:");
		Direccion.setForeground(Color.DARK_GRAY);
		Direccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Direccion.setBounds(65, 53, 113, 14);
		panel.add(Direccion);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(214, 51, 153, 28);
		panel.add(textDireccion);
		textDireccion.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(214, 118, 153, 28);
		panel.add(textNombre);
		textNombre.setColumns(10);
	}
}
