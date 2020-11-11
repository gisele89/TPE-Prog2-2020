package Estrategias;

import tpe_prog2.Atributo;
import tpe_prog2.Carta;

import java.util.ArrayList;

public interface Estrategia {
    public abstract Atributo elegirAtributo(Carta c);
}
