package Pocimas;

import tpe_prog2.Atributo;

public class PocimaReductora extends Pocima {
    private double porcentaje;

    public PocimaReductora(String nombre, double porcentaje) {
        super(nombre);
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcular(Atributo a) {
        double valor = a.getValor();
        double incremento = (valor * this.porcentaje) / 100;
        return valor + incremento;
    }
}
