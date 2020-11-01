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
        Juego juego = new Juego(m, "Juego prueba", 10);
        juego.setJugador1(j1);
        juego.setJugador2(j2);
        juego.jugar();
    }
//final
}


