package tema_2.ejercicios.meadero;

public class Baño {

	private boolean ocu;
	
	public Baño() {
		ocu = false;
	}
	
	public boolean ocupado() {
		return ocu;
	}

	public void entra() {
		ocu = true;
	}

	public void sal() {
		ocu = false;
	}
}