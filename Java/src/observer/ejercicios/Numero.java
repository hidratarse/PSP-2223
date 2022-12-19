package observer.ejercicios;

import observer.ejercicios.ControladorDePrimos.Primo;

public class Numero implements Primo {
	int valor;

	public Numero(int valor) {
		this.valor = valor;
	}

	public Numero() {
	}

	@Override
	public void update(int event) {
		if (esPrimo(event)) {
			System.out.println(event);
		}
	}

	private boolean esPrimo(int n) {
		int factors = 0;
		int j = 1;

		while (j <= n) {
			if (n % j == 0) {
				factors++;
			}
			j++;
		}
		return (factors == 2);
	}
}
