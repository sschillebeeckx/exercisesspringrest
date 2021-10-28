package be.abis.exercise;


import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPersonServiceValidations {
	
	@Autowired
    PersonService ps;


	@Test
	public void testAddPerson() {
		Person p;
		try {
			p = ps.findPerson(2);
			Person newPers = new Person(5,"Sandy","Schillebeeckx", LocalDate.of(1978, 04,10),"sschillebeeckx@abis.be","x","nl",p.getCompany());
			ps.addPerson(newPers);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testChangePassword() {
		Person p=null;
		try {
			p = ps.findPerson(1);
			p.setPassword("x");
			ps.changePassword(p,"x");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
