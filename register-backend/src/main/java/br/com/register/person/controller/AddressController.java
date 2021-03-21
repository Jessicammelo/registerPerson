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
import br.com.register.person.service.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@PostMapping
	public Address create(@RequestBody Address address) {
		return addressService.create(address);
	}
	
	@GetMapping("/{id}")
	public Address findById(@PathVariable Integer id) {
		return addressService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		addressService.delete(id);
	}
	
	@GetMapping
	public List<Address> listAddress() {
		return addressService.listAddress();
	}
	
	@GetMapping("/{id}/person")
	public Person getPerson(@PathVariable Integer id) {
		return addressService.getPerson(id);
	}
	
}
