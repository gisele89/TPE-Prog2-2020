package tpe_prog2;

import java.util.ArrayList;

import Pocimas.Pocima;

public class Juego {
    private Jugador j1;
    private Jugador j2;
    private Mazo mazo;
    private String nombre;
    private int maximoRondas;
    private int rondas;
    private ArrayList<Pocima> pocimas;

    public Juego(Mazo mazo, String nombre, int maximoRondas) {
        this.mazo = mazo;
        this.nombre = nombre;
        this.maximoRondas = maximoRondas;
        this.rondas = 0;
        pocimas = new ArrayList<Pocima>();

    }

    public int getRondas() {
        return rondas;
    }

    public void setJugador1(Jugador j1) {
        this.j1 = j1;
    }

    public void setJugador2(Jugador j2) {
        this.j2 = j2;
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

    public void addPocima(Pocima p) {
        pocimas.add(p);
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
        if (!j1.tieneCartasDisponibles() || !j2.tieneCartasDisponibles()) {
            return false;
        }
        return true;
    }

    public void jugar() {
        this.distribuirPocimas();
        mazo.mezclarCartas();
        ArrayList<Jugador> jugadoresConMazo = new ArrayList<Jugador>();
        jugadoresConMazo.add(j1);
        jugadoresConMazo.add(j2);
        mazo.repartirCartas(jugadoresConMazo);
        this.arrancarRonda();
    }

    public void arrancarRonda() {
        Jugador jugadorConTurno = j1;
        Jugador jugadorGanador;

        while (!terminoJuego()) {
            String atributoJugable = jugadorConTurno.seleccionarAtributo();
            Carta c = j1.getCartaJugable();
            Carta c2 = j2.getCartaJugable();
            int resultado = c.esCartaMayor(c2, atributoJugable);
            if (resultado == 0) {
                j1.pasarCartaAlFinal();
                j2.pasarCartaAlFinal();
                jugadorGanador = jugadorConTurno;
            } else if (resultado == 1) {
                j1.pasarCartaAlFinal();
                j1.addCarta(j2.devolverCarta());
                jugadorGanador = j1;
            } else {
                j2.pasarCartaAlFinal();
                j2.addCarta(j1.devolverCarta());
                jugadorGanador = j2;
            }
            this.contarRondas();
            this.imprimirResultadoRonda(jugadorConTurno, atributoJugable, c, c2, jugadorGanador);
            jugadorConTurno = jugadorGanador;
        }
        this.imprimirGanador();
    }

    private void distribuirPocimas() {
        ArrayList<Carta> cartas = mazo.getCartas();
        for (Pocima p : pocimas) {
            if (cartas.size() > 0) {
                Carta c = cartas.get(0);
                cartas.remove(0);
                mazo.getCarta(c.getNombre()).setPocima(p);
            }
        }
    }

    public void imprimirResultadoRonda(Jugador jugadorConTurno, String atributoJugable, Carta c, Carta c2, Jugador jugadorGanador) {
        System.out.println("------- Ronda " + this.getRondas() + " -------");
        System.out.println("El jugador " + jugadorConTurno.getNombre() + " selecciona competir por el atributo " + atributoJugable);
        System.out.println("La carta de " + this.j1.getNombre() + " es " + c.getNombre() + " con " + atributoJugable + " " + c.getCualidad(atributoJugable).getValor() + imprimirValorPocima(c, atributoJugable));
        System.out.println("La carta de " + this.j2.getNombre() + " es " + c2.getNombre() + " con " + atributoJugable + " " + c2.getCualidad(atributoJugable).getValor() + imprimirValorPocima(c2, atributoJugable));
        System.out.println("Gana la ronda " + jugadorGanador.getNombre());
        System.out.println(this.j1.getNombre() + " posee ahora " + j1.totalCartas() + " cartas y " + this.j2.getNombre() + " posee ahora " + j2.totalCartas() + " cartas");
    }

    private String imprimirValorPocima(Carta c, String atributoJugable) {
        String resultado = "";
        if (c.tienePocima()) {
            resultado = " se aplicó pocima " + c.getPocima().getNombre() + " valor resultante " + c.getValorCualidad(atributoJugable);
        }
        return resultado;
    }

    private void imprimirGanador() {
        Jugador jugadorGanador = j1;
        if (j2.totalCartas() > j1.totalCartas()) {
            jugadorGanador = j2;
        }
        System.out.println("El jugador ganador es " + jugadorGanador.getNombre());
    }

    @Override
    public String toString() {
        return "Juego{" +
                "j1=" + j1 +
                ", j2=" + j2 +
                ", mazo=" + mazo +
                ", nombre='" + nombre + '\'' +
                ", maximoRondas=" + maximoRondas +
                ", rondas=" + rondas +
                '}';
    }
}
