package be.abis.exercise.service;

import be.abis.exercise.model.Person;

import java.io.IOException;
import java.util.ArrayList;

public interface PersonService {

    ArrayList<Person> getAllPersons();
    Person findPerson(int id) throws Exception;
    Person findPerson(String emailAddress, String passWord) throws Exception;
    void addPerson(Person p) throws IOException, Exception;
    public void deletePerson(int id) throws Exception;
    void changePassword(Person p, String newPswd) throws IOException, Exception;

}
