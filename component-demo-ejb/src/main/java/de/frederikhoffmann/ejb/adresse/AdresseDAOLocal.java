package de.frederikhoffmann.ejb.adresse;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

@Local
public interface AdresseDAOLocal {
	public int createAdresse(Adresse adresse);

	public void updateAdresse(Adresse adresse);

	public void deleteAdresse(Adresse adresse);

	public Adresse readAdresse(int id);

	public List<Adresse> readAllAdresses();
}
