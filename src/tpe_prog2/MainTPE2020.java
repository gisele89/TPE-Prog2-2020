package tpe_prog2;

import Estrategias.EstrategiaAmbicioso;
import Estrategias.EstrategiaObstinado;
import Pocimas.*;

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
        j2.setEstrategia(new EstrategiaObstinado("fuerza"));
        Juego juego = new Juego(m, "Juego prueba", 20);
        juego.setJugador1(j1);
        juego.setJugador2(j2);

        Pocima p1 = new PocimaFortalecedora("Fortalecedora", 20);
        Pocima p2 = new PocimaFortalecedora("Fortalecedora Plus", 50);
        Pocima p3 = new PocimaReductora("Kriptonita", 25);
        Pocima p4 = new PocimaReductora("Reductor plomo", 55);
        Pocima p5 = new PocimaRetornoFijo("Quiero vale cuatro", 4);
        Pocima p6 = new PocimaRetornoFijo("Número mágico", 23);
        Pocima p7 = new PocimaSelectivaAtributo("fuerza selectiva", "fuerza", 35);
        Pocima p8 = new PocimaSelectivaAtributo("peso selectiva", "peso", 43);
        PocimaCocktail p9 = new PocimaCocktail("PocimaCocktail");
        p9.addPocima(p7);
        p9.addPocima(p1);

        juego.addPocima(p1);
        juego.addPocima(p2);
        juego.addPocima(p3);
        juego.addPocima(p4);
        juego.addPocima(p5);
        juego.addPocima(p6);
        juego.addPocima(p7);
        juego.addPocima(p8);
        juego.addPocima(p9);

        juego.jugar();
    }
//final
}


