package com.an.apirest.Person.domain;

import java.sql.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Integer id;
    @Basic
    private String firstName;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private String gender;
    private String email;
    private String address;
    private String identification;
    private String phone;
    private Boolean donor;
    private Boolean volunteer;
    private Date createdAt;
    private Integer createdBy;
    private Date updatedAt;
    private Integer updatedBy;
    private String status;
}
