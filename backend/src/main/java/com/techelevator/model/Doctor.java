package com.techelevator.model;

import java.time.LocalDate;

public class Doctor {

    private Long doctorId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String officeAddress;

    public Doctor() {
    }

    public Doctor(Long doctorId, String firstName, String lastName, LocalDate dateOfBirth, String officeAddress) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.officeAddress = officeAddress;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
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

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }
}
