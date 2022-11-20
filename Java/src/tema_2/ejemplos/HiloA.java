package tema_2.ejemplos;

class HiloA extends Thread {
	private Contador contador;
	public HiloA (String n , Contador c) {
		setName(n);
		contador = c ;
	}
	
	public void run(){
		for (int j = 0; j < 200; j++) {
			// 2º.- Posible sincro
			synchronized (contador) {
				contador.incrementa();
			}
			try {
				sleep(10);
			} catch (InterruptedException e ) {}
		}
	}
}
