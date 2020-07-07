package de.frederikhoffmann.client;

import de.frederikhoffmann.ejb.adresse.Adresse;
import de.frederikhoffmann.ejb.firma.Firma;
import de.frederikhoffmann.ejb.person.Person;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Hello world!
 */
public class RestClient {
	public static void main(String[] args) {
		shortExample();
		longExample();
		square();
		String location = createPerson();
		readPerson(location);
	}

	private static void shortExample() {
		Double pi = ClientBuilder.newClient()
				.target("http://localhost:8080/web/primitive/pi")
				.request()
				.get()
				.readEntity(Double.class);

		System.out.println(pi);
	}

	public static void longExample() {
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target("http://localhost:8080/web/primitive/kaffee");

		Invocation invocation = target.request().buildGet();

		String kaffee = invocation.invoke().readEntity(String.class);

		System.out.println(kaffee);

	}

	public static void square() {
		System.out.println(ClientBuilder.newClient()
				.target("http://localhost:8080/web/primitive/square")
				// queryParams sind nicht klausurrelevant
				.queryParam("number", 4)
				.request()
				.get()
				.readEntity(Double.class));
	}

	public static String createPerson() {
		String location = ClientBuilder.newClient()
				.target("http://localhost:8080/web/person")
				.request()
				.post(Entity.entity(new Person("Frederik Hoffmann", new Adresse("Yannikweg 8", "44143", "Hanneshausen"),
						new Firma("Dennis Inc.", new ArrayList<Person>())), MediaType.APPLICATION_XML))
				.getHeaderString("Location");
		System.out.println(location);
		return location;
	}

	public static Person readPerson(String location) {
		Person person = ClientBuilder.newClient().target(location).request().get().readEntity(Person.class);
		System.out.println(person);
		return person;
	}

}
