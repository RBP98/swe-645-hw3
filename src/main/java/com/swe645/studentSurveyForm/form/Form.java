package com.swe645.studentSurveyForm.form;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Form {

    public Form(String id, String firstName, String lastName, String streetAddress, String city, String state, int zip, String telephone, String email, Date date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.telephone = telephone;
        this.email = email;
        this.date = date;
    }

    @Id
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String streetAddress;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private int zip;
    @Column(nullable = false)
    private String telephone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Date date;

    private List<CampusAttributes> campusAttributes;

    private List<UniversityInterests> interests;

    private Recommendation recommendation;

    public Form() {

    }
}
