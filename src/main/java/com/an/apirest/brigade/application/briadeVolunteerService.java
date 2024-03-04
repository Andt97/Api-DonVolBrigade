package com.an.apirest.brigade.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.an.apirest.brigade.infraestructure.brigadeVolunteerRepository;
import com.an.apirest.brigade.infraestructure.DTO.brigadeVolunteerDTO;
import com.an.apirest.volunteer.domain.Volunteer;
import com.an.apirest.volunteer.domain.VolunteerBrigade;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class briadeVolunteerService {
    private final brigadeVolunteerRepository brigadeVolunterRepo;

    public void createBrigadeVolunteer(brigadeVolunteerDTO brigVolunteerDTO) {
        VolunteerBrigade brigadeVolunteer = convertToEntity(brigVolunteerDTO);
        brigadeVolunterRepo.save(brigadeVolunteer);
    }

    public List<brigadeVolunteerDTO> getAllBrigadesVolunteer() {
        List<VolunteerBrigade> brigadesVolunteer = brigadeVolunterRepo.findAll();
        return brigadesVolunteer.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private brigadeVolunteerDTO convertToDto(VolunteerBrigade brigadeVolunteer) {
        brigadeVolunteerDTO brigadeVolunteerDTO = new brigadeVolunteerDTO();
        brigadeVolunteerDTO.setId(brigadeVolunteer.getId());
        if (brigadeVolunteer.getBrigade() != null) {
            brigadeVolunteerDTO.setBrigadeId(brigadeVolunteer.getBrigade().getId());

        }
        if (brigadeVolunteer.getVolunteer() != null) {
            brigadeVolunteerDTO.setVolunteerId(brigadeVolunteer.getBrigade().getId());
        }

        Volunteer volunteer = brigadeVolunteer.getVolunteer();
        if (volunteer != null) {
            brigadeVolunteerDTO.setVolunteer(volunteer);
            brigadeVolunteerDTO.setVolunteerId(volunteer.getId());
        }

        return brigadeVolunteerDTO;
    }

    private VolunteerBrigade convertToEntity(brigadeVolunteerDTO brigVolunteerDto) {
        VolunteerBrigade brigadeVolunteer = new VolunteerBrigade();
        brigadeVolunteer.setId(brigVolunteerDto.getId());
        return brigadeVolunteer;
    }

}
