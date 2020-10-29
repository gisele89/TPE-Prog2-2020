package tpe_prog2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class MainTPE2020 {

    public static void main(String[] args) {
        String mazoPath = "src/superheroes.json";
        Mazo m = Mazo.cargarMazo(mazoPath);

        m.verificarCartas();
        Jugador j1 = new Jugador("Lucrecia");
        Jugador j2 = new Jugador("Gisele");
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(j1);
        jugadores.add(j2);

        m.mezclarCartas();
        ArrayList<Jugador> jugadoresConMazo = m.repartirCartas(jugadores);

        //System.out.println(jugadoresConMazo);
        System.out.println("------------------------------------------------------");
        System.out.println(j1.getCartasJugador());
        System.out.println("carta pasada al final------------------------------------------------------");
        System.out.println(j1.pasarCartaAlFinal());
        System.out.println("------------------------------------------------------");
        System.out.println(j1.getCartasJugador());
        System.out.println("Carta devuelta------------------------------------------------------");
        System.out.println(j1.getCartasJugador());
        System.out.println("------------------------------------------------------");
        j2.addCarta(j1.devolverCarta());
        System.out.println("Carta nueva agregada------------------------------------------------------");
        System.out.println(j2.getCartasJugador());


    }
//final
}


