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
        nombresCualidades = this.cargarNombres();
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

    //este metodo ya no iria
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

    public ArrayList<String> cargarNombres() {
        ArrayList<String> nombresAux = new ArrayList<String>();
        String nombre;
        for (Atributo a : cualidades) {
            nombre = a.getNombre();
            nombresAux.add(nombre);
        }
        return nombresAux;
    }

    /*
     El Atributo no es comparable, quedaria mejor para comparar en juego atributo con atributo.
     */
    public int compareTo(Carta c, String nombreAtributoJugable) {
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

    public String toString(String atributoJugable) {
        String resultado = "";
        for (Atributo a : cualidades) {
            if (a.getNombre().equals(atributoJugable)) {
                resultado = " es " + this.getNombre() + " con " + atributoJugable + " " + this.getCualidad(atributoJugable).getValor();
                if (this.tienePocima()) {
                    resultado = resultado + ", se aplicó pocima " + this.getPocima().getNombre() + " valor resultante " + this.getValorCualidad(atributoJugable);
                }
            }
        }
        return resultado;
    }

    public boolean equals(Object o) {
        Carta carta = (Carta) o;
        return nombre.equals(carta.getNombre());
    }
}
