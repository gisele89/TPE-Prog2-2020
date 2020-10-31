package tpe_prog2;

public class Estrategia {
	//tengo 3 estrategias asi que deben ser objetos
	//tengo que poder cambiarlo en tiempo de ejecucion
	private String nombre;
	
	public  Estrategia(String nombre) {//solo tengo un objeto-- como le doy varias funcionalidades? ---Es dinamico??---
		this.nombre = nombre;
	}
	//TIMBERO -- estrategia actual --elige atributo al azar
	//AMBICIOSO -- elige atributo de mayor valor de su carta actual
	//OBSTINADO -- elige siempre el mismo atributo
	
	//depende cual sea se elige diferente ??
	public void elegirAtributo() {}

	public String getNombre() {
		return nombre;
	}
	
}
