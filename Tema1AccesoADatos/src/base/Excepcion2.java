package base;

public class Excepcion2 {

	public static void main(String[] args) {
		int n1 = 5;
		
	
		
		try {
		System.out.println(n1/0);
		}catch(ArithmeticException e){
			System.out.println("No se puede dividir entre 0");
		}catch(RuntimeException e){
			System.out.println("No se puede dividir entre 0");
		}
		
		//aparece una ArithmeticException, es una excepción marcada
	}

}
