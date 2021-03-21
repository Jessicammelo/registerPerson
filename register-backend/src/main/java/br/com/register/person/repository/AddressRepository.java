package br.com.register.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.register.person.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	public List<Address> findByPersonId(Integer id);

}
