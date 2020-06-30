package de.frederikhoffmann.ejb.person;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PersonDAOLocal {
	public int createPerson(Person person);

	public void updatePerson(Person person);

	public void deletePerson(int id);

	public Person readPerson(int id);

	public List<Person> readAllPersons();
}

