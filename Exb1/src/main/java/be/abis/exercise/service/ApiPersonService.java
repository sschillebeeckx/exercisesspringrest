package be.abis.exercise.service;

import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class ApiPersonService implements PersonService {

    @Autowired
    private RestTemplate rt;

    private String baseUri = "http://localhost:8085/exercise/api/persons";

    @Override
    public Person findPerson(int id) {
        return rt.getForObject(baseUri+"/"+id,Person.class);
    }

    @Override
    public ArrayList<Person> getAllPersons() {
       ResponseEntity<ArrayList<Person>> persons = rt.exchange(baseUri, HttpMethod.GET,null,new ParameterizedTypeReference<ArrayList<Person>>(){});
        return persons.getBody();
    }

    @Override
    public Person findPerson(String emailAddress, String passWord) {
        Login login = new Login();
        login.setEmail(emailAddress);
        login.setPassword(passWord);
        Person person = rt.postForObject(baseUri+"/login",login,Person.class);
        return person;
    }

    @Override
    public void addPerson(Person p) throws IOException {
        rt.postForObject(baseUri,p,Void.class);
        System.out.println("person added ");
    }

    @Override
    public void deletePerson(int id) {
        rt.delete(baseUri+"/"+id);
        System.out.println("person deleted ");
    }

    @Override
    public void changePassword(Person p, String newPswd) throws IOException {
        p.setPassword(newPswd);
        rt.put(baseUri+"/"+p.getPersonId(),p);
        System.out.println("password changed ");
    }
}
