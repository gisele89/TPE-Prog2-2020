package Estrategias;

import tpe_prog2.Atributo;
import tpe_prog2.Carta;

public class EstrategiaAmbicioso implements Estrategia {
    public EstrategiaAmbicioso() {
    }

    @Override
    public Atributo elegirAtributo(Carta c) {
        return c.obtenerMejorCualidad();

    }
}
