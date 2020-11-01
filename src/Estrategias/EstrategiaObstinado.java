package Estrategias;

import tpe_prog2.Atributo;

import java.util.ArrayList;

public class EstrategiaObstinado extends Estrategia {
    private String nombreAtributo;

    public EstrategiaObstinado(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }

    @Override
    public Atributo elegirAtributo(ArrayList<Atributo> listaCualidades) {
        for (Atributo a : listaCualidades) {
            if (a.getNombre().equals(nombreAtributo)) {
                return a;
            }
        }
        return null;
    }
}
