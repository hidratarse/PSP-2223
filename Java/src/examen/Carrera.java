package examen;

public class Carrera {
	
	public final static int NUMPARTICIPANTES = 10;
	
	public final static int COUNTDOWN= 250;
	
	public static void main(String[] args) {
		
		Aviso aviso = new Aviso();
		
		for(int i=0; i<=NUMPARTICIPANTES; i++) {
			new Thread(new Corredor(i, aviso)).start();
			System.out.println("CREADO EL DORSAL"+i);
		}
		synchronized (aviso) {
			try {
				Thread.sleep(COUNTDOWN);
				System.out.println("...................3");
				Thread.sleep(COUNTDOWN);
				System.out.println("...................2");
				Thread.sleep(COUNTDOWN);	
				System.out.println("...................1");
				Thread.sleep(COUNTDOWN);
				System.out.println("EMPIEZA LA CARRERA ");
				aviso.setEmpezado(true);
				aviso.notifyAll();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<=NUMPARTICIPANTES; i++) {
			synchronized (aviso) {
				try {
					aviso.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("CARRERA ACABADA");
	}
}
