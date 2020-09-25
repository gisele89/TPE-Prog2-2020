
public class Cualidad {
	private String nombre;
	private double valor;
	public Cualidad(String nombre, double valor) {
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
	@Override
	public String toString() {
		return " Cualidad [nombre=" + nombre + ", valor=" + valor + "]";
	}
}
