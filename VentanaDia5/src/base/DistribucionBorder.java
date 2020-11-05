package base;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DistribucionBorder extends JFrame {
	public DistribucionBorder() {
		super("Distribucion Border Layout");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//BorderLayout distr = new BorderLayout();
		//this.setLayout(distr);
		//por defecto los JFrame tienen la distribución border layout
		
		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		JButton b5 = new JButton("b5");
		
		this.add(b1, BorderLayout.NORTH);
		this.add(b2, BorderLayout.SOUTH);
		this.add(b3, BorderLayout.EAST);
		this.add(b4, BorderLayout.WEST);
		this.add(b5, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		DistribucionBorder ventana = new DistribucionBorder();
		ventana.setVisible(true);
	}

}
