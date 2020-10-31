package tpe_prog2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Jugador {
    private String nombre;
    private ArrayList<Carta> cartas;
    private boolean tieneTurno = false;
    // private Mazo mazo;

    public Jugador(String nombre) {
        this.nombre = nombre;
        //this.mazo = new Mazo();
        cartas = new ArrayList<Carta>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Carta> getCartasJugador() {
        return cartas;
    }
/*public Mazo getMazo() {
        return mazo;
    }*/

    public void addCarta(Carta c) {
        cartas.add(c);
    }

    public String seleccionarAtributoRandom() {
        Carta c = cartas.get(0);
        ArrayList<Atributo> listaCualidades = c.getListaCualidades();
        int rand = (int) (Math.random() * listaCualidades.size());
        return listaCualidades.get(rand).getNombre();
    }

    public boolean tieneCartaJugador(Carta c) {
        return cartas.contains(c);
    }

    public boolean tieneCartasDisponibles() {
        return cartas.size() == 0;
    }

    public boolean esTurnoDe(Jugador j) {
        return j.tieneTurno;
    }

    public ArrayList<Carta> pasarCartaAlFinal() {
        Collections.rotate(cartas, -1);
        return cartas;
    }

    public Carta devolverCarta() {
        Carta primerCarta = cartas.get(0);
        cartas.remove(0);
        /*Iterator<Carta> i = cartas.iterator();
        while (i.hasNext()) {
            c = i.next();
            if (c.equals(primerCarta)) {
                i.remove();
            }*/
        return primerCarta;
    }


    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", cartas=" + cartas +
                '}';
    }
}
