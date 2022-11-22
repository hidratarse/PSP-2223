package tema_2.ejercicios.almacen;

import java.util.ArrayList;
import java.util.Arrays;

public class Almacen {
		
	String [] productos= {"Naranja","Pomelo","Banana","Manzana",
			"Pera","Arandanos","Mandarinas","Frambuesas"};
	
	ArrayList<String> lista;
	
	public Almacen() {
		this.lista=new ArrayList<String>();
		this.lista.addAll(Arrays.asList(productos));
	}
	
	synchronized void comprobarLista(String producto, String nom) {
		System.out.println(nom+" VA A COMPRAR "+producto);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean encontrado=false;
		if (lista.size()>0) {
			for (int i = 0; i < lista.size(); i++) {
				String busca = lista.get(i);
				System.out.println("BUSCANDO...."+busca);
				if (producto.equalsIgnoreCase(busca)) {
					System.out.println("EL ELEMENTO SE ENCUENTRA EN LA LISTA, TE LO SACO");
					lista.remove(i);
					encontrado=true;
				}
			}
			if (!encontrado) {
				System.out.println("NO SE ENCUENTRA EL PRODUCTO");
			}
		} else {
			System.out.println("EL ALMACÉN ESTÁ VACÍO");
			System.exit(0);
		}
	}
}
