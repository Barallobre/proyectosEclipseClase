package base2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import EscuchaBoton;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
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

public class Agencia1 extends JFrame {

	private JPanel contentPane;
	JTextField txtNombre;
	JComboBox cmbDestino;
	JCheckBox chkComer;
	JCheckBox chkCopas;
	JCheckBox chkNadar;
	JCheckBox chkCallejear;
	JCheckBox chkCompras;
	JCheckBox chkMuseos;

	JButton btnAceptar;
	JButton btnCancelar;

	public Agencia1() {
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
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3mo te llamas");
		lblNewLabel_1.setPreferredSize(new Dimension(120, 13));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1.setDisplayedMnemonic('m');
		panel_4.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setPreferredSize(new Dimension(140, 19));
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, 10));
		panel_4.add(txtNombre);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		p1Cabecera.add(panel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Selecciona un destino");
		lblNewLabel_2.setPreferredSize(new Dimension(120, 13));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_2.setDisplayedMnemonic('d');
		panel_5.add(lblNewLabel_2);
		
		cmbDestino = new JComboBox();
		cmbDestino.setPreferredSize(new Dimension(140, 21));
		cmbDestino.setFont(new Font("Verdana", Font.PLAIN, 10));
		cmbDestino.setModel(new DefaultComboBoxModel(new String[] {"Barcelona", "Granada", "Madrid", "Tenerife", "Mallorca"}));
		panel_5.add(cmbDestino);
		
		JPanel panel_6 = new JPanel();
		p1Cabecera.add(panel_6);
		
		JLabel lblNewLabel_3 = new JLabel("<html><p style=\"margin:10 0 10 0\">Dinos qu\u00E9 te gusta:</p></html>");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_6.add(lblNewLabel_3);
		
		JPanel p2 = new JPanel();
		contentPane.add(p2, BorderLayout.WEST);
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		
		JPanel p2Gustos = new JPanel();
		p2.add(p2Gustos);
		p2Gustos.setLayout(new GridLayout(0, 3, 0, 0));
		
		chkComer = new JCheckBox("Comer");
		chkComer.setMnemonic('c');
		chkComer.setFont(new Font("Verdana", Font.PLAIN, 10));
		p2Gustos.add(chkComer);
		
		chkCopas = new JCheckBox("Ir de copas");
		chkCopas.setMnemonic('i');
		chkCopas.setFont(new Font("Verdana", Font.PLAIN, 10));
		p2Gustos.add(chkCopas);
		
		chkNadar = new JCheckBox("Nadar");
		chkNadar.setMnemonic('n');
		chkNadar.setFont(new Font("Verdana", Font.PLAIN, 10));
		p2Gustos.add(chkNadar);
		
		chkCompras = new JCheckBox("Comprar");
		chkCompras.setMnemonic('r');
		chkCompras.setFont(new Font("Verdana", Font.PLAIN, 10));
		p2Gustos.add(chkCompras);
		
		chkCallejear = new JCheckBox("Callejear");
		chkCallejear.setMnemonic('j');
		chkCallejear.setFont(new Font("Verdana", Font.PLAIN, 10));
		p2Gustos.add(chkCallejear);
		
		chkMuseos = new JCheckBox("Ver museos");
		chkMuseos.setMnemonic('v');
		chkMuseos.setFont(new Font("Verdana", Font.PLAIN, 10));
		p2Gustos.add(chkMuseos);
		
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
