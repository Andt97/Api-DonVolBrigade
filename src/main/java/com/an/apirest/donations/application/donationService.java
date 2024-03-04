package com.an.apirest.donations.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.an.apirest.donations.domain.donation;
import com.an.apirest.donations.infraestructure.donationRepository;
import com.an.apirest.donations.infraestructure.DTO.donationDTO;
import com.an.apirest.volunteer.domain.Volunteer;
import com.an.apirest.volunteer.infraestructure.DTO.VolunteerDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class donationService {
    private final donationRepository donationRepo;

    public void createDonation(donationDTO donationDTO) {
        donation donation = convertToEntity(donationDTO);
        donationRepo.save(donation);
    }

    public List<donationDTO> getAllDonations() {
        List<donation> donations = donationRepo.findAll();
        return donations.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public void updateDonation(Integer id, donationDTO updateDonationDTO) {
        donation existingdDonation = donationRepo.findById(id)
                .orElseThrow();

        existingdDonation.setUpdatedAt(updateDonationDTO.getUpdatedAt());
        existingdDonation.setUpdatedBy(updateDonationDTO.getUpdatedBy());

        donationRepo.save(existingdDonation);
    }

    public void deleteDonation(Integer id) {
        donationRepo.deleteById(id);
    }

    private donationDTO convertToDto(donation donation) {
        donationDTO donationDTO = new donationDTO();
        donationDTO.setId(donation.getId());

        return donationDTO;

    }

    private donation convertToEntity(donationDTO donationDTO) {
        donation donation = new donation();
        donation.setId(donationDTO.getId());
        donation.setCreatedAt(donationDTO.getCreatedAt());
        donation.setCreatedBy(donationDTO.getCreatedBy());
        donation.setUpdatedAt(donationDTO.getUpdatedAt());
        donation.setUpdatedBy(donationDTO.getUpdatedBy());

        return donation;
    }

}
