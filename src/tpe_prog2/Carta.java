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


    public ArrayList<String> getNombresCualidades() {
        ArrayList<String> nombres = new ArrayList<String>();
        for (Atributo a : cualidades) {
            nombres.add(a.getNombre());
        }
        return nombres;
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

    public Atributo getCualidadConPocima(String nombreAtributo) {
        Atributo atr = null;
        Double valor = 0.0;
        for (Atributo a : cualidades) {
            if (a.getNombre().equals(nombreAtributo)) {
                valor = a.getValor();
                if (tienePocima()) {
                    valor = pocima.aplicar(a);
                }
                atr = new Atributo(a.getNombre(), valor);
                return atr;
            }
        }
        return null;
    }
   /* public double getValorCualidad(String nombreAtributo) {
        for (Atributo a : cualidades) {
            if (a.getNombre().equals(nombreAtributo)) {
                if (tienePocima()) {
                    return pocima.aplicar(a);
                }
                return a.getValor();
            }
        }
        return 0.0;
    }*/

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

    public int compareTo(Carta c, String nombreAtributoJugable) {
        Atributo atr1 = this.getCualidadConPocima(nombreAtributoJugable);
        Atributo atr2 = c.getCualidadConPocima(nombreAtributoJugable);
        //Double valor1 = this.getValorCualidad(nombreAtributoJugable);
        //Double valor2 = c.getValorCualidad(nombreAtributoJugable);
        return atr1.compareTo(atr2);
    }

    public String toString(String atributoJugable) {
        String resultado = "";
        resultado = " es " + this.getNombre() + " con " + atributoJugable + " " + this.getCualidad(atributoJugable).getValor();
        if (this.tienePocima()) {
            resultado = resultado + ", se aplicó pocima " + this.getPocima().getNombre() + " valor resultante " + this.getCualidadConPocima(atributoJugable).getValor();
        }
        return resultado;
    }

    public boolean equals(Object o) {
        Carta carta = (Carta) o;
        return nombre.equals(carta.getNombre());
    }

}
