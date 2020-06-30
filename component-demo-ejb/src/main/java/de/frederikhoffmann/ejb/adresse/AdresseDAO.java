package de.frederikhoffmann.ejb.adresse;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AdresseDAO implements AdresseDAOLocal {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int createAdresse(Adresse adresse) {
		entityManager.persist(adresse);
		return adresse.getId();
	}

	@Override
	public void updateAdresse(Adresse adresse) {
		entityManager.merge(adresse);
	}

	@Override
	public void deleteAdresse(Adresse adresse) {
		adresse = entityManager.merge(adresse);

		entityManager.remove(adresse);
	}

	@Override
	public Adresse readAdresse(int id) {
		return entityManager.find(Adresse.class, id);
	}

	@Override
	public List<Adresse> readAllAdresses() {
		return entityManager.createQuery("select adresse from Adresse adresse", Adresse.class).getResultList();
	}
}
