package Ejercicios.Ejercicio_1_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio_1_6 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		
		int n1=Integer.parseInt((br.readLine()));
		int n2=Integer.parseInt((br.readLine()));
		
		System.out.println(n1+n2);
		
		in.close();
	}
}
