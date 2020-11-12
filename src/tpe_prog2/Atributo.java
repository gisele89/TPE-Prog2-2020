package tpe_prog2;

public class Atributo implements Comparable<Atributo> {
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

    @Override
    public boolean equals(Object o) {
        Atributo atributo = (Atributo) o;
        return nombre.equals(atributo.getNombre());
    }
    @Override
    public int compareTo(Atributo atributo) {
        Double valor1 = this.getValor();
        Double valor2 = atributo.getValor();
        return valor1.compareTo(valor2);
    }
}
