package com.techelevator.dao;

import com.techelevator.model.DoctorAvailability;

import java.util.List;

public interface AvailabilityDao {

    List<DoctorAvailability> getAvailabilityForDoctor(Long doctorId);

    DoctorAvailability setAvailableHours(Long doctorId);

    DoctorAvailability updateAvailability(Long doctorId);
}
