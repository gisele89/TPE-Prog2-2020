package tpe_prog2;

import Pocimas.Pocima;

import java.util.ArrayList;

public class Carta {
    private String nombre;
    private ArrayList<Atributo> cualidades;
    private Pocima pocima;

    public Carta(String nombre) {
        this.nombre = nombre;
        cualidades = new ArrayList<>();
        this.pocima = null;
    }

    public boolean tienePocima() {
        return pocima != null;
    }

    public Pocima getPocima() {
        return pocima;
    }

    public void setPocima(Pocima pocima) {
        this.pocima = pocima;
    }

    public String getNombre() {
        return nombre;
    }


    public Atributo getCualidad(String nombreAtributo) {
        for (Atributo a : cualidades) {
            if (a.getNombre().equals(nombreAtributo)) {
                return a;
            }
        }
        return null;
    }

    public double getValorCualidad(String nombreAtributo) {
        for (Atributo a : cualidades) {
            if (a.getNombre().equals(nombreAtributo)) {
                if (tienePocima()) {
                    return pocima.aplicar(a);
                }
                return a.getValor();
            }
        }
        return 0.0;
    }

    public int totalCualidades() {
        return cualidades.size();
    }

    public boolean verificarCualidades(Carta c) {
        if (c.totalCualidades() != this.totalCualidades()) {
            return false;
        } else
            for (Atributo a : cualidades) {
                if (!c.tieneCualidad(a)) {
                    return false;
                }
            }
        return true;
    }

    public boolean tieneCualidad(Atributo atr) {
        for (Atributo a : cualidades) {
            if (a.mismaCualidad(atr)) {
                return true;
            }
        }
        return false;
    }

    public void addCualidad(Atributo c) {
        cualidades.add(c);
    }

    /*
     El Atributo no es comparable, quedaria mejor para comparar en juego atributo con atributo.
     */
    public int esCartaMayor(Carta c, String nombreAtributoJugable) {
        /*Atributo atr1 = this.getCualidad(nombreAtributoJugable);
        Atributo atr2 = c.getCualidad(nombreAtributoJugable);
        return atr1.compareTo(atr2);*/
        Double valor1 = this.getValorCualidad(nombreAtributoJugable);
        Double valor2 = c.getValorCualidad(nombreAtributoJugable);
        return valor1.compareTo(valor2);
    }

    public Atributo obtenerMejorCualidad() {
        Atributo atributoMayor = cualidades.get(0);
        for (Atributo a : cualidades) {
            if (a.getValor() > atributoMayor.getValor()) {
                atributoMayor = a;
            }
        }
        return atributoMayor;
    }


    @Override//mejora para el imprimir pocima
    public String toString() {
        String resultado = "";
        if (this.tienePocima()) {
            resultado = " se aplicó pocima " + this.getPocima().getNombre();
        }
        return resultado;
    }

    public boolean equals(Object o) {
        Carta carta = (Carta) o;
        return nombre.equals(carta.getNombre());
    }
}
