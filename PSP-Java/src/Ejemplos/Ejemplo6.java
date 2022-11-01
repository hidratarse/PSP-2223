package Ejemplos;
import java.io.*;
import java.util.*;

public class Ejemplo6 {
	public static void main(String args[]) {
		
		//File directorio = new File(".\\bin");
		
		ProcessBuilder test = new ProcessBuilder();
		Map<?, ?> entorno = test.environment();
		System.out.println("Variables de entorno:");
		System.out.println(entorno);

		test = new ProcessBuilder("java", "LeerNombre", "Maria Jes�s");		
		
		// devuelve el nombre del proceso y sus argumentos
		List<?> l = test.command();
		Iterator<?> iter = l.iterator();
		System.out.println("\nArgumentos del comando:");
		while (iter.hasNext())
			System.out.println(iter.next());

		// ejecutamos el comando DIR
		test = test.command("CMD", "/C", "DIR");
		try {
			Process p = test.start();
			InputStream is = p.getInputStream();
		    
			System.out.println();
			// mostramos en pantalla caracter a caracter
			 int c;
			 while ((c = is.read()) != -1)
				System.out.print((char) c);
			 is.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}// Ejemplo6