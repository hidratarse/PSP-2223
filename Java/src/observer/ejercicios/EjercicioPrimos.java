package observer.ejercicios;

public class EjercicioPrimos {
	public static void main(String[] args) {

		ControladorDePrimos controlador = new ControladorDePrimos();

		Numero n = new Numero();

		controlador.addObserver(n);

		controlador.inputs();
	}
}
