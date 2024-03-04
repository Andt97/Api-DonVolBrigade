package com.an.apirest.brigade.infraestructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.an.apirest.brigade.application.brigadeService;
import com.an.apirest.brigade.infraestructure.DTO.brigadeDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Brigade")
@RequiredArgsConstructor
public class brigadeController {
    private final brigadeService brigadeSer;

    @GetMapping
    public List<brigadeDTO> getAllBrigades() {
        return brigadeSer.getAllBrigades();
    }

    @PostMapping
    public void createBrigade(@RequestBody brigadeDTO brigadeDTO) {
        brigadeSer.createBrigade(brigadeDTO);
    }

    @PutMapping("/{id}")
    public void updateBrigade(@PathVariable Integer id, @RequestBody brigadeDTO updateBrigadeDTO) {
    }

    @DeleteMapping("/{id}")
    public void deleteBrigade(@PathVariable Integer id) {
    }

}
