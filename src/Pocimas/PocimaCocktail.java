package Pocimas;

import tpe_prog2.Atributo;
import tpe_prog2.Carta;

import java.util.ArrayList;

public class PocimaCocktail extends Pocima {
    private ArrayList<Pocima> pocimas;


    public PocimaCocktail(String nombre) {
        super(nombre);
        pocimas = new ArrayList<Pocima>();
    }

    public ArrayList<Pocima> getPocimas() {
        return (ArrayList<Pocima>) pocimas.clone();
    }

    public void addPocima(Pocima p) {
        pocimas.add(p);
    }

    @Override
    public double calcular(Atributo a) {
        double sumaPocimas = 0.0;
        for (Pocima p : pocimas) {
            sumaPocimas += p.calcular(a);
        }
        return sumaPocimas;
    }

}
