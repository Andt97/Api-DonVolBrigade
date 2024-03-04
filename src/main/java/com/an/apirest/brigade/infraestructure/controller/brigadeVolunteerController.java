package com.an.apirest.brigade.infraestructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.an.apirest.brigade.application.briadeVolunteerService;
import com.an.apirest.brigade.infraestructure.DTO.brigadeVolunteerDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/brigadeVolunteer")
@RequiredArgsConstructor
public class brigadeVolunteerController {
    private final briadeVolunteerService brigadeVolunteerService;

    @GetMapping
    public List<brigadeVolunteerDTO> getAllBrigadesVolunteer() {
        return brigadeVolunteerService.getAllBrigadesVolunteer();
    }

    @PostMapping
    public void createBrigadeVolunteer(@RequestBody brigadeVolunteerDTO brigadeVolunteerDTO) {
        brigadeVolunteerService.createBrigadeVolunteer(brigadeVolunteerDTO);
    }

    @PutMapping("/{id}")
    public void updateBrigadeVolunteer(@PathVariable Integer id,
            @RequestBody brigadeVolunteerDTO updBrigadeVolunteerDTO) {

    }

    @DeleteMapping("/{id}")
    public void deleteteBrigadeVolunteer(@PathVariable Integer id) {

    }

}
