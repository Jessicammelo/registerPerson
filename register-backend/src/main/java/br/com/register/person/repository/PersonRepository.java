package br.com.register.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.register.person.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
