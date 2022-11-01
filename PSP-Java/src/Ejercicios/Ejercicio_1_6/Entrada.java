package Ejercicios.Ejercicio_1_6;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Entrada {
	public static void main(String[] args) throws IOException {
		
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "Ejercicios.Ejercicio_1_6.Salida");
		pb.directory(directorio);
		
		System.out.printf("Directorio de trabajo: %s%n",pb.directory());
		Process p = pb.start();
		
		OutputStream os=p.getOutputStream();
		
		os.write("5\n".getBytes());
		os.write("5\n".getBytes());
		os.flush();
		
		InputStream is=p.getInputStream();
		
		int c;
		while ((c = is.read()) != -1) {
			System.out.print((char) c);
		}
		is.close();
	}
}
