package com.an.apirest.donor.infraestructure.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.an.apirest.donor.application.donorService;
import com.an.apirest.donor.infraestructure.DTO.DonorDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Donor")
@RequiredArgsConstructor
public class donorController {

    private final donorService donorServi;

    @GetMapping
    public List<DonorDTO> getAllDonor() {
        return donorServi.getAllDonors();
    }

    @PostMapping
    public void createDonor(@RequestBody DonorDTO donorDTO) {
        donorServi.createDonor(donorDTO);
    }

    @PutMapping("/{id}")
    public void updateDonor(@PathVariable Integer id, @RequestBody DonorDTO updateDonorDTO) {
        donorServi.updateDonor(id, updateDonorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDonor(@PathVariable Integer id) {
        donorServi.deleteDonor(id);
    }

}
