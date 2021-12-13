package com.techelevator.dao;

import com.techelevator.model.Office;

import java.util.List;

public interface OfficeDAO {

    Office getOfficeById(Long officeId);
    int findIdByOfficeAddress(String officeAddress);
    long create(String officeAddress, String officePhonenumber, String officeOpen, String officeClose, long hourlyCost);
    Office addNewOffice(Office office);
    Office updateOffice (Office office);
    List<Office> findAllOffices();
    Office getOfficeByDoctorId(Long doctorId);
    List<Office> officeInfoByDoctorFirstName();
    List<Office> officeInfoByDoctorLastName();
    List<Office> officeInfoByDoctorFullName();
}

