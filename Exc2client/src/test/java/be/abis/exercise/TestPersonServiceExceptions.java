package be.abis.exercise;

import be.abis.exercise.exception.PersonAlreadyExistsException;
import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.exception.PersonNotFoundException;
import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPersonServiceExceptions {
	
	@Autowired
    PersonService personService;

	@Test(expected= PersonNotFoundException.class)
	public void person5ThrowsException() throws Exception {
		String firstName = personService.findPerson(5).getFirstName();
	}

	@Test(expected= PersonNotFoundException.class)
	public void personWithEmailandPwdIWrong() throws Exception {
		String firstName = personService.findPerson("mjones@abis.be","abc12").getFirstName();
	}

	@Test(expected= PersonAlreadyExistsException.class)
	public void addNewPersonWhoAlreadyExists() throws Exception {
		Address a = new Address("Diestsevest",32,"3000","Leuven");
		Company c = new Company("Abis","016/455610","BE12345678",a);
		Person p = new Person(4,"Mary","Schillebeeckx", LocalDate.of(1978,04,10),"mjones@abis.be","abis123","nl",c);
		personService.addPerson(p);
	}

	@Test(expected= PersonCanNotBeDeletedException.class)
	public void deleteAddedPerson() throws Exception {
		personService.deletePerson(4);
	}

}
