package tema_2.ejercicios;

public class PruebaHilo implements Runnable{
	
	int id;
	
	public PruebaHilo() {}
	
	public PruebaHilo(int id) {
		this.id=id;
	}
	
	public static void main(String[] args) {
		
		PruebaHilo pb = new PruebaHilo();
		Thread t = new Thread(pb);
		t.start();
		System.out.println("Soy el papá :)");
		Thread t2 = new Thread(pb);
		t2.start();
		Thread t3 = new Thread(pb);
		t3.start();
		Thread t4 = new Thread(pb);
		t4.start();
	}

	@Override
	public void run() {
		System.out.println("Soy el hijo "+Thread.currentThread().getId());
		
	}
}
