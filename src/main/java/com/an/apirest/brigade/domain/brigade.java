package com.an.apirest.brigade.domain;

import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class brigade{
    @Id
    @GeneratedValue
    private Integer id;

    @Getter
    @Setter

    @Basic
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Boolean status;
    private Date createdAt;
    private Integer createdBy;
    private Date updatedAt;
    private Integer updatedBy;

}
