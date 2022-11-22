package Ejemplos;

/*Vamos a utilizar la clase ProcessBuilder para arrancar procesos y los métodos start y waitFor. 
Al ejecutar el programa le pasaremos el nombre del fichero a ejecutar. 
Si fuera el bloc de notas podríamos añadirle la ruta del fichero que deseamos que abra o si no existe lo crea.*/

import java.io.*;
import java.util.*;

public class CreacionProceso
{
public static void main(String[] args) throws IOException
{
  if (args.length <= 0)
    {
      System.err.println("Se necesita un programa a ejecutar");
      System.exit(-1);
    }
ProcessBuilder pb = new ProcessBuilder(args); 
try{
    Process proceso = pb.start();
    int retorno = proceso.waitFor();
    System.out.println("La ejecucion de "+ Arrays.toString(args)
        + " devuelve " + retorno);
   }
 catch (IOException ex)
 {
   System.err.println("Exception de E/s ");
   System.exit(-1); 
 } 
 catch(InterruptedException ex )
 {
   System.err.println("El proceso hijo finalizo de forma incorrecta");
   System.exit(-1);
 }
}
}