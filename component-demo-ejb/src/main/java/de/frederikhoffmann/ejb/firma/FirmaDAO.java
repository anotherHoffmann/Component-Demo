package de.frederikhoffmann.ejb.firma;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class FirmaDAO implements FirmaDAOLocal {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int createFirma(Firma firma) {
		 entityManager.persist(firma);
		return firma.getId();
	}

	@Override
	public void updateFirma(Firma firma) {
		firma = entityManager.merge(firma);
	}

	@Override
	public void deleteFirma(Firma firma) {
		firma = entityManager.merge(firma);
		entityManager.remove(firma);
	}

	@Override
	public Firma readFirma(int id) {
		return entityManager.find(Firma.class, id);
	}

	@Override
	public List<Firma> readAllFirmas() {
		return entityManager.createQuery("select firma from Firma firma", Firma.class).getResultList();
	}
}
