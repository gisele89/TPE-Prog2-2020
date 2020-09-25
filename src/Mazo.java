import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

	public void addCarta(Carta c) {
		cartas.add(c);
	}
	public void mezclarCartas() {
		Random random = new Random();
		Collections.shuffle(cartas, random);
	}

	@Override
	public String toString() {
		return "Mazo [cartas=" + cartas + "]\n";
	}

}
