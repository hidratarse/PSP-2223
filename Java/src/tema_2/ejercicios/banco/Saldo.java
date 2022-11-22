package tema_2.ejercicios.banco;

public class Saldo {
	public static void main(String[] args) {
		Cuenta c = new Cuenta(400) ;
		Movimientos h1  = new Movimientos("Miguel", c);
		Movimientos h2 = new Movimientos ("Montse", c);
		h1.start() ;
		h2.start();
	}
}