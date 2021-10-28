package be.abis.exercise;

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

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPersonService {
	
	@Autowired
    PersonService personService;

	@Test
	public void person1ShouldBeCalledJohn() throws Exception {
		String firstName = personService.findPerson(1).getFirstName();
		assertEquals("John",firstName);
	}

	@Test
	public void thereShouldBe3PersonsInTheFile(){
		int nrOfPersons = personService.getAllPersons().size();
		assertEquals(3,nrOfPersons);
	}

	@Test
	public void personWithEmailandPwdIsMary() throws Exception {
		String firstName = personService.findPerson("mjones@abis.be","abc123").getFirstName();
		assertEquals("Mary",firstName);
	}


	@Test
	public void addNewPerson() throws IOException {
		Address a = new Address("Diestsevest",32,"3000","Leuven");
		Company c = new Company("Abis","016/455610","BE12345678",a);
		Person p = new Person(4,"Sandy","Schillebeeckx", LocalDate.of(1978,04,10),"sschillebeeckx@abis.be","abis123","nl",c);
		personService.addPerson(p);
	}

	@Test
	public void changePassWordOfAddedPerson() throws Exception {
		Person p = personService.findPerson("sschillebeeckx@abis.be","abis123");
		personService.changePassword(p,"blabla");
	}

	@Test
	public void deleteAddedPerson(){
		personService.deletePerson(4);
	}

}
