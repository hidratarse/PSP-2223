package tema_2.ejercicios.meadero;

public class Baño {
	public static void main(String[] args) {
		
		Persona p1=new Persona(1);
		Persona p2=new Persona(2);
		Persona p3=new Persona(3);
		
		Thread t =new Thread(p1);
		Thread t2 =new Thread(p2);
		Thread t3 =new Thread(p3);
		t.start();
		t2.start();
		t3.start();
	}

}
