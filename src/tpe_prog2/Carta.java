package tpe_prog2;

import Pocimas.Pocima;

import java.util.ArrayList;

public class Carta {
    private String nombre;
    private ArrayList<Atributo> cualidades;
    private ArrayList<String> nombresCualidades;
    private Pocima pocima;

    public Carta(String nombre) {
        this.nombre = nombre;
        cualidades = new ArrayList<>();
        this.pocima = null;
        nombresCualidades = new ArrayList<>();
    }

    public boolean tienePocima() {
        return pocima != null;
    }

    public Pocima getPocima() {
        return pocima;
    }

    public ArrayList<String> getNombresCualidades() {
        ArrayList<String> copiaNombres = (ArrayList<String>) nombresCualidades.clone();
        return copiaNombres;
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
        nombresCualidades.add(c.getNombre());
    }

    public int compareTo(Carta c, String nombreAtributoJugable) {
        Double valor1 = this.getValorCualidad(nombreAtributoJugable);
        Double valor2 = c.getValorCualidad(nombreAtributoJugable);
        return valor1.compareTo(valor2);
    }

    public String toString(String atributoJugable) {
        String resultado = "";
        resultado = " es " + this.getNombre() + " con " + atributoJugable + " " + this.getCualidad(atributoJugable).getValor();
        if (this.tienePocima()) {
            resultado = resultado + ", se aplicó pocima " + this.getPocima().getNombre() + " valor resultante " + this.getValorCualidad(atributoJugable);
        }
        return resultado;
    }

    public boolean equals(Object o) {
        Carta carta = (Carta) o;
        return nombre.equals(carta.getNombre());
    }
}
