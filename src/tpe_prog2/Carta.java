package tpe_prog2;

import java.util.ArrayList;

public class Carta {
    private String nombre;
    private ArrayList<Atributo> cualidades;

    public Carta(String nombre) {
        this.nombre = nombre;
        cualidades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public ArrayList<Atributo> getListaCualidades(){
        ArrayList<Atributo> cualidadesCopia = (ArrayList<Atributo>) cualidades.clone();
        return cualidadesCopia;

    }

    public Atributo getCualidad(String nombreAtributo) {
        for (Atributo a : cualidades) {
            if (a.getNombre().equals(nombreAtributo)) {
                return a;
            }
        }
        return null;
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

    public int esCartaMayor(Carta c, String nombreAtributoJugable) {
        Atributo atr1 = c.getCualidad(nombreAtributoJugable);
        Atributo atr2 = this.getCualidad(nombreAtributoJugable);
        return (atr1.compararCualidad(atr2));
    }

    @Override
    public String toString() {
        return "\n \n Carta [nombre=" + nombre + ", cualidades=" + cualidades + "]\n";
    }

}
