package Estrategias;

import tpe_prog2.Atributo;
import tpe_prog2.Carta;

import java.util.ArrayList;

public class EstrategiaAmbicioso implements Estrategia {
    public EstrategiaAmbicioso() {
    }

    @Override
    public Atributo elegirAtributo(Carta c) {
        ArrayList<String> auxNombres = c.getNombresCualidades();
        Double valorMayor = null;
        Double valorActual;
        String nombre = "";
        for (String s : auxNombres) {
            valorActual = c.getCualidadConPocima(s).getValor();
            if (valorMayor == null || valorMayor < valorActual) {
                valorMayor = valorActual;
                nombre = s;
            }
        }
        return c.getCualidad(nombre);
    }
}
