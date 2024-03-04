package com.an.apirest.volunteer.domain;

import com.an.apirest.brigade.domain.brigade;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "volunteer_brigade")
public class VolunteerBrigade {

    @Id
    @GeneratedValue
    private Integer id;
    @Getter
    @Setter

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "voluntario_id")

    private Volunteer volunteer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brigada_id")
    private brigade brigade;

  

}
