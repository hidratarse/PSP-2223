package tema_2.ejemplos;

class HiloB extends Thread {
	private Contador contador;
	public HiloB(String n , Contador c) {
		setName(n);
		contador = c;
	}
	
	public void run(){
		for (int j = 0; j < 300; j++) {
			// 2º.- Posible sincro
			synchronized (contador) {
				contador.decrementa();
			}
			try {
				sleep(10);
			}catch (InterruptedException e) {}
		}
	}
}//FIN HILOB