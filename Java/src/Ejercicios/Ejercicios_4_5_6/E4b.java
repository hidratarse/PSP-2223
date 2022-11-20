package Ejercicios.Ejercicios_4_5_6;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class E4b {
	public static void main(String[] args) throws IOException {

		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "Ejercicios.Ejercicios_4_5_6.E4","1");
		pb.directory(directorio);
		
		System.out.printf("Directorio de trabajo: %s%n",pb.directory());
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
