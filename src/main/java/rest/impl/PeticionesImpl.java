package rest.impl;

import org.json.simple.JSONObject;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import rest.interfaz.Peticiones;
import utilitarios.JsonUtil;

@Path("dummy")
public class PeticionesImpl implements Peticiones {

	private final static String PATH_ARCHIVO = "c:/var/dummy/";

	@Override
	@GET
	@Path("/{nombre}/{etiqueta}")
	@Produces(MediaType.APPLICATION_JSON)
	public String simular(@PathParam("nombre") String nombreArchivo, @PathParam("etiqueta") String etiqueta) {
		JSONObject jso = JsonUtil.leerArchivo(PATH_ARCHIVO + nombreArchivo);
		return JsonUtil.obtenerArreglo(jso, etiqueta);
	}

}
