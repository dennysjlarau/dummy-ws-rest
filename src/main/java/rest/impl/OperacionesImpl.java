package rest.impl;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import rest.interfaz.Operaciones;

@Path("operaciones")
public class OperacionesImpl implements Operaciones {

	@Override
	@GET @Path("/sumar/{n1}/{n2}")
	public String sumar(@PathParam("n1") double n1, @PathParam("n2") double n2) {
		// TODO Auto-generated method stub
		return "La suma es: " + (n1 + n2);
	}

	@Override
	@GET @Path("/restar/{n1}/{n2}")
	public String restar(@PathParam("n1") double n1, @PathParam("n2") double n2) {
		// TODO Auto-generated method stub
		return "La resta es: " + (n1 - n2);
	}

	@Override
	@GET @Path("/multiplicar/{n1}/{n2}")
	public String multiplicar(@PathParam("n1") double n1, @PathParam("n2") double n2) {
		// TODO Auto-generated method stub
		return "La multiplicación es: " + (n1 * n2);
	}

	@Override
	@GET @Path("/dividir/{n1}/{n2}")
	public String dividir(@PathParam("n1") double n1, @PathParam("n2") double n2) {
		// TODO Auto-generated method stub
		return "La división es: " + (n1 / n2);
	}

}
