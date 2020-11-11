package Estrategias;

import tpe_prog2.Atributo;
import tpe_prog2.Carta;

import java.util.ArrayList;

public class EstrategiaAmbicioso implements Estrategia {
    public EstrategiaAmbicioso() {
    }

    @Override
    public Atributo elegirAtributo(Carta c) {
        return c.obtenerMejorCualidad();

    }
}
