package Estrategias;

import tpe_prog2.Atributo;
import tpe_prog2.Carta;

import java.util.ArrayList;

public class EstrategiaTimbero implements Estrategia {

    public EstrategiaTimbero() {

    }

    @Override
    public Atributo elegirAtributo(Carta c) {
        int rand = (int) (Math.random() * c.getNombresCualidades().size());// traes la lista de nombres y en base a ese tamaño hago el rand en vez de recibir el arreglo de strings que lo tenga la carta
        return c.getCualidad(c.getNombresCualidades().get(rand));
    }
}
