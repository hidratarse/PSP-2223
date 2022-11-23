package Ejercicios.repaso_examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class E9 {
	
	public static void main(String[] args) throws IOException {
		
		File directorio = new File(".\\bin");
		File cadenas = new File("cadeniyas.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(cadenas));
		
		ProcessBuilder pb = new ProcessBuilder("java", "Ejercicios.repaso_examen.E7");
		pb.directory(directorio);
		
		System.out.printf("Directorio de trabajo: %s%n",pb.directory());
		Process p = pb.start();
		
		OutputStream os=p.getOutputStream();
		
		String envio ="";
		while (!envio.contains("*")) {
			envio = br.readLine();
			os.write((envio+"\n").getBytes());
			os.flush();
		}
		br.close();
		
		InputStream is=p.getInputStream();
		
		int c;
		while ((c = is.read()) != -1) {
			System.out.print((char) c);
		}
		is.close();
	}
}
