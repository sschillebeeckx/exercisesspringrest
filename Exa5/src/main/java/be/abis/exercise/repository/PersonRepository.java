package be.abis.exercise.repository;

import be.abis.exercise.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface PersonRepository {
	
	    ArrayList<Person> getAllPersons();
	    Person findPerson(int id);
	    Person findPerson(String emailAddress, String passWord);
	    List<Person> findPersonsByCompanyName(String compName);
	    void addPerson(Person p) throws IOException;
	    public void deletePerson(int id);
	    void changePassword(Person p, String newPswd) throws IOException;

}
