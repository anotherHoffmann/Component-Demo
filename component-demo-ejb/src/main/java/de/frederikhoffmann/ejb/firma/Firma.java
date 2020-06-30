package de.frederikhoffmann.ejb.firma;

import de.frederikhoffmann.ejb.person.Person;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement
public class Firma implements Serializable {
	@Id
	@GeneratedValue
	private int id;

	private String name;

	@OneToMany(mappedBy = "firma",fetch = FetchType.EAGER)
	@XmlTransient
	private List<Person> personen;

	public Firma(String name, List<Person> personen) {
		this.name = name;
		this.personen = personen;
	}

	public Firma() {
		this("", new ArrayList<Person>());
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

	@XmlTransient
	public List<Person> getPersonen() {
		return personen;
	}

	public void setPersonen(List<Person> personen) {
		this.personen = personen;
	}

	@Override
	public String toString() {
		return "Firma{" + "id=" + id + ", name='" + name + '\'' + ", personen=" + personen + '}';
	}
}
