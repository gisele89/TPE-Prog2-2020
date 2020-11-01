package Estrategias;

import tpe_prog2.Atributo;

import java.util.ArrayList;

public class EstrategiaAmbicioso implements Estrategia {
    public EstrategiaAmbicioso() {
    }

    @Override
    public Atributo elegirAtributo(ArrayList<Atributo> listaCualidades) {
        Atributo atributoMayor = listaCualidades.get(0);
        for (Atributo a : listaCualidades) {
            if (a.getValor() > atributoMayor.getValor()) {
                atributoMayor = a;
            }
        }
        return atributoMayor;
    }
}
