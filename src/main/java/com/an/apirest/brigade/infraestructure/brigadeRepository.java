package com.an.apirest.brigade.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.an.apirest.brigade.domain.brigade;

@Repository
public interface brigadeRepository extends JpaRepository<brigade,Integer>{
    
}
