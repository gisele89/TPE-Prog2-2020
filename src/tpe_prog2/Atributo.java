package tpe_prog2;

import java.util.Objects;

public class Atributo {
    private String nombre;
    private Double valor;

    public Atributo(String nombre, Double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean mismaCualidad(Atributo a) {
        return a.getNombre().equals(this.getNombre());
    }

    public int compararCualidad(Atributo a) {
     return this.getValor().compareTo(a.getValor());

    }

    @Override
    public boolean equals(Object o) {
        Atributo atributo = (Atributo) o;
        return nombre.equals(atributo.getNombre());
    }

    @Override
    public String toString() {
        return " Cualidad [nombre=" + nombre + ", valor=" + valor + "]";
    }
}
