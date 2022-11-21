package Ejemplos;

import java.io.InputStream;

public class JavaAC {
    public static void main(String[] args) {
           try {
               Process p = new ProcessBuilder("/home/miguel/PSP/PSP-2223/C/Ejercicios/pipeSeñal","pipeSeñal").start();
               InputStream is=p.getInputStream();
               int c;
               System.out.println("Antes del bucle");
               System.out.println();
               while((c=is.read())!=-1)
                   System.out.print((char)c);
               is.close();
           } catch (Exception e) {
               e.printStackTrace();
           }	   
              
          }
}

//Trabajar sobre esto