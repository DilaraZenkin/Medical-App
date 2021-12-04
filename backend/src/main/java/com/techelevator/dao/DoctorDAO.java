package com.techelevator.dao;

import com.techelevator.model.Doctor;

import java.util.List;

public interface DoctorDAO {

    List<Doctor> findAllDoctors();

    Doctor getDoctorByUserId(Long userId);

    Doctor getDoctorByDoctorId(Long doctorId);

    Doctor findDoctorByFullName(String firstName, String lastName);

    Long findDoctorIdByFullName(String firstName, String lastName);

    boolean register (Long userId, Long doctorId);
}
