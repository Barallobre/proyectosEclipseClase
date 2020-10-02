package base;

public class Excepcion5 {

	public static void main(String[] args) {
		
		int[] lista = {1,2,3};
		
		// Bloque 1
		//System.out.println(1/0);
		try {
		// Bloque 2
			System.out.println(1/0);
			System.out.println(lista[3]);
		} catch (ArithmeticException e1) {
		// Bloque 3
			System.out.println(e1.getMessage());
			System.out.println("La división no es correcta.");
		} catch (IndexOutOfBoundsException e2) {
		// Bloque 4
			System.out.println(e2.getMessage());
			System.out.println("El array se sale del rango.");
		}
		// Bloque 5

		/*
		// Bloque 1
		try {
		// Bloque 2
			System.out.println(1/0);
		} catch (ArithmeticException e1) {
		// Bloque 3
			System.out.println(lista[3]);
		} catch (Exception e) {
		// Bloque 4
			System.out.println(e.getMessage() + "El array se sale de rango.");
		} finally {
			System.out.println("Fin del código.");
		// Bloque 5
		}
		// Bloque 6
	*/
	}

}
