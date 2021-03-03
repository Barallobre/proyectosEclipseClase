package base;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Ventana extends JFrame {

	private JPanel contentPane;
	JTextField idDesde;
	JTextField idHasta;
	JButton enviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 108);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		enviar = new JButton("Mostrar informe");
		contentPane.add(enviar, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel Desde = new JLabel("Desde");
		panel.add(Desde);

		idDesde = new JTextField();
		panel.add(idDesde);
		idDesde.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Hasta");
		panel.add(lblNewLabel_1);

		idHasta = new JTextField();
		panel.add(idHasta);
		idHasta.setColumns(10);
	}

	public void asignarEscuchador(Escuchador e) {
		enviar.addActionListener(e);

	}
}
