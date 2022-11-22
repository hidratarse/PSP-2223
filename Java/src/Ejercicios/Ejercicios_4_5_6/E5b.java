package Ejercicios.Ejercicios_4_5_6;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class E5b {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		
		System.out.println("La cadena es:"+str);
		
		File path = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicios.Ejercicios_4_5_6.E5",str);
		pb.directory(path);
		Process p = pb.start();
		
		InputStream is=p.getInputStream();
		
		int c;
		while ((c = is.read()) != -1) {
			System.out.print((char) c);
		}
		is.close();
		
		int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
