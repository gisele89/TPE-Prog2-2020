package Estrategias;

import tpe_prog2.Atributo;
import tpe_prog2.Carta;
import java.util.ArrayList;

public class EstrategiaObstinado implements Estrategia {
    private String nombreAtributo;

    public EstrategiaObstinado(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }

    @Override
    public Atributo elegirAtributo(Carta c) {
        return c.getCualidad(nombreAtributo);
    }
}
