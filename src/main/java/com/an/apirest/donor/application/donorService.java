package com.an.apirest.donor.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.an.apirest.Person.domain.Person;
import com.an.apirest.donor.domain.Donor;
import com.an.apirest.donor.infraestructure.donorRepositpory;
import com.an.apirest.donor.infraestructure.DTO.DonorDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class donorService {

    private final donorRepositpory donorRepo;

    @SuppressWarnings("null")
    public void createDonor(DonorDTO donorDTO) {
        Donor donor = convertToEntity(donorDTO);
        donorRepo.save(donor);
    }

    public List<DonorDTO> getAllDonors() {
        List<Donor> donors = donorRepo.findAll();
        return donors.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public void updateDonor(Integer id, DonorDTO updateDonorDTO) {
        Donor existingDonor = donorRepo.findById(id)
                .orElseThrow();

        existingDonor.setUpdatedAt(updateDonorDTO.getUpdatedAt());
        existingDonor.setUpdatedBy(updateDonorDTO.getUpdatedBy());

        donorRepo.save(existingDonor);
    }

    public void deleteDonor(Integer id) {
        donorRepo.deleteById(id);
    }

    private DonorDTO convertToDto(Donor donor) {
        DonorDTO donorDTO = new DonorDTO();
        donorDTO.setId(donor.getId());
        if (donor.getPerson() != null) {
            donorDTO.setPersonId(donor.getPerson().getId());
        }
        donorDTO.setCreatedAt(donor.getCreatedAt());
        donorDTO.setCreatedBy(donor.getCreatedBy());
        donorDTO.setUpdatedAt(donor.getUpdatedAt());
        donorDTO.setUpdatedBy(donor.getUpdatedBy());

        Person person = donor.getPerson();
        if (person != null) {
            donorDTO.setPerson(person);
            donorDTO.setPersonId(person.getId());
            donorDTO.setCreatedAt(person.getCreatedAt());
            donorDTO.setCreatedBy(person.getCreatedBy());
            donorDTO.setUpdatedAt(person.getUpdatedAt());
            donorDTO.setUpdatedBy(person.getUpdatedBy());

        }
        return donorDTO;
    }

    private Donor convertToEntity(DonorDTO donorDTO) {

        Donor donor = new Donor();
        donor.setId(donorDTO.getId());
        donor.setCreatedAt(donorDTO.getCreatedAt());
        donor.setCreatedBy(donorDTO.getCreatedBy());
        donor.setUpdatedAt(donorDTO.getUpdatedAt());
        donor.setUpdatedBy(donorDTO.getUpdatedBy());
        return donor;
    }

}
