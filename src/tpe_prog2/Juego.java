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
        pocimas = new ArrayList<>();

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


    public String getNombre() {
        return nombre;
    }


    public void addPocima(Pocima p) {
        pocimas.add(p);
    }

    public void contarRondas() {
        rondas++;
    }


    public boolean terminoJuego() {
        return maximoRondas == rondas || !this.JugadoresTienenCartas();
    }

    public boolean JugadoresTienenCartas() {
        return j1.getMazo().tieneCartasDisponibles() && j2.getMazo().tieneCartasDisponibles();
    }

    public void jugar() {
        this.distribuirPocimas();
        mazo.mezclarCartas();
        this.repartirCartas();
        this.arrancarRonda();
    }

    public void repartirCartas() {
        ArrayList<Mazo> mazos = new ArrayList<>();
        mazos.add(new Mazo());
        mazos.add(new Mazo());

        boolean mazoImpar = mazo.esImpar();
        int cantJugadores = 2;
        int numeroCartas = mazo.totalCartas();
        for (int i = 0; i < numeroCartas; i++) {
            int mazoActual = i % cantJugadores;//2
            if (mazoImpar && i == numeroCartas - 1) {
                mazoActual = 0;
            }
            Carta carta = mazo.devolverCarta();
            Mazo mazo = mazos.get(mazoActual);
            mazo.addCarta(carta);
        }
        j1.setMazo(mazos.get(0));
        j2.setMazo(mazos.get(1));
    }

    public void arrancarRonda() {
        Jugador jugadorConTurno = j1;
        Jugador jugadorGanador;

        while (!terminoJuego()) {
            String atributoJugable = jugadorConTurno.seleccionarAtributo();
            Mazo m1 = j1.getMazo();
            Mazo m2 = j2.getMazo();
            Carta c = m1.getCartaJugable();
            Carta c2 = m2.getCartaJugable();

            int resultado = c.compareTo(c2, atributoJugable);
            if (resultado == 0) {
                m1.pasarCartaAlFinal();
                m2.pasarCartaAlFinal();
                jugadorGanador = jugadorConTurno;
            } else if (resultado == 1) {
                m1.pasarCartaAlFinal();
                m1.addCarta(m2.devolverCarta());
                jugadorGanador = j1;
            } else {
                m2.pasarCartaAlFinal();
                m2.addCarta(m1.devolverCarta());
                jugadorGanador = j2;
            }
            this.contarRondas();
            this.imprimirResultadoRonda(jugadorConTurno, atributoJugable, c, c2, jugadorGanador);
            jugadorConTurno = jugadorGanador;
        }
        this.imprimirGanador();
    }

    private void distribuirPocimas() {
        int totalCartas = mazo.totalCartas();
        int i = 0;
        for (Pocima p : pocimas) {
            if (i < totalCartas) {
                Carta c = mazo.getCartaJugable();
                c.setPocima(p);
                mazo.pasarCartaAlFinal();
            }
            i++;
        }
    }

    public void imprimirResultadoRonda(Jugador jugadorConTurno, String atributoJugable, Carta c, Carta c2, Jugador jugadorGanador) {
        System.out.println("------- Ronda " + this.getRondas() + " -------");
        System.out.println("El jugador " + jugadorConTurno.getNombre() + " selecciona competir por el atributo " + atributoJugable);
        System.out.println("La carta de " + this.j1.getNombre() + c.toString(atributoJugable));
        System.out.println("La carta de " + this.j2.getNombre() + c2.toString(atributoJugable));
        System.out.println("Gana la ronda " + jugadorGanador.getNombre());
        System.out.println(this.j1.getNombre() + " posee ahora " + j1.getMazo().totalCartas() + " cartas y " + this.j2.getNombre() + " posee ahora " + j2.getMazo().totalCartas() + " cartas");
    }

    private void imprimirGanador() {
        Jugador jugadorGanador = j1;
        if (j2.getMazo().totalCartas() > j1.getMazo().totalCartas()) {
            jugadorGanador = j2;
        }
        System.out.println("El jugador ganador  del juego es " + jugadorGanador.getNombre());
    }

}
