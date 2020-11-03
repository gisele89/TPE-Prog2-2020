package Pocimas;

import tpe_prog2.Atributo;

public abstract class Pocima {
    protected String nombre;

    protected Pocima(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double aplicar(Atributo a);
}
