package com.techelevator.model;

import java.time.LocalDate;

public class PatientDTO {

    private Long patientId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String patientAddress;
    private String doctorFirstName;
    private String doctorLastName;

    public PatientDTO() {
    }

    public PatientDTO(Long patientId, String firstName, String lastName, LocalDate dateOfBirth, String patientAddress, String doctorFirstName, String doctorLastName) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.patientAddress = patientAddress;
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
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

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }
}
