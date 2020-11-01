package Pocimas;

import tpe_prog2.Atributo;

public class PocimaRetornoFijo extends Pocima {
    private int valorRetorno;

    public PocimaRetornoFijo(String nombre, int valorRetorno) {
        super(nombre);
        this.valorRetorno = valorRetorno;
    }

    @Override
    public double aplicar(Atributo a) {
        return valorRetorno;
    }

}
