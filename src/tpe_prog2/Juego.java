package tpe_prog2;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores;
    //POR DEFECTO LA ESTRATEGIA VENIA SIENDO TIMBERO
    private Estrategia estrategiaUsada; //si quiero cambiar en tiempo de ejecucion uso un objeto de otra clase
    private Mazo mazo;
    private String nombre;
    private int maximoRondas;
    private int rondas;

    public Juego(Mazo mazo, String nombre, int maximoRondas) {
        jugadores = new ArrayList<>();
        this.mazo = mazo;
        this.nombre = nombre;
        this.maximoRondas = maximoRondas;
        this.rondas = 0;

    }
 
    public Estrategia seleccionarEstrategia() { //le paso parametros??--creo que no 
    	this.estrategiaUsada.getNombre();//aca solo traigo el nombre :|
	
    	return estrategiaUsada;
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

    public int contarRondas() {
        rondas++;
        
        return rondas;
    }
    
    

    public boolean terminoJuego() {
        if (maximoRondas == rondas || !this.JugadoresTienenCartas()) {
            return true;
        }
        return false;
    }

    public boolean JugadoresTienenCartas() {
        for (Jugador j : jugadores) {
            if (!j.tieneCartasDisponibles()) {
                return false;
            }
        }
        return true;
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
