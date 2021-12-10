package com.techelevator.dao;

import com.techelevator.model.Office;

import java.util.List;

public interface OfficeDAO {

    Office getOfficeById(Long officeId);
    int findIdByOfficeAddress(String officeAddress);
    long create(String officeAddress, String officePhonenumber, String officeOpen, String officeClose, long hourlyCost);
    Office updateOffice (Office office);
    List<Office> officeInfoByDoctorFirstName(String firstNameSearch);
    List<Office> officeInfoByDoctorLastName(String lastNameSearch);
    List<Office> officeInfoByDoctorFullName(String firstNameSearch, String lastNameSearch);
    Office addNewOffice(Office office);
}

