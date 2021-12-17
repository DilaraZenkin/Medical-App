package com.techelevator.dao;

import com.techelevator.model.DoctorAvailability;

import java.util.List;

public interface AvailabilityDao {

    DoctorAvailability getSingleDoctorAvailability(Long doctorId);

    List<DoctorAvailability> getAvailabilityForDoctor(Long doctorId);

    boolean setAvailableHours(DoctorAvailability availability);

    boolean updateAvailability(DoctorAvailability availability);

}
