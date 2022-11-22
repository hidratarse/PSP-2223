package tema_2.ejercicios.almacen;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Almacen {
		
	String [] productos= {"Naranja","Pomelo","Banana","Manzana",
			"Pera","Arandanos","Mandarinas","Frambuesas"};
	
	List<String> lista;
	
	public Almacen() {
		this.lista= Arrays.asList(productos);
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
			Iterator<String> iterador = lista.iterator();
			while (iterador.hasNext()) {
				String busca = (String) iterador.next();
				System.out.println("BUSCANDO...."+busca);
				if (producto.equalsIgnoreCase(busca)) {
					System.out.println("EL ELEMENTO SE ENCUENTRA EN LA LISTA, TE LO SACO");
					iterador.remove();
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
