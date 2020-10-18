package tpe_prog2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class MainTPE2020 {

	public static void main(String[] args) {		
		String mazoPath = "src/superheroes.json";
        Mazo m = Mazo.cargarMazo(mazoPath);

		boolean isTriue = m.verificarCartas();
        Jugador j1= new Jugador("Lucrecia");
		Jugador j2= new Jugador("Gisele");
		ArrayList<Jugador> jugadores= new ArrayList<>();
		jugadores.add(j1);
		jugadores.add(j2);

		m.mezclarCartas();
		ArrayList<Jugador> jugadoresConMazo = m.repartirCartas(jugadores);

		System.out.println(jugadoresConMazo);
		/*Jugador j1= new Jugador("Lucrecia");
		Jugador j2= new Jugador("Gisele");

		Juego j= new Juego(m,"Juego de Cartas", 2);
		j.addJugador(j1);
		j.addJugador(j2);
		
		//m.toString();
		//System.out.println(j);
		System.out.println(m);
		m.mezclarCartas();
		System.out.println(m);*/
	}
//final
	}


