package examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio3 {
	
	private static int PRIMERA_COLUMNA=0; 
	
    public static void main(String[] args) throws IOException {
        Process p = new ProcessBuilder("ps","aux").start();
        
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String cabecera = br.readLine(); //lee la primera
        String linea=null;
        //String prueba="miguel"; cadena usada para probar
        System.out.println(cabecera);
        String split[];
        while((linea=br.readLine()) != null){
            split=linea.split(" ");
            //args donde el usuarío debera meter su nombre
            if (split[PRIMERA_COLUMNA].contains(args[PRIMERA_COLUMNA])&&linea.contains("0.0")) {
                System.out.println(linea);
            }
        }
    }
}