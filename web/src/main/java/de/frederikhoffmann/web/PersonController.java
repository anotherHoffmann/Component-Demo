package de.frederikhoffmann.web;

import de.frederikhoffmann.ejb.person.Person;
import de.frederikhoffmann.ejb.person.PersonDAOLocal;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

/**
 * Das Nutzen von Response ist nicht klausurrelevant
 */
@Path("/person")
public class PersonController {
	@Inject
	PersonDAOLocal personDAOLocal;

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getAllPersons() {
		List<Person> people = personDAOLocal.readAllPersons();

		// Nutzung der Generic Entity, da der sonst nicht mit einer List klar kommt
		GenericEntity<List<Person>> entity = new GenericEntity<List<Person>>(people) {

		};
		return Response.ok(entity).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getPersonById(@PathParam("id") int id) {
		return Response.ok(personDAOLocal.readPerson(id)).build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response createPerson(Person person) {
		int id = personDAOLocal.createPerson(person);
		// UriBuilder ist nicht klausurrelevant
		return Response.created(UriBuilder.fromPath("/person").path("/" + id).build()).build();
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response updatePerson(Person person) {
		personDAOLocal.updatePerson(person);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id}")
	public Response deletePerson(@PathParam("id") int id) {
		personDAOLocal.deletePerson(id);
		return Response.noContent().build();
	}
}
