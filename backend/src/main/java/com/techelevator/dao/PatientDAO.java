package com.techelevator.dao;

import com.techelevator.model.Patient;

import java.util.List;

public interface PatientDAO {

    List<Patient> findAllPatients();

    Patient getPatientByUserId(String userId);

    Patient getPatientByPatientId(String patientId);

    Patient findPatientByFullName(String firstName, String lastName);

    Long  findPatientIdByFullName(String firstName, String lastName);

    boolean register (Long userId, Long patientId);
}
