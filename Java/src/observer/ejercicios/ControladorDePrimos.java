package observer.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class ControladorDePrimos {

	private final int MINIMO = 1000;
	private final int MAXIMO = 2000;

	public interface Primo {
		void update(int event);
	}

	private final List<Primo> observers = new ArrayList<>();

	private void notifyObservers(int event) {
		observers.forEach(o -> o.update(event));
	}

	public void addObserver(Primo observer) {
		observers.add(observer);
	}

	public void inputs() {
		for (int i = MINIMO; i < MAXIMO; i++) {
			notifyObservers(i);
		}
	}
}
