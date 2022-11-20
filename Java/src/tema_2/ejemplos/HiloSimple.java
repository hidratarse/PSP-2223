package tema_2.ejemplos;

public class HiloSimple extends Thread {
	
	public void run() {
		for (int i=0; i<5;i++ )
			System.out.println("En el Hilo .. . ");
	}


	//Para usar el hilo creo la clase UsaHilo:

	public static void main(String[] args){
		HiloSimple hs = new HiloSimple();
		hs.start();
		for (int i=0; i<5;i++)
			System.out.println("Fuera del hilo ..");
	}
}