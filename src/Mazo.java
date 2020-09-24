import java.util.ArrayList;

public class Mazo {
ArrayList<Carta>cartas;

public Mazo() {
	cartas=new ArrayList<>();
}

public ArrayList<Carta> getCartas() {
	return cartas;
}

public void setCartas(ArrayList<Carta> cartas) {
	this.cartas = cartas;
}

}
