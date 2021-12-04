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
    public Patient getPatientByUserId(String userId) {
        return null;
    }

    @Override
    public Patient getPatientByPatientId(String patientId) {
        String sql = "SELECT * FROM patients WHERE patient_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        if (results.next()) {
            return mapRowToPatient(results);
        } else {
            throw new RuntimeException("PatientId " + patientId + " was not found.");
        }
    }

    @Override
    public Patient findPatientByFullName(String firstName, String lastName) {
        for (Patient patient : this.findAllPatients()) {
            if (patient.getFirstName().toLowerCase().equals(firstName.toLowerCase()) &&
                    patient.getLastName().toLowerCase().equals(lastName.toLowerCase())) {
                return patient;
            }
        }
        throw new RuntimeException("Patient " + firstName + " " + lastName + " was not found.");
    }

    @Override
    public Long findPatientIdByFullName(String firstName, String lastName) {
        String sql = "SELECT * FROM patients where first_name = ? and last_name = ?;";
        return jdbcTemplate.queryForObject(sql, Long.class, firstName, lastName);
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
