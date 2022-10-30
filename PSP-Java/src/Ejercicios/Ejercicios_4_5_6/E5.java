package Ejercicios.Ejercicios_4_5_6;

public class E5 {

	public static void main(String[] args) {
		if (args.length!=0) for (int i = 0; i < 5; i++) System.out.println(args[i]);
		else {
			System.out.println("No se encuentra cadena");
			System.exit(1);
		}
	}

}
