package Ejemplos;

import java.util.*;
public class Comando
{
  public static void main(String args[])
  {
    ProcessBuilder test = new ProcessBuilder();
	test= new ProcessBuilder("java", "Unsaludo", "\"Hola Mundo!!\"");
	
	//devuelve el nombre del proceso y sus argumentos
	List l = test.command();
	Iterator iter = l.iterator();
	System.out.println("Argumentos del comando:");
	while (iter.hasNext())
		System.out.println(iter.next());
  }
}