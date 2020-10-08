package tpe_prog2;
import java.util.ArrayList;

public class Juego {
	private ArrayList <Jugador>jugadores;
	private Mazo mazo;
	private String nombre;
	private int maximoRondas;
	public Juego(Mazo mazo, String nombre, int maximoRondas) {
		jugadores=new ArrayList<>();
		this.mazo = mazo;
		this.nombre = nombre;
		this.maximoRondas = maximoRondas;
	}
	public void addJugador(Jugador j) {
		jugadores.add(j);
	}
	@Override
	public String toString() {
		return "Juego [jugadores=" + jugadores + ", mazo=" + mazo + ", nombre=" + nombre + ", maximoRondas="
				+ maximoRondas + "]";
	}

}
