package tpe_prog2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainTPE2020 {

	public static void main(String[] args) {		
		String mazoPath = "src/superheroes.json";
        Mazo m = cargarMazo(mazoPath);
	
		/*Jugador j1= new Jugador("Lucrecia");
		Jugador j2= new Jugador("Gisele");

		Cualidad a1 = new Cualidad("Altura", 1.83);
		Cualidad a2 = new Cualidad("Peso", 76);
		Cualidad a3 = new Cualidad("Fuerza", 1280);
		Cualidad a4 = new Cualidad("Peleas Ganadas", 990);
		Cualidad a5 = new Cualidad("Velocidad", 155);

		Cualidad b1 = new Cualidad("Altura", 1.64);
		Cualidad b2 = new Cualidad("Peso", 137);
		Cualidad b3 = new Cualidad("Fuerza", 990);
		Cualidad b4 = new Cualidad("Peleas Ganadas", 960);
		Cualidad b5 = new Cualidad("Velocidad", 90);

		Cualidad c1 = new Cualidad("Altura", 1.78);
		Cualidad c2 = new Cualidad("Peso", 77);
		Cualidad c3 = new Cualidad("Fuerza", 730);
		Cualidad c4 = new Cualidad("Peleas Ganadas", 900);
		Cualidad c5 = new Cualidad("Velocidad", 930);

		Cualidad d1 = new Cualidad("Altura", 1.75);
		Cualidad d2 = new Cualidad("Peso", 72);
		Cualidad d3 = new Cualidad("Fuerza", 650);
		Cualidad d4 = new Cualidad("Peleas Ganadas", 925);
		Cualidad d5 = new Cualidad("Velocidad", 126);

		Cualidad e1 = new Cualidad("Altura", 1.78);
		Cualidad e2 = new Cualidad("Peso", 80);
		Cualidad e3 = new Cualidad("Fuerza", 1250);
		Cualidad e4 = new Cualidad("Peleas Ganadas", 220);
		Cualidad e5 = new Cualidad("Velocidad", 105);


		Carta carta1= new Carta("Spiderman");
		Carta carta2= new Carta("Wolverine");
		Carta carta3= new Carta("Human torch");
		Carta carta4= new Carta("Nightcrawler");
		Carta carta5= new Carta("Green Goblin");

		carta1.addCualidades(a1);
		carta1.addCualidades(a2);
		carta1.addCualidades(a3);
		carta1.addCualidades(a4);
		carta1.addCualidades(a5);

		carta2.addCualidades(b1);
		carta2.addCualidades(b2);
		carta2.addCualidades(b3);
		carta2.addCualidades(b4);
		carta2.addCualidades(b5);

		carta3.addCualidades(c1);
		carta3.addCualidades(c2);
		carta3.addCualidades(c3);
		carta3.addCualidades(c4);
		carta3.addCualidades(c5);

		carta4.addCualidades(d1);
		carta4.addCualidades(d2);
		carta4.addCualidades(d3);
		carta4.addCualidades(d4);
		carta4.addCualidades(d5);

		carta5.addCualidades(e1);
		carta5.addCualidades(e2);
		carta5.addCualidades(e3);
		carta5.addCualidades(e4);
		carta5.addCualidades(e5);

		m.addCarta(carta1);
		m.addCarta(carta2);
		m.addCarta(carta3);
		m.addCarta(carta4);
		m.addCarta(carta5);
		
		Juego j= new Juego(m,"Juego de Cartas", 2);
		j.addJugador(j1);
		j.addJugador(j2);
		
		//m.toString();
		//System.out.println(j);
		System.out.println(m);
		m.mezclarCartas();
		System.out.println(m);*/
	}
		public static Mazo cargarMazo(String jsonFile) {
	        //URL url = getClass().getResource(jsonFile);
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
	                
	                Carta unaCarta = new Carta(nombreCarta); //creo una carta y se la paso
	                
	                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
	                //String atributosStr = ""; --------comentar esto
	                for (String nombreAtributo:atributos.keySet()) {
	                    Cualidad unaCualidad = new Cualidad(nombreAtributo, atributos.getInt(nombreAtributo)); 
	                    unaCarta.addCualidades(unaCualidad);
	                    //atributosStr = atributosStr + nombreAt
	                      //      atributos.getInt(nombreAtributo) + "; ";
	                //System.out.println(nombreCarta+"\twe\t\t"+atributosStr);
	                }
	                m.addCarta(unaCarta);
	            }

	            reader.close();
	            return m;
	            
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

//final
	}


