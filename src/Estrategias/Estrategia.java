package Estrategias;

import tpe_prog2.Atributo;

import java.util.ArrayList;

public abstract class Estrategia {
    public abstract Atributo elegirAtributo(ArrayList<Atributo> listaCualidades);
}
