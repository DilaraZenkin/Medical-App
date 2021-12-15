package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDTO {

    private Long appointmentId;
    private Long officeId;
    private Long patientId;
    private Long doctorId;
    private String patientFirstName;
    private String patientLastName;
    private String officeAddress;
    private LocalDate appointmentDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String doctorFirstName;
    private String doctorLastName;

    public AppointmentDTO() {
    }

    public AppointmentDTO(Long appointmentId, String patientFirstName, String patientLastName, String officeAddress, LocalDate appointmentDate, LocalTime startTime, String doctorFirstName, String doctorLastName) {
        this.appointmentId = appointmentId;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.officeAddress = officeAddress;
        this.appointmentDate = appointmentDate;
        this.startTime = startTime;
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
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

    public Long getOfficeId() {
        return officeId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
