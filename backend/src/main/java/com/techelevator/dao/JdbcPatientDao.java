package com.techelevator.dao;

import com.techelevator.model.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;

public class JdbcPatientDao implements PatientDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcPatientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
    public Patient mapRowToPatient(SqlRowSet rs) {
        Patient patient = new Patient();
        patient.setPatientId(rs.getLong("patient_id"));
        patient.setFirstName(rs.getString("first_name"));
        patient.setLastName(rs.getString("last_name"));
        patient.setDateOfBirth((LocalDate) rs.getObject("date_of_birth"));
        patient.setPatientAddress(rs.getString("address"));
        return patient;
    }
}
