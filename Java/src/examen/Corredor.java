package examen;

public class Corredor implements Runnable {
	
	public final int META = 1000;
	
	public final int MINIMO = 50;
	
	public final int MAXIMO =100;
	
	public Carrera carrera;

	private Aviso aviso;
	
	private int dorsal;
	
	private int metros;
	
	public Corredor(int dorsal, Aviso aviso) {
		this.dorsal=dorsal;
		this.setAviso(aviso);
		this.metros = 0;
	}
	
	public Aviso getAviso() {
		return aviso;
	}

	public void setAviso(Aviso aviso) {
		this.aviso = aviso;
	}
	
	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	public int getMetros() {
		return metros;
	}

	public void setMetros(int metros) {
		this.metros = metros;
	}
	
	public synchronized void  avance() {
		try {
			int rando=numAleatorio();
			System.out.println("SOY EL DORSAL "+dorsal+" Y HE AVANZADO "+rando+" METROS");
			setMetros(rando+getMetros());
			int dormirRando=numAleatorio();
			Thread.sleep(dormirRando);
			if (getMetros()>META) {
				System.out.println("HE CRUZADO LA META SOY EL DORSAL: "+dorsal);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int numAleatorio() {
		return (int)(Math.random()*MAXIMO)+MINIMO;
	}
	
	@Override
	public void run() {
		while (!aviso.isEmpezado()) {
			synchronized (aviso) {
				try {
					aviso.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		while (getMetros()<1000) {
			avance();
		}
		synchronized (aviso) {
			aviso.notifyAll();
		}
	}
}
