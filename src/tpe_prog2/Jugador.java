package tpe_prog2;

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

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public void addCarta(Carta c) {
        mazo.addCarta(c);
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
