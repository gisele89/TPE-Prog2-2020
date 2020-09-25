import java.util.ArrayList;

public class Mazo {
	ArrayList<Carta>cartas;

	public Mazo() {
		cartas=new ArrayList<Carta>();
	}

	public ArrayList<Carta> getCartas() {
		ArrayList<Carta> cartasCopia = new ArrayList<Carta>(); 
		cartasCopia = (ArrayList)cartas.clone(); 
		return cartasCopia;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
public void mezclarCartas() {
	//buscar como hacer ramdom
}


}
