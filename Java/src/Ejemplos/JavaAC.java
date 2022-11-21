package Ejemplos;

import java.io.InputStream;

public class JavaAC {
	 public static void main(String[] args) {
		    try {
		        Process p = new ProcessBuilder("/home/sergiotap/Documentos/PSP/repaso/ejercicioC","ejercicioC").start();
		        InputStream is=p.getInputStream();
		        int c;
		        System.out.println("Antes del bucle");
		        System.out.println();
		        while((c=is.read())!=0)
		            System.out.print((char)c);
		        is.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }	   
			   
		   }
}

//Trabajar sobre esto