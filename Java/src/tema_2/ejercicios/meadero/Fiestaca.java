package tema_2.ejercicios.meadero;

public class Fiestaca {
	public static void main(String[] args) {
		Baño wc = new Baño();
		new Thread(new Persona(1, wc)).start();
		new Thread(new Persona(2, wc)).start();
		new Thread(new Persona(3, wc)).start();
	}
}
