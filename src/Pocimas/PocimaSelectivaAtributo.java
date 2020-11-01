package Pocimas;

import tpe_prog2.Atributo;
import tpe_prog2.Carta;

public class PocimaSelectivaAtributo extends Pocima {
    private String nombreAtributo;
    private double porcentaje;

    public PocimaSelectivaAtributo(String nombre, String nombreAtributo, double porcentaje) {
        super(nombre);
        this.nombreAtributo = nombreAtributo;
        this.porcentaje = porcentaje;
    }

    @Override
    public double aplicar(Atributo a) {
        int valorPorcentaje = 100;
        if (a.getNombre().equals(nombreAtributo)) {
            double valor = a.getValor();
            double incremento = (valor * this.porcentaje) / valorPorcentaje;
            return valor + incremento;
        }
        return a.getValor();
    }
}
