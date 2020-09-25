public class Jugador {
private String nombre;
private Mazo mazo;
public Jugador(String nombre) {
	this.nombre=nombre;
}
public Jugador(String nombre, Mazo mazo) {
	this.nombre = nombre;
	this.mazo = mazo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Mazo getMazo() {
	return mazo;
}
public void setMazo(Mazo mazo) {
	this.mazo = mazo;
}

public boolean tieneCarta() {
	return false;
}

public boolean tieneTurno() {
	return false;
}

public void pasarCartaAlFinal(Jugador j) {
	
}
}
