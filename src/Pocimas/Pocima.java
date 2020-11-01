package Pocimas;

import tpe_prog2.Atributo;
import tpe_prog2.Carta;

import java.util.ArrayList;

public abstract class Pocima {
    private String nombre;

    public Pocima(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcular(Atributo a);

    public void aplicar(Carta c) {
        ArrayList<Atributo> cualidades = c.getListaCualidades();
        for (Atributo a : cualidades) {
            Atributo atr = c.getCualidad(a.getNombre());
            atr.setValor(calcular(atr));
        }
    }
}
