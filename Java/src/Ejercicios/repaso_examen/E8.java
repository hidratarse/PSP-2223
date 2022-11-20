package Ejercicios.repaso_examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E8 {
	public static void main(String[] args) throws NumberFormatException, IOException {
			
		System.out.println("Programa ejecutado");
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(in);
		
		String cadena=br.readLine();
		
		System.out.println("Cadena recibida "+cadena);
		
		if (cadena.length()==0) {
			System.out.println("No hay nada de la cadena");
		}else if (isPalindrome(cadena)) {
			System.out.println(cadena+" es palindromo");
		} else {
			System.out.println(cadena+" no es palindromo");
		}
		
		in.close();
	}

	public static boolean isPalindrome(String str){

	    String rev = "";
	
	    boolean ans = false;
	
	    for (int i = str.length() - 1; i >= 0; i--) {
	        rev = rev + str.charAt(i);
	    }
	
	    if (str.equals(rev)) {
	        ans = true;
	    }
	    return ans;
	}
}
