package tpe_prog2;

import java.util.ArrayList;
import java.util.Random;

public class Jugador {
    private String nombre;
    private Mazo mazo;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mazo = new Mazo();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void addCarta(Carta c) {
        mazo.addCarta(c);
    }

    public String seleccionarAtributoRandom() {
        ArrayList<Carta> cartasJugador = mazo.getCartas();
        Carta c = cartasJugador.get(0);
        ArrayList<Atributo>listaCualidades =c.getListaCualidades();
        int rand = (int) (Math.random() * listaCualidades.size());
        return listaCualidades.get(rand).getNombre();
    }

    public boolean tieneCarta() {
        return false;
    }

    public boolean tieneTurno() {
        return false;
    }

    public void pasarCartaAlFinal(Jugador j) {

    }
}
