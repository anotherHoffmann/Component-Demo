package de.frederikhoffmann.client;

import de.frederikhoffmann.ejb.adresse.Adresse;
import de.frederikhoffmann.ejb.firma.Firma;
import de.frederikhoffmann.ejb.person.Person;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class RestClient {

	private static final String personTargetString = "http://localhost:8080/web/person";

	public static void main(String[] args) {
		shortExample();
		longExample();
		square();
		String location = createPerson();
		Person person = readPerson(location);
		readAllPersons();
		person.setName("Colin Althöfer");
		updatePerson(person);
		deletePerson(person);
	}

	private static void shortExample() {
		double pi = ClientBuilder.newClient()
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
		// queryParams sind nicht klausurrelevant
		System.out.println(ClientBuilder.newClient()
				.target("http://localhost:8080/web/primitive/square")
				.queryParam("number", 4)
				.request()
				.get()
				.readEntity(Double.class));
	}

	public static String createPerson() {
		// Ich bin mir nicht sicher, ob das relevant ist, zur Sicherheit besser lernen
		String location = ClientBuilder.newClient()
				.target(personTargetString)
				.request()
				.post(Entity.entity(new Person("Frederik Hoffmann", new Adresse("Yannikweg 8", "12345", "Hanneshausen"),
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

	public static List<Person> readAllPersons() {
		// Vermutlich nicht klausurrelevant
		List<Person> personList = ClientBuilder.newClient()
				.target(personTargetString)
				.request()
				.get()
				.readEntity(new GenericType<List<Person>>() {

				});
		System.out.println(personList);
		return personList;
	}

	public static void updatePerson(Person person) {
		// vermutlich nicht klausurrelevant
		ClientBuilder.newClient()
				.target(personTargetString)
				.request()
				.put(Entity.entity(person, MediaType.APPLICATION_XML));
		System.out.println("Updated");
	}

	public static void deletePerson(Person person) {
		// vermutlich nicht klausurrelevant
		ClientBuilder.newClient().target(personTargetString).path("/" + person.getId()).request().delete();
		System.out.println("Deleted");
	}

}
