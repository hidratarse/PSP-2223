package observer.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class ControladorDePrimos {
	
	public interface Primo{
		void update(int event);
	}
	
	private final List<Primo> observers = new ArrayList<>();
	
	private void notifyObservers(int event) {	
		observers.forEach(o->o.update(event));
	}
	
	public void addObserver(Primo observer) {
		observers.add(observer);
	}
	
	public void inputs() {
		for (int i = 0; i <20; i++) {
			notifyObservers(i);
		}
		/*Scanner sc=new Scanner(System.in);
		while (sc.hasNext()) {
			int num=Integer.parseInt(sc.nextLine());
			notifyObservers(num);
		}
		sc.close();*/
	}
}
