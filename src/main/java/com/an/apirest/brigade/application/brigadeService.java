package com.an.apirest.brigade.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.an.apirest.brigade.domain.brigade;
import com.an.apirest.brigade.infraestructure.brigadeRepository;
import com.an.apirest.brigade.infraestructure.DTO.brigadeDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class brigadeService {
    private final brigadeRepository brigadeRepo;

    public void createBrigade(brigadeDTO brigadeDTO) {
        brigade brigade = convertToEntity(brigadeDTO);
        brigadeRepo.save(brigade);
    }

    public List<brigadeDTO> getAllBrigades() {
        List<brigade> brigades = brigadeRepo.findAll();

        return brigades.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private brigadeDTO convertToDto(brigade brigade) {
        brigadeDTO brigadeDTO = new brigadeDTO();
        brigadeDTO.setId(brigade.getId());
        brigadeDTO.setName(brigade.getName());
        brigadeDTO.setDescription(brigade.getDescription());
        brigadeDTO.setStartDate(brigade.getStartDate());
        brigadeDTO.setEndDate(brigade.getEndDate());
        brigadeDTO.setStatus(brigade.getStatus());
        brigadeDTO.setCreatedAt(brigade.getCreatedAt());
        brigadeDTO.setCreatedBy(brigade.getCreatedBy());
        brigadeDTO.setUpdatedAt(brigade.getUpdatedAt());
        brigadeDTO.setUpdatedBy(brigade.getUpdatedBy());

        return brigadeDTO;
    }

    private brigade convertToEntity(brigadeDTO brigadeDTO) {

        brigade brigade = new brigade();
        brigade.setId(brigadeDTO.getId());
        brigade.setName(brigadeDTO.getName());
        brigade.setDescription(brigadeDTO.getDescription());
        brigade.setStartDate(brigadeDTO.getStartDate());
        brigade.setEndDate(brigadeDTO.getEndDate());
        brigade.setCreatedAt(brigadeDTO.getCreatedAt());
        brigade.setCreatedBy(brigadeDTO.getCreatedBy());
        brigade.setUpdatedAt(brigadeDTO.getUpdatedAt());
        brigade.setUpdatedBy(brigadeDTO.getUpdatedBy());
        return brigade;
    }

}
