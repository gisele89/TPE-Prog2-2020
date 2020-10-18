package tpe_prog2;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CargadorMazo {
	public static Mazo cargarMazo(String jsonFile) {

	    Mazo mazo=new Mazo();
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
                    Atributo unaCualidad = new Atributo(nombreAtributo, atributos.getInt(nombreAtributo));
                    unaCarta.addCualidad(unaCualidad);
                    //atributosStr = atributosStr + nombreAtributo + ": " +
                      //      atributos.getInt(nombreAtributo) + "; ";
                //System.out.println(nombreCarta+"\t\t\t"+atributosStr);
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
	

    }


