package Pocimas;

import tpe_prog2.Atributo;

public class PocimaFortalecedora extends Pocima {
    private double porcentaje;

    public PocimaFortalecedora(String nombre, double porcentaje) {
        super(nombre);
        this.porcentaje = porcentaje;
    }
    
    @Override
    public double aplicar(Atributo a) {
        double valor = a.getValor();
        double incremento = (valor * this.porcentaje) / 100;
        return valor + incremento;
    }
}
