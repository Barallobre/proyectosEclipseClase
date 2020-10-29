package base;

public class Principal {

	public static void main(String[] args) {
		String[] partescuenta = null;
		String resultado = "123+123";
		partescuenta = resultado.split("\\+");
		double resultadoFinal = Double.parseDouble(partescuenta[0]) + Double.parseDouble(partescuenta[1]);
		System.out.println(resultadoFinal);
	}

}
