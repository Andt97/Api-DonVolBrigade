package com.an.apirest.brigade.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.an.apirest.volunteer.domain.VolunteerBrigade;

@Repository
public interface brigadeVolunteerRepository extends JpaRepository<VolunteerBrigade,Integer> {

    
} 
