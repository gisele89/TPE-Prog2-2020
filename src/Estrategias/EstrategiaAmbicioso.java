package Estrategias;

import tpe_prog2.Atributo;
import tpe_prog2.Carta;

import java.util.ArrayList;

public class EstrategiaAmbicioso implements Estrategia {
    public EstrategiaAmbicioso() {
    }

    @Override
    public Atributo elegirAtributo(Carta c) {
        /*ArrayList<String> auxNombres = c.getNombresCualidades();
        Double valorMayor = c.getNombresCualidades().get(0);
        for (String s : auxNombres) {
            valorMayor = c.getValorCualidad(s);
        }
        Atributo atributoMayor = cualidades.get(0);
        for (Atributo a : cualidades) {
            if (a.getValor() > atributoMayor.getValor()) {
                atributoMayor = a;
            }
        }
        return atributoMayor;
        return c.obtenerMejorCualidad();//pido nombres y en base a eso pido el atributo//cambiar este metodo, la logica que quede acà no en obtener cualidad

    }
}*/
