package Ejercicios.Ejercicios_4_5_6;

public class E4 {
	public static void main(String []args) {
		
		int n=args.length;
		
		if (n<1) {
			System.exit(14);
		} else if (args[0] instanceof String) {
			System.exit(2);
		} else if (Integer.parseInt(args[0])<0) {
			System.exit(3);
		} else {
			System.exit(0);
		}
	}
}
