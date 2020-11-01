package Pocimas;

import tpe_prog2.Atributo;

public class PocimaReductora extends Pocima {
    private double porcentaje;

    public PocimaReductora(String nombre, double porcentaje) {
        super(nombre);
        this.porcentaje = porcentaje;
    }

    @Override
    public double aplicar(Atributo a) {
        int valorPorcentaje = 100;
        double valor = a.getValor();
        double incremento = (valor * this.porcentaje) / valorPorcentaje;
        return valor - incremento;
    }
}
