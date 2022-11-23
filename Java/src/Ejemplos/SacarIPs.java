package Ejemplos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SacarIPs {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Process p = new ProcessBuilder("CMD","/C","IPCONFIG").start();
		try {
			InputStream is = p.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			
			String linea = bf.readLine();
			String IP = null;
			String adap=null;
			System.out.println(IP);
			while((linea=bf.readLine()) != null) {
				if (linea.contains("Adaptador")) {
					adap=linea;
					System.out.println(adap);
				}
				if (linea.contains("IPv4")){
					IP=linea;
					System.out.println(IP);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
