package Ejercicios.Ejercicio_1_6;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class Entrada {
	public static void main(String[] args) throws IOException {
		
		File directorio = new File("C:\\Users\\migue\\Documents\\GitHub\\PSP-2223\\PSP-Java\\bin\\Ejercicios\\Ejercicio_1_6");
		ProcessBuilder pb = new ProcessBuilder("java", "Salida");
		pb.directory(directorio);
		
		System.out.printf("Directorio de trabajo: %s%n",pb.directory());
		Process p = pb.start();
		
		OutputStream os=p.getOutputStream();
		
		os.write("5\n".getBytes());
		os.write("5\n".getBytes());
		os.flush();

	}
}
