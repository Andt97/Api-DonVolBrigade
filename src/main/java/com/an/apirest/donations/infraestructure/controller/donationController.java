package com.an.apirest.donations.infraestructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.an.apirest.donations.application.donationService;
import com.an.apirest.donations.infraestructure.DTO.donationDTO;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("Donation")
public class donationController {
    private final donationService donationServi;

    @GetMapping
    public List<donationDTO> getAllDonation() {
        return donationServi.getAllDonations();
    }

    @PostMapping
    public void createDonor(@RequestBody donationDTO donationDTO) {
        donationServi.createDonation(donationDTO);
    }

    @PutMapping("/{id}")
    public void updateDonation(@PathVariable Integer id, @RequestBody donationDTO updateDonationDTO) {
        donationServi.updateDonation(id, updateDonationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteVolunteer(@PathVariable Integer id) {
        donationServi.deleteDonation(id);
    }
}
