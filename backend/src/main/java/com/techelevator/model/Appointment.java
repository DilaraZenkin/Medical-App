package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private Long appointmentId;
    private Long officeId;
    private Long patientId;
    private Long doctorId;
    private LocalDate dayOfAppointment;
    private LocalTime startTime;
    private LocalTime endTime;

    public Appointment() {
    }

    public Appointment(Long appointmentId, Long officeId, Long patientId, Long doctorId, LocalDate dayOfAppointment, LocalTime startTime, LocalTime endTime) {
        this.appointmentId = appointmentId;
        this.officeId = officeId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dayOfAppointment = dayOfAppointment;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getDayOfAppointment() {
        return dayOfAppointment;
    }

    public void setDayOfAppointment(LocalDate dayOfAppointment) {
        this.dayOfAppointment = dayOfAppointment;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
