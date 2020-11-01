package Pocimas;

import tpe_prog2.Atributo;
import tpe_prog2.Carta;

import java.util.ArrayList;

public abstract class Pocima {
    private String nombre;

    public Pocima(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double aplicar(Atributo a);
}
