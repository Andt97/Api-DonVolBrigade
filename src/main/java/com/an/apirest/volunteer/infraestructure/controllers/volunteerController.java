package com.an.apirest.volunteer.infraestructure.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.an.apirest.volunteer.application.volunteerService;
import com.an.apirest.volunteer.infraestructure.DTO.VolunteerDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("Volunteer")
@RequiredArgsConstructor
public class volunteerController {

    private final volunteerService volunteerServi;

    @GetMapping
    public List<VolunteerDTO> getAllVolunteer(){
        return volunteerServi.getAllVolunteers();

    }

    @PostMapping
    public void createvolunteer(@RequestBody VolunteerDTO volunteerDTO){
        volunteerServi.createvolunteer(volunteerDTO);
    }
    @PutMapping("/{id}")
    public void updateVolunteer(@PathVariable Integer id,@RequestBody VolunteerDTO upVolunteerDTO){
        volunteerServi.updateVolunteer(id, upVolunteerDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteVolunteer(@PathVariable Integer id){
        volunteerServi.deleteVolunteer(id);
    }

}
