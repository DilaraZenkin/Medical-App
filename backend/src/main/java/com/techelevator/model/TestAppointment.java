package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestAppointment {

    private String patientFirstName;
    private String patientLastName;
    private String officeAddress;
    private LocalDate appointmentDate;
    private LocalTime startTime;
    private String doctorFirstName;
    private String doctorLastName;

    public TestAppointment() {
    }

    public TestAppointment(String patientFirstName, String patientLastName, String officeAddress, LocalDate appointmentDate, LocalTime startTime, String doctorFirstName, String doctorLastName) {
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.officeAddress = officeAddress;
        this.appointmentDate = appointmentDate;
        this.startTime = startTime;
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
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
