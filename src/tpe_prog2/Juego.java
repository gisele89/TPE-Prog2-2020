package tpe_prog2;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private Mazo mazo;
    private String nombre;
    private int maximoRondas;

    public Juego(Mazo mazo, String nombre, int maximoRondas) {
        jugadores = new ArrayList<>();
        this.mazo = mazo;
        this.nombre = nombre;
        this.maximoRondas = maximoRondas;
    }

    public ArrayList<Jugador> getJugadores() {
        ArrayList<Jugador> copiaJugadores = new ArrayList<Jugador>();
        copiaJugadores = jugadores;
        return copiaJugadores;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMaximoRondas() {
        return maximoRondas;
    }

    public void addJugador(Jugador j) {
        jugadores.add(j);
    }

    public void jugar() {
        mazo.mezclarCartas();
    }

    @Override
    public String toString() {
        return "Juego [jugadores=" + jugadores + ", mazo=" + mazo + ", nombre=" + nombre + ", maximoRondas="
                + maximoRondas + "]";
    }

}
