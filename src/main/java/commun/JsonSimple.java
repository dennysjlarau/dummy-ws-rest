package commun;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import pojo.Respuesta;

public final class JsonSimple {

	public static Respuesta obtenerRespuestaArchivo (String nombreArchivo) throws FileNotFoundException, IOException, ParseException {
		Respuesta res = new Respuesta();
		
		Object ob = new JSONParser().parse(new FileReader("c:/var/JSONFile.json"));
        JSONObject js = (JSONObject) ob;

        String firstName = (String) js.get("firstName");
        String lastName = (String) js.get("lastName");

        res.setCuerpo("First name is: " + firstName);
        res.setCuerpo( res.getCuerpo() + " Last name is: " +lastName);
        
        JSONArray jsonArray= (JSONArray) js.get("phoneNumbers");
        for(int i=0; i<jsonArray.size(); i++){
        	res.setCuerpo( res.getCuerpo() + jsonArray.get(i));
        }
		
		return res;
	}
}
