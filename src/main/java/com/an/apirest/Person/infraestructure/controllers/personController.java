package com.an.apirest.Person.infraestructure.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.an.apirest.Person.application.PersonService;
import com.an.apirest.Person.domain.Person;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class personController {

    private final PersonService personService;

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @PostMapping
    public void createPersona(@RequestBody Person person) {
        personService.createPerson(person);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable Integer id, @RequestBody Person updatedPerson) {
        personService.updatePerson(id, updatedPerson);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
    }

}
