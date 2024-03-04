package com.an.apirest.volunteer.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.an.apirest.Person.domain.Person;
import com.an.apirest.volunteer.domain.Volunteer;
import com.an.apirest.volunteer.infraestructure.volunteerRepository;
import com.an.apirest.volunteer.infraestructure.DTO.VolunteerDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class volunteerService {

    private final volunteerRepository volunteerRepo;

    public void createvolunteer(VolunteerDTO volunteerDTO) {
        Volunteer volunteer = convertToEntity(volunteerDTO);
        volunteerRepo.save(volunteer);
    }

    public List<VolunteerDTO> getAllVolunteers() {
        List<Volunteer> donors = volunteerRepo.findAll();
        return donors.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public void updateVolunteer(Integer id, VolunteerDTO updateVolunteerDTO) {
        Volunteer existingVolunteer = volunteerRepo.findById(id)
                .orElseThrow();

        existingVolunteer.setUpdatedAt(updateVolunteerDTO.getUpdatedAt());
        existingVolunteer.setUpdatedBy(updateVolunteerDTO.getUpdatedBy());

        volunteerRepo.save(existingVolunteer);
    }

    public void deleteVolunteer(Integer id) {
        volunteerRepo.deleteById(id);
    }

    private VolunteerDTO convertToDto(Volunteer volunteer) {
        VolunteerDTO volunteerDTO = new VolunteerDTO();
        volunteerDTO.setId(volunteer.getId());
        if (volunteer.getPerson() != null) {
            volunteerDTO.setPersonId(volunteer.getPerson().getId());
        }
        volunteerDTO.setCreatedAt(volunteer.getCreatedAt());
        volunteerDTO.setCreatedBy(volunteer.getCreatedBy());
        volunteerDTO.setUpdatedAt(volunteer.getUpdatedAt());
        volunteerDTO.setUpdatedBy(volunteer.getUpdatedBy());

        Person person = volunteer.getPerson();
        if (person != null) {
            volunteerDTO.setPerson(person);
            volunteerDTO.setPersonId(person.getId());
            volunteerDTO.setCreatedAt(person.getCreatedAt());
            volunteerDTO.setCreatedBy(person.getCreatedBy());
            volunteerDTO.setUpdatedAt(person.getUpdatedAt());
            volunteerDTO.setUpdatedBy(person.getUpdatedBy());

        }
        return volunteerDTO;
    }

    private Volunteer convertToEntity(VolunteerDTO volunteerDTO) {

        Volunteer volunteer = new Volunteer();
        volunteer.setId(volunteerDTO.getId());
        volunteer.setCreatedAt(volunteerDTO.getCreatedAt());
        volunteer.setCreatedBy(volunteerDTO.getCreatedBy());
        volunteer.setUpdatedAt(volunteerDTO.getUpdatedAt());
        volunteer.setUpdatedBy(volunteerDTO.getUpdatedBy());
        return volunteer;
    }
}
