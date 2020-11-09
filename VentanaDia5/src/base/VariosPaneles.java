package base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VariosPaneles extends JFrame {
	public VariosPaneles() {
		super("Varios Paneles");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelCentro = new JPanel();
		JPanel panelSur = new JPanel();

		BoxLayout distr1 = new BoxLayout(panelCentro, BoxLayout.Y_AXIS);
		panelCentro.setLayout(distr1);
		BoxLayout distr2 = new BoxLayout(panelSur, BoxLayout.X_AXIS);
		panelSur.setLayout(distr2);

		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		JButton b5 = new JButton("b5");
		JButton b6 = new JButton("b6");

		panelCentro.add(b1);
		panelCentro.add(b2);
		panelCentro.add(b3);
		panelSur.add(b4);
		panelSur.add(b5);
		panelSur.add(b6);
		
		this.add(panelCentro, BorderLayout.CENTER);
		this.add(panelSur, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		VariosPaneles ventana = new VariosPaneles();
		ventana.setVisible(true);
	}

}
