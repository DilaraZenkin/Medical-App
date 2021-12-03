package com.techelevator.dao;

import com.techelevator.model.Patient;

public class JdbcPatientDao implements PatientDAO{

    @Override
    public Patient getPatientByUserId(String userId) {
        return null;
    }

    @Override
    public Patient getPatientByPatientId(String patientId) {
        return null;
    }

    @Override
    public Patient findPatientByFullName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Long findPatientIdByFullName(String firstName, String lastName) {
        return null;
    }

    @Override
    public boolean register(Long userId, Long patientId) {
        return false;
    }
}
