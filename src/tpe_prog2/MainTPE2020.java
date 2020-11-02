package tpe_prog2;

import Estrategias.EstrategiaAmbicioso;
import Estrategias.EstrategiaObstinado;
import Estrategias.EstrategiaTimbero;
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
       // String mazoPath = "src/superheroes.json";
        String mazoPath = "src/autos.json";
        Mazo m = Mazo.cargarMazo(mazoPath);
        m.verificarCartas();
        Jugador j1 = new Jugador("Lucrecia");
        Jugador j2 = new Jugador("Gisele");
        j1.setEstrategia(new EstrategiaTimbero());
        j2.setEstrategia(new EstrategiaObstinado("RPM"));
        //j2.setEstrategia(new EstrategiaObstinado("fuerza"));//para probar mazo superheroes
        Juego juego = new Juego(m, "Juego prueba", 20);
        juego.setJugador1(j1);
        juego.setJugador2(j2);

        Pocima p1 = new PocimaFortalecedora("Fortalecedora", 20);
        Pocima p2 = new PocimaFortalecedora("Fortalecedora Plus", 50);
        Pocima p3 = new PocimaReductora("Kriptonita", 25);
        Pocima p4 = new PocimaReductora("Reductor plomo", 55);
        Pocima p5 = new PocimaRetornoFijo("Quiero vale cuatro", 4);
        Pocima p6 = new PocimaRetornoFijo("NÃºmero mÃ¡gico", 23);
        Pocima p7 = new PocimaSelectivaAtributo("fuerza selectiva", "fuerza", 35);
        Pocima p8 = new PocimaSelectivaAtributo("peso selectiva", "peso", 43);
        PocimaCocktail p9 = new PocimaCocktail("PocimaCocktail");
        p9.addPocima(p7);
        p9.addPocima(p1);

        //para probar nuevas configuraciones de valores
        Pocima p10 = new PocimaFortalecedora("Fortalecedora", 30);
        Pocima p11 = new PocimaFortalecedora("Fortalecedora Plus", 70);
        Pocima p12 = new PocimaReductora("Kriptonita", 70);
        Pocima p13 = new PocimaReductora("Reductor plomo", 90);
        Pocima p14 = new PocimaRetornoFijo("Quiero vale cuatro", 4);
        Pocima p15 = new PocimaRetornoFijo("NÃºmero mÃ¡gico", 23);
        Pocima p16 = new PocimaSelectivaAtributo("fuerza selectiva", "fuerza", 55);
        Pocima p17 = new PocimaSelectivaAtributo("peso selectiva", "peso", 34);
        PocimaCocktail p18 = new PocimaCocktail("PocimaCocktail");
        p18.addPocima(p14);
        p18.addPocima(p10);

        juego.addPocima(p1);
        juego.addPocima(p2);
        juego.addPocima(p3);
        juego.addPocima(p4);
        juego.addPocima(p5);
        juego.addPocima(p6);
        juego.addPocima(p7);
        juego.addPocima(p8);
        juego.addPocima(p9);
        juego.addPocima(p10);
        juego.addPocima(p11);
        juego.addPocima(p12);
        juego.addPocima(p13);
        juego.addPocima(p14);
        juego.addPocima(p15);
        juego.addPocima(p16);
        juego.addPocima(p17);
        juego.addPocima(p18);

        juego.jugar();
    }
//final
}