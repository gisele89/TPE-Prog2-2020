package Pocimas;

import tpe_prog2.Atributo;

public class PocimaRetornoFijo extends Pocima {
    private int valorRetorno;

    public PocimaRetornoFijo(String nombre, int valorRetorno) {
        super(nombre);
        this.valorRetorno = valorRetorno;
    }

    @Override
    public double calcular(Atributo a) {
        return valorRetorno;
    }

}
