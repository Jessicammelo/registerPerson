package br.com.register.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.register.person.exception.NotFoundException;
import br.com.register.person.models.Address;
import br.com.register.person.models.Person;
import br.com.register.person.repository.AddressRepository;
import br.com.register.person.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AddressService addressService;

	public Person create(Person person) {
		return personRepository.save(person);
	}

	public Person findById(Integer id) {
		Optional<Person> person = personRepository.findById(id);
		if (person.isPresent()) {
			return person.get();
		} else {
			throw new NotFoundException("A pessoa não existe!...");
		}
	}
	
	public void delete(Integer id) {
		Person person  = findById(id);
		this.personRepository.delete(person);
	}
	
	public List<Person> listPerson() {
		return personRepository.findAll();
				
	}
	
	public List<Address> getAddressByPerson(Integer id){
		return addressService.getByPerson(id);
	}
}
