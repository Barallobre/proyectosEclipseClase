package base2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Agencia2 extends JFrame {

	private JPanel contentPane;
	JTextArea txtArea;
	JButton btnAceptar;
	JButton btnCancelar;
	/**
	 * Create the frame.
	 * @param gustos 
	 * @param destino 
	 * @param nombre 
	 */
	public Agencia2(String nombre, String destino, String gustos) {
		setResizable(false);
		setTitle("Viajes Ch\u00EDos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel p3Botones = new JPanel();
		contentPane.add(p3Botones, BorderLayout.SOUTH);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnAceptar.setMnemonic('a');
		p3Botones.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnCancelar.setMnemonic('c');
		p3Botones.add(btnCancelar);
		
		JPanel p1Cabecera = new JPanel();
		contentPane.add(p1Cabecera, BorderLayout.NORTH);
		p1Cabecera.setLayout(new BoxLayout(p1Cabecera, BoxLayout.Y_AXIS));
		
		JPanel panel_3 = new JPanel();
		p1Cabecera.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("<html><p style=\"margin:10 0 10 0\">AGENCIA DE VIAJES CH\u00CDOS S.L.</p></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(270, 33));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		panel_3.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		p1Cabecera.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		p1Cabecera.add(panel_5);
		
		String cadena = "<html><p style=\"margin:0 0 0 10\">Hola " + nombre + ", te llevaremos a "+ destino +" a: </p> "+ gustos;
		JLabel lblNewLabel_2 = new JLabel(cadena);
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_2.setDisplayedMnemonic('d');
		panel_5.add(lblNewLabel_2);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		p1Cabecera.add(panel_6);
		
		JLabel lblNewLabel_3 = new JLabel("<html><p style=\"margin:4 0 4 0\">Cu\u00E9ntanos qu\u00E9 m\u00E1s te gustar\u00EDa hacer:</p></html>");
		lblNewLabel_3.setDisplayedMnemonic('d');
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_6.add(lblNewLabel_3);
		
		JPanel p2 = new JPanel();
		contentPane.add(p2, BorderLayout.WEST);
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		
		JPanel p2Gustos = new JPanel();
		p2.add(p2Gustos);
		p2Gustos.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		p2Gustos.add(scrollPane);
		
		txtArea = new JTextArea();
		txtArea.setPreferredSize(new Dimension(266, 22));
		txtArea.setRows(3);

		scrollPane.setViewportView(txtArea);

		
		JPanel p2Relleno = new JPanel();
		p2.add(p2Relleno);
		this.pack();
		this.setVisible(true);
	}

	public void conectaEscuchaBoton(EscuchaBoton eb) {
		btnAceptar.addActionListener(eb);
		btnCancelar.addActionListener(eb);
	}

}
