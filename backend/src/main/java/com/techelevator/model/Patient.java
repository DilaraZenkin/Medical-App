package com.techelevator.model;
import java.time.LocalDate;

public class Patient {

    private Long userId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String patientAddress;

    public Patient(Long userId) {
        this.userId = userId;
    }

    public Patient(Long userId, String firstName, String lastName, LocalDate dateOfBirth, String patientAddress) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.patientAddress = patientAddress;
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

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }
}

