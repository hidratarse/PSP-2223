package tema_2.ejercicios.futbolchusta;

import java.time.LocalTime;

import javax.swing.JLabel;

public class Futbol implements Runnable{
	
	JLabel _salida;
	int cont = 0;
	
	public Futbol(JLabel salida) {
		_salida=salida;
	}
	
	public String firstTwo(String str) {
	    return str.length() < 2 ? str : str.substring(0, 2);
	}

	@Override
	public void run() {
		
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
		}
	}

}
