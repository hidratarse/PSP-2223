package tema_2.ejercicios.almacen;

public class Mercado {
	public static void main(String[] args) {
		
		Almacen a= new Almacen();
		
		Cliente paco = new Cliente("Paco", a);
		new Thread(paco).start();
		
		Cliente carmen = new Cliente("Carmen", a);
		new Thread(carmen).start();
	
		System.out.println("All the threads are started");
	}
}
