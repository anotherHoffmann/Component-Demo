package de.frederikhoffmann.ejb.person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonDAO implements PersonDAOLocal {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int createPerson(Person person) {
		entityManager.persist(person);
		return person.getId();
	}

	@Override
	public Person readPerson(int id) {

		return entityManager.find(Person.class, id);
	}

	@Override
	public List<Person> readAllPersons() {

		return entityManager.createQuery("SELECT person FROM Person person", Person.class).getResultList();
	}

	@Override
	public void updatePerson(Person person) {
		entityManager.merge(person);
	}

	@Override
	public void deletePerson(int id) {
		Person person = entityManager.find(Person.class, id);

		entityManager.remove(person);
	}
}
