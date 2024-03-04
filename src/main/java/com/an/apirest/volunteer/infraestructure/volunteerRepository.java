package com.an.apirest.volunteer.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.an.apirest.volunteer.domain.Volunteer;

@Repository
public interface volunteerRepository extends JpaRepository<Volunteer,Integer>{
    
}