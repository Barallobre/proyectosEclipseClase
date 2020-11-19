//Hay un objeto de datos(fichero de texto) que es utilizado por varios procesos, unos leen y otro que escribe.
//
//Solo puede utilizar el recurso un proceso y solo uno, es decir, 
//o bien un proceso estar� escribiendo o bien leyendo, pero nunca ocurrir� simult�neamente.
//
//Consideraciones:
//
//Se considera a cada usuario(lector y escritor) como dos procesos 
//y al fichero en cuesti�n como un recurso. 
//De modo que, para que un proceso acceda al recurso que necesita, 
//tenemos que considerar a cada usuario (lector y escritor) como dos sem�foros. 
//Estos sem�foros son binarios: el recurso (fichero) est� siendo utilizado por otro proceso y el recurso est� disponible.

package base;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
