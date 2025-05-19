package com.vms.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private LocalDate dateOfBirth;

    private String address;

    private String phoneNumber;

    private String emailId;

    private String role;

    public Resident(String address, LocalDate dateOfBirth, String emailId, Long id, String name, String phoneNumber,
            String role) {
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.emailId = emailId;
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public Resident() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
