package base;

import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClienteChat extends JFrame implements ActionListener, Runnable{
private static final long serialVersionUID = 1L;
Socket socket = null;

//streams
DataInputStream fentrada;//PARA LEER LOS MENSAJES
DataOutputStream fsalida;//PARA ESCRIBIR MENSAJES

String nombre;
static JTextField mensaje = new JTextField();

private JScrollPane scrollpanel;
static JTextArea textarea1;
JButton botonEnviar = new JButton("Enviar");
JButton botonSalir = new JButton("Salir");
boolean repetir = true;

//constructor
public ClienteChat(Socket s, String nombre) {
	super("CONEXIÓN DEL CLIENTE CHAT: "+nombre);
	setLayout(null);
	mensaje.setBounds(10,10,400,30);
	add(mensaje);
	
	textarea1 = new JTextArea();
	scrollpanel = new JScrollPane(textarea1);
	scrollpane1.setBounds(10, 50, 400, 300);
	add(scrollpane1);
	
	botonEnviar.setBounds(420,10,100,30);
	add(botonEnviar);
	botonSalir.setBounds(420,50,100,30);
	add(botonSalir);
	
	textarea1.setEditable(false);
	botonEnviar.add
}
}























































