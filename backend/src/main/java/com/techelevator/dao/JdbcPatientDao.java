package com.techelevator.dao;

import com.techelevator.model.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPatientDao implements PatientDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcPatientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Patient> findAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "select * from patients";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Patient patient = mapRowToPatient(results);
            patients.add(patient);
        }
        return patients;
    }

    @Override
    public Patient getPatientByUserId(Long userId) {
        return null;
    }

    @Override
    public Patient getPatientByPatientId(Long patientId) {
        String sql = "SELECT * FROM patients WHERE patient_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        if (results.next()) {
            return mapRowToPatient(results);
        } else {
            throw new RuntimeException("PatientId " + patientId + " was not found.");
        }
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
        patient.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
        patient.setPatientAddress(rs.getString("address"));
        return patient;
    }
}
