package base;

public class EjemploHilo1 implements Runnable {
Thread t;
EjemploHilo1(){
	t=new Thread(this, "Nuevo Thread");
	System.out.println("Creado hilo: "+t);
	t.start();//Arranca el nuevo hilo de ejecución. Ejecuta run.
}
public void run() {
	System.out.println("Hola desde el hilo creado");
	System.out.println("Hilo finalizado");
}
}
