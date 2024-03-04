package com.an.apirest.Person.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.an.apirest.Person.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
