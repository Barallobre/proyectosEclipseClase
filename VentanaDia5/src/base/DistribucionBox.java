package base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DistribucionBox extends JFrame {
	public DistribucionBox() {
		super("Distribucion Box Layout");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BoxLayout distr = new BoxLayout(getContentPane(),BoxLayout.Y_AXIS);
		this.setLayout(distr);
		
		
		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		JButton b5 = new JButton("b5");
		
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
	}

	public static void main(String[] args) {
		DistribucionBox ventana = new DistribucionBox();
		ventana.setVisible(true);
	}

}
