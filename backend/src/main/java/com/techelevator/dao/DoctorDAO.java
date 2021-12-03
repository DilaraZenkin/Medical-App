package com.techelevator.dao;

import com.techelevator.model.Doctor;

public interface DoctorDAO {

    Doctor getDoctorByUserId(Long userId);

    Doctor getDoctorByDoctorId(Long doctorId);

    Doctor findDoctorByFullName(String firstName, String lastName);

    Long findDoctorIdByFullName(String firstName, String lastName);

    boolean register (Long userId, Long doctorId);
}
