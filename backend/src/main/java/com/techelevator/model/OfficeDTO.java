package com.techelevator.model;

public class OfficeDTO {
    //TODO: add fields here so you can call create method in OfficeController
    //TODO: at minimum need these fields: address, phonenumber, officehours, cost
    private Long officeId;
    private String officePhoneNumber;
    private String officeOpen;
    private String officeClose;
    private long hourlyCost;
    private String officeAddress;

    public Long getOfficeId() {
        return getOfficeId();
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getAddress() {
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
