package be.abis.exercise;

import be.abis.exercise.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPersonService {
	
	@Autowired
    PersonService personService;

	@Test
	public void person1ShouldBeCalledJohn(){
		String firstName = personService.findPerson(1).getFirstName();
		assertEquals("John",firstName);
	}

	@Test
	public void thereShouldBe3PersonsInTheFile(){
		int nrOfPersons = personService.getAllPersons().size();
		assertEquals(3,nrOfPersons);
	}

	@Test
	public void personWithEmailandPwdIsMary(){
		String firstName = personService.findPerson("mjones@abis.be","abc123").getFirstName();
		assertEquals("Mary",firstName);
	}
	
	

}
