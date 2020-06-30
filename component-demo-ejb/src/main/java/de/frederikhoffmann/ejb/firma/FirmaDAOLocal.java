package de.frederikhoffmann.ejb.firma;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

@Local
public interface FirmaDAOLocal {
	public int createFirma(Firma firma);

	public void updateFirma(Firma firma);

	public void deleteFirma(Firma firma);

	public Firma readFirma(int id);

	public List<Firma> readAllFirmas();
}
