package be.abis.exercise.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.List;

@JacksonXmlRootElement(localName="persons")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Persons {

	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName="person")
	private  List<Person> persons;

	public  List<Person> getPersons() {
		return persons;
	}


	public  void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	
	
	
}
