package tema_2.ejemplos;

public class Hilo implements Runnable {
	
	public void run() {
		for (int i=0; i<5;i++ )
			System.out.println("En el Hilo .. . ");
	}


	//Para usar el hilo creo la clase UsaHilo:

	public static void main(String[] args){
		Hilo hs = new Hilo();
		Thread t = new Thread(hs);
		t.start();
		for (int i=0; i<5;i++)
			System.out.println("Fuera del hilo ..");
	}
}