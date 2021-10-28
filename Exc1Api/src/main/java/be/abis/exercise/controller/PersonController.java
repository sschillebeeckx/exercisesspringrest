package be.abis.exercise.controller;

import be.abis.exercise.exception.ApiError;
import be.abis.exercise.exception.PersonNotFoundException;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.model.Persons;
import be.abis.exercise.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("persons")
public class PersonController {
     
	@Autowired
	PersonService ps;

	@GetMapping("")
	public ArrayList<Person> getAllPersons(){
		return ps.getAllPersons();
	}

	@GetMapping("{id}")
	public ResponseEntity<? extends Object> findPerson(@PathVariable("id") int id) {

		try {
			Person p = ps.findPerson(id);
			return new ResponseEntity<Object>(p, HttpStatus.OK);
		} catch (PersonNotFoundException pnfe) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			ApiError err = new ApiError("person not found", status.value(), pnfe.getMessage());
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("content-type", MediaType.APPLICATION_PROBLEM_JSON_VALUE);
			return new ResponseEntity<Object>(err, responseHeaders, status);
		}

	}

	@PostMapping("/login")
	public ResponseEntity<Object> findPersonByMailAndPwd(@RequestBody Login login) {

		try {
			Person p = ps.findPerson(login.getEmail(), login.getPassword());
			return new ResponseEntity<Object>(p, HttpStatus.OK);
		} catch (PersonNotFoundException pnfe) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			ApiError err = new ApiError("person not found", status.value(), pnfe.getMessage());
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("content-type", MediaType.APPLICATION_PROBLEM_JSON_VALUE);
			return new ResponseEntity<Object>(err, responseHeaders, status);
		}
	}



	/*@GetMapping(path="/compquery", produces=MediaType.APPLICATION_XML_VALUE)
	public List<Person> findPersonsByCompanyNameBoth(@RequestParam("compname") String compName) {
        ps.findPersonsByCompanyName(compName);
		return ps.findPersonsByCompanyName(compName);
	}*/

	@GetMapping(path="/compquery", produces=MediaType.APPLICATION_XML_VALUE)
	public Persons findPersonsByCompanyNameBoth(@RequestParam("compname") String compName) {
		Persons persons = new Persons();
		persons.setPersons(ps.findPersonsByCompanyName(compName));
		return persons;
	}

	@PostMapping(path="",consumes={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
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
		} catch (IOException | PersonNotFoundException e) {
			e.printStackTrace();
		}
	}
}
