package com.techelevator.model;

import java.time.LocalDate;

public class Doctor {

    private Long userId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String clinicAddress;

    public Doctor(Long userId) {
        this.userId = userId;
    }

    public Doctor(Long userId, String firstName, String lastName, LocalDate dateOfBirth, String clinicAddress) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.clinicAddress = clinicAddress;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public void setClinicAddress(String clinicAddress) {
        this.clinicAddress = clinicAddress;
    }
}
