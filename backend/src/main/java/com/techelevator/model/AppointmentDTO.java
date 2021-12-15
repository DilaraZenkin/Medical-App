package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDTO {


    private Long appointmentId;
    private LocalDate appointmentDate;
    private LocalTime startTime;
    private Patient patient;
    private Doctor doctor;
    private String address;

    public AppointmentDTO() {
    }

    public AppointmentDTO(Long appointmentId, LocalDate appointmentDate, LocalTime startTime, Patient patient, Doctor doctor, String address) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.startTime = startTime;
        this.patient = patient;
        this.doctor = doctor;
        this.address = address;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
