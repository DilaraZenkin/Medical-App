package com.techelevator.dao;

import com.techelevator.model.Patient;

import java.util.List;

public interface PatientDAO {

    List<Patient> findAllPatients();

    Patient getPatientByPatientId(Long patientId);

    Patient register (Patient patient);
}
