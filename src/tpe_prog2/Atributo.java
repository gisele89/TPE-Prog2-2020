package tpe_prog2;

public class Atributo {
	private String nombre;
	private double valor;
	
	public Atributo(String nombre, double valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

	public boolean mismaCualidad(Atributo a){
		return a.getNombre().equals(this.getNombre());

	}
	@Override
	public String toString() {
		return " Cualidad [nombre=" + nombre + ", valor=" + valor + "]";
	}
}
