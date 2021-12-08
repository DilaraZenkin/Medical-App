package com.techelevator.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Office {

    private long officeId;
    private String officeAddress;
    private String officePhoneNumber;
    private LocalTime officeOpen;
    private LocalTime officeClose;
    private long hourlyCost;

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

    public Office(Long officeId, String officeAddress, String officePhoneNumber, LocalTime officeOpen, LocalTime officeClose, long hourlyCost) {
        this.officeId = officeId;
        this.officeAddress = officeAddress;
        this.officePhoneNumber = officePhoneNumber;
        this.officeOpen = officeOpen;
        this.officeClose = officeClose;
        this.hourlyCost = hourlyCost;
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

    public LocalTime getOfficeOpen() {
        return officeOpen;
    }

    public void setOfficeOpen(LocalTime officeOpen) {
        this.officeOpen = officeOpen;
    }

    public LocalTime getOfficeClose() {
        return officeClose;
    }

    public void setOfficeClose(LocalTime officeClose) {
        this.officeClose = officeClose;
    }

    public long getHourlyCost() {
        return hourlyCost;
    }

    public void setHourlyCost(long hourlyCost) {
        this.hourlyCost = hourlyCost;
    }
}
