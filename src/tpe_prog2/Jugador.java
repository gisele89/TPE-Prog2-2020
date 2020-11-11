package tpe_prog2;

import Estrategias.Estrategia;
import Estrategias.EstrategiaTimbero;

import java.util.ArrayList;
import java.util.Collections;

public class Jugador {
    private String nombre;
    //private ArrayList<Carta> cartas;
    private Mazo mazo;
    private Estrategia estrategia;


    public Jugador(String nombre) {
        this.nombre = nombre;
        mazo = new Mazo();
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

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }
    /*public Carta getCartaJugable() {
        return mazo.getCartaJugable();
    }*/



    /*public void addCarta(Carta c) {
        mazo.addCarta(c);
    }*/

    public String seleccionarAtributo() {
        if (this.mazo.tieneCartasDisponibles()) {
            Carta c = mazo.getCartaJugable();
            Atributo atributoSeleccionado = estrategia.elegirAtributo(c);
            if (atributoSeleccionado != null) {
                return atributoSeleccionado.getNombre();
            }
        }
        return null;
    }

    /*public boolean tieneCartasDisponibles() {
        return mazo.tieneCartasDisponibles();
    }

    public void pasarCartaAlFinal() {
        mazo.pasarCartaAlFinal();
    }

    public Carta devolverCarta() {
        return mazo.devolverCarta();
    }

    public int totalCartas() {
        return mazo.totalCartas();
    }*/

    public boolean equals(Object o) {
        Jugador jugador = (Jugador) o;
        return nombre.equals(jugador.getNombre());
    }
}
