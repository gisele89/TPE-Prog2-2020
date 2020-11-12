package tpe_prog2;

import Estrategias.Estrategia;
import Estrategias.EstrategiaTimbero;

public class Jugador {
    private String nombre;
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

    public boolean equals(Object o) {
        Jugador jugador = (Jugador) o;
        return nombre.equals(jugador.getNombre());
    }
}
