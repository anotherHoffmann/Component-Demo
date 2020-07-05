package de.frederikhoffmann.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

/**
 * Hello world!
 */
public class RestClient {
	public static void main(String[] args) {
		shortExample();
		longExample();

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

}
