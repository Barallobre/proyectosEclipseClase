package base;

public class Excepcion3 {

	public static void main(String[] args) {
		int[] lista = {1,2,3};
		try {
		System.out.println(lista[3]);
		System.out.println(lista[1]/0);
		}catch(IndexOutOfBoundsException | ArithmeticException e) {
			System.out.println(e.getMessage());
			System.out.println("Array fuera de rango o dividido entre 0.");
		}
	}

}
