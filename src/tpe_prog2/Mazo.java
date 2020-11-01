package tpe_prog2;

import Pocimas.Pocima;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Mazo {
    private ArrayList<Carta> cartas;
    private ArrayList<Pocima> pocimas;

    public Mazo() {
        cartas = new ArrayList<Carta>();
    }

    public ArrayList<Carta> getCartas() {
        ArrayList<Carta> cartasCopia = (ArrayList<Carta>) cartas.clone();
        return cartasCopia;
    }

    public Carta getCarta(String nombreCarta) {
        for (Carta c : cartas) {
            if (c.getNombre().equals(nombreCarta)) {
                return c;
            }
        }
        return null;
    }

    public int totalCartas() {
        return cartas.size();
    }

    public void addCarta(Carta c) {
        cartas.add(c);
    }

    public void mezclarCartas() {
        Random random = new Random();
        Collections.shuffle(cartas, random);
    }

    public void verificarCartas() {
        Carta primerCarta = cartas.get(0);
        Carta c;
        Iterator<Carta> i = cartas.iterator();
        while (i.hasNext()) {
            c = i.next();
            if (!c.verificarCualidades(primerCarta)) {
                i.remove();
            }
        }
    }

    public ArrayList<Jugador> repartirCartas(ArrayList<Jugador> jugadores) {
        ArrayList<Jugador> jugadoresConMazo = (ArrayList<Jugador>) jugadores.clone();
        boolean mazoImpar = this.esImpar();
        int cantJugadores = jugadoresConMazo.size();
        int numeroCartas = cartas.size();
        for (int i = 0; i < numeroCartas; i++) {
            int jugadorActual = i % cantJugadores;
            if (mazoImpar && i == numeroCartas - 1) {
                jugadorActual = 0;
            }
            Jugador jugador = jugadoresConMazo.get(jugadorActual);
            Carta carta = cartas.get(i);
            if (jugador != null) {
                jugador.addCarta(carta);
            }
        }
        return jugadoresConMazo;
    }

    public boolean esImpar() {
        int modulo = 2;
        return cartas.size() % modulo == 1;
    }

    public static Mazo cargarMazo(String jsonFile) {
        Mazo mazo = new Mazo();
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            JsonReader reader = Json.createReader(is);
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                String nombreCarta = carta.getString("nombre");
                Carta unaCarta = new Carta(nombreCarta);
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                for (String nombreAtributo : atributos.keySet()) {
                    Atributo unaCualidad = new Atributo(nombreAtributo, (double) atributos.getInt(nombreAtributo));
                    unaCarta.addCualidad(unaCualidad);
                }
                mazo.addCarta(unaCarta);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mazo;
    }

    @Override
    public String toString() {
        return "Mazo [cartas=" + cartas + "]\n";
    }

}
