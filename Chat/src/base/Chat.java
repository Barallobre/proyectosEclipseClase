package base;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class Chat extends JFrame {

	private JPanel contentPane;
	public JTextField textoEnviado;

	static JButton botonEnviar;
	static JButton botonBorrar;
	public JTextArea textoRecogido;

	public Chat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		textoEnviado = new JTextField();
		panel.add(textoEnviado);
		textoEnviado.setColumns(10);

		botonEnviar = new JButton("Enviar");
		botonEnviar.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(botonEnviar);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textoRecogido = new JTextArea();
		scrollPane.setViewportView(textoRecogido);

		botonBorrar = new JButton("Borrar Chat");
		botonBorrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(botonBorrar, BorderLayout.SOUTH);

	}

	public void asignarEscuchador(Escuchador e) {
		botonEnviar.addActionListener(e);
		botonBorrar.addActionListener(e);

	}

}
