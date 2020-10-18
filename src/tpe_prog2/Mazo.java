package tpe_prog2;

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
import java.util.Random;

public class Mazo {
    ArrayList<Carta> cartas;

    public Mazo() {
        cartas = new ArrayList<Carta>();
    }

    public ArrayList<Carta> getCartas() {
        ArrayList<Carta> cartasCopia = (ArrayList<Carta>) cartas.clone();
        return cartasCopia;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public void addCarta(Carta c) {
        cartas.add(c);
    }

    public void mezclarCartas() {
        Random random = new Random();
        Collections.shuffle(cartas, random);
    }

    public boolean verificarCartas() {
        Carta primerCarta = cartas.get(0);

        for (Carta c : cartas) {
            if (!c.verificarCualidades(primerCarta)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Jugador> repartirCartas(ArrayList<Jugador> jugadores) {
        ArrayList<Jugador> jugadoresConMazo = (ArrayList<Jugador>) jugadores.clone();
        boolean mazoImpar = this.esImpar();
        int cantJugadores = jugadoresConMazo.size();
        int numeroCartas=cartas.size();
        for (int i = 0; i < numeroCartas; i++) {
            int jugadorActual= i % cantJugadores;
            if(mazoImpar && i==numeroCartas-1){
                jugadorActual=0;
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
        return cartas.size() % 2 == 1;
    }

    public static Mazo cargarMazo(String jsonFile) {
        Mazo mazo = new Mazo();
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                String nombreCarta = carta.getString("nombre");
                Carta unaCarta = new Carta(nombreCarta);
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                for (String nombreAtributo : atributos.keySet()) {
                    Atributo unaCualidad = new Atributo(nombreAtributo, atributos.getInt(nombreAtributo));
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
