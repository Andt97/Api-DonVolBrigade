package com.an.apirest.Person.application;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.an.apirest.Person.domain.Person;
import com.an.apirest.Person.infraestructure.PersonRepository;
import com.an.apirest.donor.domain.Donor;
import com.an.apirest.donor.infraestructure.donorRepositpory;
import com.an.apirest.volunteer.domain.Volunteer;
import com.an.apirest.volunteer.infraestructure.volunteerRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepo;
    private final donorRepositpory donorRepo;
    private final volunteerRepository volunteerRepo;

    public void createPerson(Person person) {
        personRepo.save(person);
        if (person.getDonor() != null && person.getDonor()) {
            Donor donor = new Donor();
            donor.setPerson(person);
            donorRepo.save(donor);

        }
        if (person.getVolunteer() != null && person.getVolunteer()) {
            Volunteer volunteer = new Volunteer();
            volunteer.setPerson(person);
            volunteerRepo.save(volunteer);
        }
    }

    public List<Person> getAllPerson() {
        return personRepo.findAll();
    }

    public void updatePerson(Integer id, Person updatedPerson) {
        Optional<Person> optionalPerson = personRepo.findById(id);

        if (optionalPerson.isPresent()) {
            Person existingPerson = optionalPerson.get();
            existingPerson.setFirstName(updatedPerson.getFirstName());
            existingPerson.setSecondName(updatedPerson.getSecondName());
            existingPerson.setLastName(updatedPerson.getLastName());
            existingPerson.setSecondLastName(updatedPerson.getSecondLastName());
            existingPerson.setGender(updatedPerson.getGender());
            existingPerson.setEmail(updatedPerson.getEmail());
            existingPerson.setAddress(updatedPerson.getAddress());
            existingPerson.setIdentification(updatedPerson.getIdentification());
            existingPerson.setPhone(updatedPerson.getPhone());
            existingPerson.setDonor(updatedPerson.getDonor());
            existingPerson.setVolunteer(updatedPerson.getVolunteer());
            existingPerson.setCreatedAt(updatedPerson.getCreatedAt());
            existingPerson.setCreatedBy(updatedPerson.getCreatedBy());
            existingPerson.setUpdatedAt(updatedPerson.getUpdatedAt());
            existingPerson.setUpdatedBy(updatedPerson.getUpdatedBy());

            personRepo.save(existingPerson);
        } else {
                 }
    }

    public void deletePerson(Integer id) {
        personRepo.deleteById(id);
    }
}
