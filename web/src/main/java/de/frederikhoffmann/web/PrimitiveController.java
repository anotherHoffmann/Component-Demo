package de.frederikhoffmann.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Beispiele für das Übertragen von primitiven Datentypen
 */
@Path("/primitive")
public class PrimitiveController {

	@GET()
	@Path("/kaffee")
	public String getKaffee() {
		return "Kaffee";
	}

	@GET
	@Path("/pi")
	public double getPi() {
		return Math.PI;
	}

	@GET
	@Path("/true")
	public boolean getTrue() {
		return true;
	}

	@GET
	@Path("/fibonacci")
	@Produces(MediaType.APPLICATION_JSON)
	public int[] getFibonacci() {
		return new int[] { 0, 1, 1, 2, 3, 5, 8, 13 };
	}

	@GET
	@Path("/square")
	public double square(@QueryParam("number") double number) {
		return Math.pow(number, 2);
	}
}

