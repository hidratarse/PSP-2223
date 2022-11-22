package tema_2.ejercicios.banco;

public class Cuenta {
	private int saldo;

	Cuenta (int s){ 
		saldo = s;
	}
	
	int getSaldo(){ 
		return saldo;
	}
	
	void sumar(int cantidad) {
		saldo = saldo+cantidad;
	}
	
	void restar(int cantidad) {
		saldo = saldo-cantidad;
	}
	
	synchronized void ingreso(int cant, String nom) {
		System.out.println("SE VA A INGRESAR SALDO (ACTUAL ES : " + getSaldo() + ")");
		try {
			Thread.sleep(1000) ;
		} catch (InterruptedException ex) { }
		sumar(cant);
		System.out.println("\t"+nom+" ingresa => "+cant+" euros SALDO ACTUAL AHORA ES : ("+getSaldo()+")");
	}
	synchronized void reintegro(int cant, String nom) {
		if ((getSaldo()>=cant)){
			System.out.println("SE VA A RETIRAR SALDO (ACTUAL ES : "+getSaldo()+")");
			try {
				Thread.sleep(1000) ;
			} catch (InterruptedException ex) { }
			restar(cant);
			System.out.println("\t"+nom+" retira => "+cant+" euros SALDO ACTUAL("+getSaldo()+")");
		}else {
			System.out.println(nom+" no puede retirar "+cant+" euros : SALDO ACTUAL("+getSaldo()+") NO HAY SUFICIENTE DINERO");
		}
		if (getSaldo()< 0){
			System.out.println("SALDO NEGATIVO => "+getSaldo());
		}
	}
} //Clase Cuenta