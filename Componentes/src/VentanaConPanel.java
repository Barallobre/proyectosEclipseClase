import java.awt.FlowLayout;

import javax.swing.JFrame;

public class VentanaConPanel extends JFrame {

	public VentanaConPanel() {
		super("Información del disco");
		setSize(500, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		PanelEspacioEnDisco miPanel = new PanelEspacioEnDisco();
		getContentPane().add(miPanel);
		setVisible(true);
	}

	public static void main(String[] args) {
		VentanaConPanel vta = new VentanaConPanel();
	}
}
