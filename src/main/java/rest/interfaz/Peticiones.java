package rest.interfaz;

import jakarta.ws.rs.core.Response;

public interface Peticiones {

	public Response simularGet(String nombreArchivo, int codigoRespuesta);

	public Response simularPost(String nombreArchivo, int codigoRespuesta);

	public Response simularPut(String nombreArchivo, int codigoRespuesta);

	public Response simularDelete(String nombreArchivo, int codigoRespuesta);

}
