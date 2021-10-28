package be.abis.exercise.controller;

import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("persons")
public class PersonController {
     
	@Autowired
	PersonService ps;
	
	@GetMapping("{id}")
	public Person findPerson(@PathVariable int id){
		Person p = ps.findPerson(id);
		return p;
	}

	@GetMapping("")
	public ArrayList<Person> getAllPersons(){
		return ps.getAllPersons();
	}

	@PostMapping("/login")
	public Person findPersonByMailAndPwd(@RequestBody Login login){
		Person p = ps.findPerson(login.getEmail(), login.getPassword());
		return p;
	}

	@PostMapping("")
	public void addPerson(@RequestBody Person p){
		try {
			ps.addPerson(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@DeleteMapping("{id}")
	public void deletePerson(@PathVariable("id") int id) {
			ps.deletePerson(id);
	}


	@PutMapping("{id}")
	public void changePassword(@PathVariable("id") int id, @RequestBody Person person)  {
		try {
			System.out.println("changing password to newpswd= " + person.getPassword());
			ps.changePassword(ps.findPerson(id), person.getPassword());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
