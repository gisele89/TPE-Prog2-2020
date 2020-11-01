package tpe_prog2;

import java.util.ArrayList;

public class ExtenderDisenio extends Juego { //tiene un conjunto de pocimas y estrategias
	private ArrayList<Pocima> pocimas;// ??
	private ArrayList<Estrategia> estrategias;// ??
    private ArrayList<Jugador> jugadores;

    //---------------no se si hacer esto o ponerlos en juego pero con metodos para aplicar

	public ExtenderDisenio(Mazo mazo, String nombre, int maximoRondas) {
		super(mazo, nombre, maximoRondas);
		pocimas = new ArrayList<>();
		estrategias = new ArrayList<>();
		jugadores = new ArrayList<>();
	}
	
}
