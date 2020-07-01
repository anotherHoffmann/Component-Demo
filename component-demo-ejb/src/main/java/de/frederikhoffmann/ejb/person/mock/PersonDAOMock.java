package de.frederikhoffmann.ejb.person.mock;

import de.frederikhoffmann.ejb.person.Person;
import de.frederikhoffmann.ejb.person.PersonDAOLocal;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Durch den Qualifier {@link Mock} wird diese Klasse nur injiziert, wenn dieser explizit angeben wird
 */
@Stateless
@Mock
public class PersonDAOMock implements PersonDAOLocal {
	@Override
	public int createPerson(Person person) {
		System.out.println("Create");
		return 0;
	}

	@Override
	public void updatePerson(Person person) {
		System.out.println("Update");
	}

	@Override
	public void deletePerson(int id) {
		System.out.println("delete");
	}

	@Override
	public Person readPerson(int id) {
		System.out.println("Read");
		return null;
	}

	@Override
	public List<Person> readAllPersons() {
		System.out.println("Read All");
		return null;
	}
}
