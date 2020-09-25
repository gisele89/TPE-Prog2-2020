import java.util.ArrayList;

public class Carta {
	private String nombre;
	private ArrayList<Cualidad>cualidades;
	public Carta(String nombre) {
		this.nombre = nombre;
		cualidades=new ArrayList<>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Cualidad> getCualidades() {
		return cualidades;
	}
	public void setCualidades(ArrayList<Cualidad> cualidades) {
		this.cualidades = cualidades;
	}
	public void addCualidades(Cualidad c) {
		cualidades.add(c);
	}
	@Override
	public String toString() {
		return "\n \n Carta [nombre=" + nombre + ", cualidades=" + cualidades + "]\n";
	}

}
