package com.techelevator.dao;

import com.techelevator.model.Patient;

public interface PatientDAO {

    Patient getPatientByUserId(String userId);

    Patient getPatientByPatientId(String patientId);

    Patient findPatientByFullName(String firstName, String lastName);

    Long  findPatientIdByFullName(String firstName, String lastName);

    boolean register (Long userId, Long patientId);
}
