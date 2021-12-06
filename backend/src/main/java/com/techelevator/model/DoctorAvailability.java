package com.techelevator.model;

import java.time.LocalDate;
public class DoctorAvailability {

    private long doctorAvailabilityId;
    private long doctorOfficeId;
    private String dayOfWeek;
    private String startTime;
    private String endTime;
    private String availability;

    public long getDoctorAvailabilityId() {
        return doctorAvailabilityId;
    }
    public void setDoctorAvailabilityId(long doctorAvailabilityId) {
        this.doctorAvailabilityId = doctorAvailabilityId;
    }

    public long getDoctorOfficeId() {
        return doctorOfficeId;
    }
    public void setDoctorOfficeId(long doctorOfficeId) {
        this.doctorOfficeId = doctorOfficeId;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAvailability() {
        return availability;
    }
    public void setAvailability(String availability) {
        this.availability = availability;
    }
}