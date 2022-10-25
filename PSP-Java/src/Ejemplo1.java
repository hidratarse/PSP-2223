import java.io.IOException;

public class Ejemplo1 {
   public static void main(String[] args) throws IOException  {	   
	   ProcessBuilder pb = new ProcessBuilder("NOTEPAD");
	   Process p = pb.start();
   }
}//Ejemplo1
