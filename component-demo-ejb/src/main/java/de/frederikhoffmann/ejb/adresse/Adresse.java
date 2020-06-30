package de.frederikhoffmann.ejb.adresse;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlRootElement
public class Adresse implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	private String strasse;
	private String plz;
	private String ort;

	public Adresse(String strasse, String plz, String ort) {
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
	}

	public Adresse() {
		this("", "", "");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	@Override
	public String toString() {
		return "Adresse{" + "id=" + id + ", strasse='" + strasse + '\'' + ", plz='" + plz + '\'' + ", ort='" + ort
				+ '\'' + '}';
	}
}
