package Ejercicios;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RedirectInput {
	public static void main(String[] args) throws IOException {
		
		File entrada= new File("entrada.txt");
		File salida = new File("salida.txt");
		File path = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicios.Ejercicios_4_5_6.E5");
		pb.directory(path);
		
		pb.redirectOutput(salida);
		pb.redirectInput(entrada);
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		
		System.out.println("La cadena es:"+str);
		
		pb.start();		
	}
}
