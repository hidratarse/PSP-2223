package tema_2.ejercicios.futbolchusta;

import java.time.LocalTime;

import javax.swing.JLabel;

public class Futbol implements Runnable{
	
	private static final long INTERVALO = 1;
	
	JLabel _salida;
	Object _sync;
	
	public Futbol(JLabel salida, Object sync) {
		_salida=salida;
		_sync=sync;
	}
	
	private void parar() {
		synchronized(_sync){
			try {
				_sync.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
	
	public String firstTwo(String str) {
	    return str.length() < 2 ? str : str.substring(0, 2);
	}

	@Override
	public void run() {
		
		parar();
		
		String hora;
		String minuto;
		String segundos;
		String nano;
		
		while (true) {
			LocalTime tiempo = java.time.LocalTime.now();
			hora = Integer.toString(tiempo.getHour());
			minuto = Integer.toString(tiempo.getMinute());
			segundos = Integer.toString(tiempo.getSecond());
			nano = Integer.toString(tiempo.getNano());
			
			nano = firstTwo(nano);
			
			_salida.setText(hora+":"+minuto+":"+segundos+":"+nano);
			
			try {
				Thread.sleep(INTERVALO);
			} catch (InterruptedException e) {
				//e.printStackTrace();
				parar();
			}
		}
	}

}
