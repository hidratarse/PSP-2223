package Ejercicios.Ejercicio_1_6;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class Entrada {
	public static void main(String[] args) throws IOException {
		
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio_1_6");
		
		pb.directory(directorio);
		
		Process p = pb.start();
		
		OutputStream os=p.getOutputStream();
		
		os.write("5\n".getBytes());
		os.write("5\n".getBytes());
		os.flush();
	}
}
