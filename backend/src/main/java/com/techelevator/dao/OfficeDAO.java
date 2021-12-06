package com.techelevator.dao;

import com.techelevator.model.Office;

import java.util.List;

public interface OfficeDAO {

    List<Office> officeInfoByDoctorFirstName();
    List<Office> officeInfoByDoctorLastName();
    List<Office> officeInfoByDoctorFullName();
}
