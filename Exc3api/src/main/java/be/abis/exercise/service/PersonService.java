package be.abis.exercise.service;

import be.abis.exercise.exception.PersonAlreadyExistsException;
import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.exception.PersonNotFoundException;
import be.abis.exercise.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface PersonService {

    ArrayList<Person> getAllPersons();
    Person findPerson(int id) throws PersonNotFoundException;
    Person findPerson(String emailAddress, String passWord) throws PersonNotFoundException;
    public List<Person> findPersonsByCompanyName(String compName);
    void addPerson(Person p) throws IOException, PersonAlreadyExistsException;
    public void deletePerson(int id) throws PersonCanNotBeDeletedException;
    void changePassword(Person p, String newPswd) throws IOException;

}
