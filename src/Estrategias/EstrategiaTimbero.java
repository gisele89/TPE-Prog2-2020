package Estrategias;

import tpe_prog2.Atributo;
import tpe_prog2.Carta;

import java.util.ArrayList;

public class EstrategiaTimbero implements Estrategia {
    private ArrayList<String> nombresCualidades;

    public EstrategiaTimbero() {
        nombresCualidades = new ArrayList<String>();
    }

    public void addNombreCualidad(String s) {
        nombresCualidades.add(s);
    }

    @Override
    public Atributo elegirAtributo(Carta c) {
        int rand = (int) (Math.random() * nombresCualidades.size());
        return c.getCualidad(nombresCualidades.get(rand));
    }
}
