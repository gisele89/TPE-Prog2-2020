package tpe_prog2;

import Estrategias.Estrategia;
import Estrategias.EstrategiaTimbero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Jugador {
    private String nombre;
    private ArrayList<Carta> cartas;
    private boolean tieneTurno = false;
    private Estrategia estrategia;


    public Jugador(String nombre) {
        this.nombre = nombre;
        cartas = new ArrayList<Carta>();
        estrategia = new EstrategiaTimbero();
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
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

    public Carta getCartaJugable() {
        return cartas.get(0);
    }

    public void addCarta(Carta c) {
        cartas.add(c);
    }

    public String seleccionarAtributo() {
        Carta c = cartas.get(0);
        Atributo atributoSeleccionado = estrategia.elegirAtributo(c.getListaCualidades());
        return atributoSeleccionado.getNombre();
    }

    public boolean tieneCartaJugador(Carta c) {
        return cartas.contains(c);
    }

    public boolean tieneCartasDisponibles() {
        return cartas.size() > 0;
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
        return primerCarta;
    }

    public int totalCartas() {
        return cartas.size();
    }

    public boolean equals(Object o) {
        Jugador jugador = (Jugador) o;
        return nombre.equals(jugador.getNombre());
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", cartas=" + cartas +
                ", tieneTurno=" + tieneTurno +
                '}';
    }
}
