package Estrategias;

import tpe_prog2.Atributo;

import java.util.ArrayList;

public class EstrategiaTimbero extends Estrategia {
    public EstrategiaTimbero() {
    }

    @Override
    public Atributo elegirAtributo(ArrayList<Atributo>listaCualidades) {
        int rand = (int) (Math.random() * listaCualidades.size());
        return listaCualidades.get(rand);
    }
}
