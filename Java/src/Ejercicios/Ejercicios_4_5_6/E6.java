package Ejercicios.Ejercicios_4_5_6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class E6 {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		
		System.out.println("La cadena es:"+str);
		
		File salida = new File("salida.txt");
		File path = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicios.Ejercicios_4_5_6.E5",str);
		pb.directory(path);
		
		pb.redirectOutput(salida);
		
		pb.start();		
	}
}
