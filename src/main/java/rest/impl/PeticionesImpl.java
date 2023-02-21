package rest.impl;

import java.util.List;

import org.json.simple.JSONObject;

import comun.Constantes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pojos.ObjetoComun;
import rest.interfaz.Peticiones;
import utilitarios.JsonUtil;
import utilitarios.LoggerUtil;

@Path("dummy")
@Produces(MediaType.APPLICATION_JSON)
public class PeticionesImpl implements Peticiones {

	private Response obtenerRespuestaDeArchivo(String nombreArchivo, int codigoRespuesta) {
		JSONObject jso = JsonUtil.leerArchivo(Constantes.PATH_ARCHIVO + nombreArchivo);
		Response respuesta = Response.status(codigoRespuesta)
				.entity(JsonUtil.obtenerArreglo(jso, Constantes.RESPUESTA_CUERPO)).build();

		List<ObjetoComun> cabeceras = JsonUtil.obtenerListaObjetoComun(jso, Constantes.RESPUESTA_CABECERA);
		for (ObjetoComun cabecera : cabeceras) {
			respuesta.getHeaders().add(cabecera.getNombre(), cabecera.getValor());
		}

		return respuesta;
	}

	@Override
	@GET
	@Path("/{nombre}/{codigo}")
	public Response simularGet(@PathParam("nombre") String nombreArchivo, @PathParam("codigo") int codigoRespuesta) {
		LoggerUtil.getLogger(JsonUtil.class.getName()).info("Consumo de servicio GET de simulación");
		return obtenerRespuestaDeArchivo(nombreArchivo, codigoRespuesta);
	}

	@Override
	@POST
	@Path("/{nombre}/{codigo}")
	public Response simularPost(@PathParam("nombre") String nombreArchivo, @PathParam("codigo") int codigoRespuesta) {
		LoggerUtil.getLogger(JsonUtil.class.getName()).info("Consumo de servicio POST de simulación");
		return obtenerRespuestaDeArchivo(nombreArchivo, codigoRespuesta);
	}

	@Override
	@PUT
	@Path("/{nombre}/{codigo}")
	public Response simularPut(@PathParam("nombre") String nombreArchivo, @PathParam("codigo") int codigoRespuesta) {
		LoggerUtil.getLogger(JsonUtil.class.getName()).info("Consumo de servicio PUT de simulación");
		return obtenerRespuestaDeArchivo(nombreArchivo, codigoRespuesta);
	}

	@Override
	@DELETE
	@Path("/{nombre}/{codigo}")
	public Response simularDelete(@PathParam("nombre") String nombreArchivo, @PathParam("codigo") int codigoRespuesta) {
		LoggerUtil.getLogger(JsonUtil.class.getName()).info("Consumo de servicio DELETE de simulación");
		return obtenerRespuestaDeArchivo(nombreArchivo, codigoRespuesta);
	}

}
