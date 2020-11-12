package Estrategias;

import tpe_prog2.Atributo;
import tpe_prog2.Carta;


public class EstrategiaTimbero implements Estrategia {

    public EstrategiaTimbero() {

    }

    @Override
    public Atributo elegirAtributo(Carta c) {
        int rand = (int) (Math.random() * c.getNombresCualidades().size());
        return c.getCualidad(c.getNombresCualidades().get(rand));
    }
}
