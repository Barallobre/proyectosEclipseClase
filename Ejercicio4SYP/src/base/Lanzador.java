package base;

public class Lanzador {

	public void lanzarSumador(Integer n1, Integer n2) {
		String clase = "base.Sumador";
		ProcessBuilder pb;
		try {
			//esto es el comando que se mete en el MSDos para lanzar el proceso
			pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());
			pb.start();
			System.out.println("n1: "+n1);
			System.out.println("n2: "+n2);
			System.out.println(pb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Lanzador l = new Lanzador();
		l.lanzarSumador(1, 51);
		l.lanzarSumador(51, 100);
		System.out.println("Ok");
	}
}
