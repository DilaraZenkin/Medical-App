package com.techelevator.dao;

import com.techelevator.model.Patient;
import com.techelevator.model.PatientDTO;

import java.util.List;

public interface PatientDAO {

    List<Patient> findAllPatients();

    PatientDTO getPatientByPatientId(Long patientId);

    List<Patient> getPatientListByDoctorId(Long doctorId);

    Patient register (Patient patient);

    PatientDTO updatePatientInformation (PatientDTO patient);
}
