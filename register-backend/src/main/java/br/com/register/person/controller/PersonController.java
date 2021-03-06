package br.com.register.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.register.person.models.Address;
import br.com.register.person.models.Person;
import br.com.register.person.service.PersonService;

@RestController
@RequestMapping("/people")//plural
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping
	public Person create(@RequestBody Person person) {
		return personService.create(person);
	}
	
	@GetMapping("/{id}")
	public Person findById(@PathVariable Integer id) {
		return personService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		personService.delete(id);
	}
	
	@GetMapping
	public List<Person> listPerson() {
		return personService.listPerson();
	}
	
	@GetMapping("/{id}/address")
	public List<Address> listAddress(@PathVariable Integer id){
		return personService.getAddressByPerson(id);
	}
}
