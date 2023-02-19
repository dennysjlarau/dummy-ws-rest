package rest.impl;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import commun.JsonSimple;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import pojo.Respuesta;
import rest.interfaz.Operaciones;
import rest.interfaz.Peticiones;

@Path("dummy")
public class PeticionesImpl implements Peticiones {

	@Override
	@GET @Path("/{nombre}")
	public String simular(@PathParam("nombre") String nombreArchivo) {
		Respuesta res = null;
		try {
			res = JsonSimple.obtenerRespuestaArchivo(nombreArchivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return res.getCuerpo();
	}

}
