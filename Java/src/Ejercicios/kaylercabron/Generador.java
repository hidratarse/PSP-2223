package Ejercicios.kaylercabron;

import java.io.File;
import java.io.IOException;

public class Generador {
	public static void main(String[] args) throws IOException {
		
		 int rando =(int)Math.random()*10;
		 
		 File direc = new File(".\\bin");
		 
		 System.out.println("NUMERO A ENVIAR"+rando);
		 
		 ProcessBuilder pb= new ProcessBuilder("java","Ejercicios.kaylercabron.Generador",Integer.toString(rando));
			
		 pb.directory(direc);
			
		 pb.start();
	}
}
