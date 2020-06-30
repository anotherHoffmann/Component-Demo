package de.frederikhoffmann.ejb.person;

import de.frederikhoffmann.ejb.adresse.Adresse;
import de.frederikhoffmann.ejb.firma.Firma;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlRootElement
public class Person implements Serializable {
	@Id
	@GeneratedValue
	private int id;

	private String name;

	@OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Adresse adresse;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Firma firma;

	public Person(String name, Adresse adresse, Firma firma) {
		this.name = name;
		this.adresse = adresse;
		this.firma = firma;
	}

	public Person() {
		this("", new Adresse(), new Firma());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Firma getFirma() {
		return firma;
	}

	public void setFirma(Firma firma) {
		this.firma = firma;
	}

	@Override
	public String toString() {
		return "Person{" + "id=" + id + ", name='" + name + '\'' + ", adresse=" + adresse + ", firma='"
				+ firma.getName() + "'}";
	}
}
