package br.com.register.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.register.person.exception.NotFoundException;
import br.com.register.person.models.Address;
import br.com.register.person.models.Person;
import br.com.register.person.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private PersonService personService;
	
	public Address create(Address address) {
		if (address.getPersonId() != null) {
			personService.findById(address.getPersonId());
		}
		return addressRepository.save(address);
	}

	public Address findById(Integer id) {
		Optional<Address> address = addressRepository.findById(id);
		if (address.isPresent()) {
			return address.get();
		} else {
			throw new NotFoundException("O endereço não existe..");
		}
	}
	
	public void delete(Integer id) {
		Address address  = findById(id);
		this.addressRepository.delete(address);
	}
	
	public List<Address> listAddress() {
		return addressRepository.findAll();	
	}
	
	public List<Address> getByPerson(Integer id){
		return addressRepository.findByPersonId(id);
	}
	
	public Person getPerson(Integer id) {
		Address address = findById(id);
		return personService.findById(address.getPersonId());
	}
}
