package com.techelevator.dao;

import com.techelevator.model.Doctor;

import java.util.List;

public interface DoctorDAO {

    List<Doctor> findAllDoctors();

    Doctor getDoctorByDoctorId(Long doctorId);

    List<Doctor> getAllDoctorsAtOffice(Long officeId);

    Doctor doctorNameByPatientId(Long patientId);

    Doctor register (Doctor doctor);
}
