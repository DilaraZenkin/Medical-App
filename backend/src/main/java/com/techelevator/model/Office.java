package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private long officeId;
    private String officeAddress;
    private String officePhoneNumber;
    private String officeOpen;
    private String officeClose;
    private long hourlyCost;

    private List<Doctor> doctors = new ArrayList<>();


    public Office() {

    }

    public Office(OfficeDTO dto, long officeId) {
        this.officeId = officeId;
        this.officeAddress = dto.getAddress();
        this.officePhoneNumber = dto.getOfficePhoneNumber();
        this.officeOpen = dto.getOfficeOpen();
        this.officeClose = dto.getOfficeClose();
        this.hourlyCost = dto.getHourlyCost();
    }

    public Office(Long officeId, String officeAddress, String officePhoneNumber, String officeOpen, String officeClose, long hourlyCost, List<Doctor> doctors) {
        this.officeId = officeId;
        this.officeAddress = officeAddress;
        this.officePhoneNumber = officePhoneNumber;
        this.officeOpen = officeOpen;
        this.officeClose = officeClose;
        this.hourlyCost = hourlyCost;
        this.doctors = doctors;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getOfficePhoneNumber() {
        return officePhoneNumber;
    }

    public void setOfficePhoneNumber(String officePhoneNumber) {
        this.officePhoneNumber = officePhoneNumber;
    }

    public String getOfficeOpen() {
        return officeOpen;
    }

    public void setOfficeOpen(String officeOpen) {
        this.officeOpen = officeOpen;
    }

    public String getOfficeClose() {
        return officeClose;
    }

    public void setOfficeClose(String officeClose) {
        this.officeClose = officeClose;
    }

    public long getHourlyCost() {
        return hourlyCost;
    }

    public void setHourlyCost(long hourlyCost) {
        this.hourlyCost = hourlyCost;
    }
}
