package Ejercicios.Ejercicios_4_5_6;

import java.io.File;
import java.io.IOException;

public class E4b {
	public static void main(String[] args) throws IOException {

		File directorio = new File("C:\\Users\\migue\\Documents\\GitHub\\PSP-2223\\PSP-Java\\bin\\Ejercicios\\Ejercicios_4_5_6");
		ProcessBuilder pb = new ProcessBuilder("java", "E4", "XD");
		pb.directory(directorio);
		
		System.out.printf("Directorio de trabajo: %s%n",pb.directory());
		Process p = pb.start();
		
		int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
