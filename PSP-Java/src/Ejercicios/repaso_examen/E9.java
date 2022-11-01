package Ejercicios.repaso_examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class E9 {
	
	public static void main(String[] args) throws IOException {
		
		ProcessBuilder pb = new ProcessBuilder("CMD");
		
		File directorio = new File(".\\bin");
		File fichero = new File("entrada.txt");
		File error = new File("error.txt");
		File eProceso = new File("ficheroP.bat");
		
		pb.redirectInput(eProceso);
		pb.directory(directorio);
		pb.redirectError(error);
				
		Process p = pb.start();
		
		BufferedReader br = new BufferedReader(new FileReader(fichero));
		
		String str = br.readLine();
		br.close();
		
		System.out.println("Cadena a enviar "+str);
		
		OutputStream os=p.getOutputStream();
		
		os.write((str+"\n").getBytes());
		os.flush();
		
		InputStream is=p.getInputStream();
		
		int c;
		while ((c = is.read()) != -1) {
			System.out.print((char) c);
		}
		is.close();
	}
}
