package br.com.register.person.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.register.person.exception.NotFoundException;
import br.com.register.person.models.Person;
import br.com.register.person.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	public Person creat(Person person) {
		return personRepository.save(person);
	}

	public Person findById(Integer Id) {
		Optional<Person> person = personRepository.findById(Id);
		if (person.isPresent()) {
			return person.get();
		} else {
			throw new NotFoundException();
		}
	}
	
	public void delete(Integer Id) {
		Person person  = findById(Id);
		this.personRepository.delete(person);
	}
}
