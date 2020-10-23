package base;

public class Principal {

	public static void main(String[] args) {
		
		
		for(int i=0;i<100;i++)
		System.out.println(esPrimo(i));
}
	public static String esPrimo(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return "noEsPrimo";
	    }
	    return "esPrimo";
	}
}
