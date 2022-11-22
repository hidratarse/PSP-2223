package Ejercicios.kaylercabron;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Ejecutor {
	public static void main(String[] args) throws IOException {
		File direc = new File(".\\bin");
		if (args.length==0) {
			ProcessBuilder pb= new ProcessBuilder("java","Ejercicios.kaylercabron.Generador");
			
			pb.directory(direc);
			
			Process p=pb.start();
			
			InputStream is=p.getInputStream();
			
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
		}else {
			System.out.println("NUMERO GENERADO"+args[0]);
		}
	}
}
