package tema_2.ejercicios.almacen;

public class Cliente implements Runnable {
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Almacen getA() {
		return a;
	}

	public void setA(Almacen a) {
		this.a = a;
	}

	String nombre;
	Almacen a;
	
	public  Cliente(String nombre, Almacen a) {
		this.nombre=nombre;
		this.a=a;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		a.comprobarLista("Pomelo", getNombre());
	}
	
}
