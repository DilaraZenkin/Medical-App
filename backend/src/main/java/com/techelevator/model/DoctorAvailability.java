package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class DoctorAvailability {

    private Long doctorAvailabilityId;
    private Doctor doctor;
    private LocalDate dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean isAvailable;

    public DoctorAvailability() {
    }

    public DoctorAvailability(Long doctorAvailabilityId, Doctor doctor, LocalDate dayOfWeek, LocalTime startTime, LocalTime endTime, boolean isAvailable) {
        this.doctorAvailabilityId = doctorAvailabilityId;
        this.doctor = doctor;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isAvailable = isAvailable;
    }

    public Long getDoctorAvailabilityId() {
        return doctorAvailabilityId;
    }

    public void setDoctorAvailabilityId(Long doctorAvailabilityId) {
        this.doctorAvailabilityId = doctorAvailabilityId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(LocalDate dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}