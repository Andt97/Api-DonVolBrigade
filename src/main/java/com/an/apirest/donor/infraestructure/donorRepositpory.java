package com.an.apirest.donor.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.an.apirest.donor.domain.Donor;

@Repository
public interface donorRepositpory extends JpaRepository<Donor,Integer> {
    
}
