package tema_2.ejercicios.banco;

public class Movimientos extends Thread {
	private Cuenta c;
	public Movimientos(String n , Cuenta c) {
		super(n);
		this.c = c;
	}
	public void run() {
		for (int x=0;x<2;x++){
			c.ingreso(500, getName());
			c.reintegro(800, getName());
		}
	}
}