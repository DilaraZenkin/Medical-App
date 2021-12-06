package com.techelevator.dao;

import com.techelevator.model.Patient;

import java.util.List;

public interface PatientDAO {

    List<Patient> findAllPatients();

    Patient getPatientByUserId(Long userId);

    Patient getPatientByPatientId(Long patientId);

    boolean register (Long userId, Long patientId);
}
