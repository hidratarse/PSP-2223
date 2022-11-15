package tema_2.ejercicios.meadero;

public class Baño {
	private int c = 0; //atributo contador
		Baño (int c) {
		this.c = c;
	}
	
	// 3º.- Posible sincro
	public void ocupado() {
		int tmp = c;
		tmp = tmp + 1;
		c = tmp;
	}
	
	// 3º.- Posible sincro
	public void desocupado() {
		int tmp = c;
		tmp = tmp - 1;
		c = tmp;
	}
	
	public int ocupación() {
		return c;
	}

}
