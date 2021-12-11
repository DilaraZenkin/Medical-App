package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class DoctorAvailability {

    private Long doctorAvailabilityId;
    private Long doctorId;
    private LocalDate dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean isAvailable;

    public DoctorAvailability() {
    }

    public DoctorAvailability(Long doctorAvailabilityId, Long doctorId, LocalDate dayOfWeek, LocalTime startTime, LocalTime endTime, boolean isAvailable) {
        this.doctorAvailabilityId = doctorAvailabilityId;
        this.doctorId = doctorId;
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

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
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