package Ejercicios.Ejercicios_4_5_6;

public class E4 {
	public static void main(String []args) {
		
		System.out.println("Programa ejecutado");
		if(args.length==1) {
			System.out.println("argumentos =1");
			System.exit(1);
		}
		try {
			int num= Integer.valueOf(args[0]);
			if(num< 0) {
				System.out.println("menor que 0");
				System.exit(3);
			}
		}catch(Exception e) {
			System.out.println("cadena");
			System.exit(2);	
		}
		System.out.println("otra situacion");
		System.exit(0);
	}
}
