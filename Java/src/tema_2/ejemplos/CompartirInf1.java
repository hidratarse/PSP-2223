package tema_2.ejemplos;

public class CompartirInf1 {
	public static void main(String[] args) {
		Contador contador = new Contador(100);
		HiloA a = new HiloA( "HiloA", contador) ;
		HiloB b = new HiloB( "HiloB", contador);
		a.start();
		b.start();
		
		// 1º.- ¿Qué ocurre?
		try {
			a.join();
			b.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Contador vale " + contador.valor());
	}
}