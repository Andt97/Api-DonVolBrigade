package com.an.apirest.brigade.infraestructure.DTO;

import com.an.apirest.Person.domain.Person;
import com.an.apirest.volunteer.domain.Volunteer;

public class brigadeVolunteerDTO {
    private Integer id;
    private Integer volunteerId;
    private Integer brigadeId;
    private Person person;
    private Volunteer volunteer;

    public brigadeVolunteerDTO() {
    }

    public brigadeVolunteerDTO(Integer id, Integer volunteerId, Integer brigadeId) {
        this.id = id;
        this.volunteerId = volunteerId;
        this.brigadeId = brigadeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Integer volunteerId) {
        this.volunteerId = volunteerId;
    }

    public Integer getBrigadeId() {
        return brigadeId;
    }

    public void setBrigadeId(Integer brigadeId) {
        this.brigadeId = brigadeId;
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }
}
