package com.an.apirest.donations.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.an.apirest.donations.domain.donation;

@Repository
public interface donationRepository extends JpaRepository<donation,Integer>{

    
} 
