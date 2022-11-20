package tema_2.ejercicios.meadero;

public class Persona implements Runnable{
	
	private int id;
	
	private boolean ocupado= false;
	
	Persona(int id) {
		this.id=id;
	}

	@Override
	public void run() {
		while (true) {
			try {
			System.out.println(id+"Fiesta");
			synchronized (this) {
				this.setOcupado(true);
				System.out.println(id+"ENTRO");
				System.out.println(id+"Salgo");
			}
			if (ocupado) {
				Thread.sleep(2000);
				setOcupado(false);
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
}
