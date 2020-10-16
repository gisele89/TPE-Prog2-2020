package tpe_prog2;
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

public class VisorMazo {
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
                    //atributosStr = atributosStr + nombreAtributo + ": " +
                      //      atributos.getInt(nombreAtributo) + "; ";
                //System.out.println(nombreCarta+"\t\t\t"+atributosStr);
                }
                mazo.addCarta(unaCarta);
            }

            reader.close();
            return mazo;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void cargar(String jsonFile) {
        File jsonInputFile = new File(jsonFile);

	}
	
    public static void main(String[] args) {
        String mazoPath = "src/superheroes.json";
        VisorMazo.cargarMazo(mazoPath);
        
        //Mazo m = new Mazo();        
		//Jugador j1= new Jugador("Lucrecia");
		//Jugador j2= new Jugador("Gisele");
		
		//Juego j= new Juego(m,"Juego de Cartas", 2);
		//j.addJugador(j1);
		//j.addJugador(j2);
		
		//m.toString();
		//System.out.println(j);
		//System.out.println(m);
		//m.mezclarCartas();
		//System.out.println(m);
        
    }

}
