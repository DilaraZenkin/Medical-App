package com.techelevator.dao;

import com.techelevator.model.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

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
    public Patient register(Patient patient) {
        String sql = "INSERT INTO patients (patient_id, first_name, last_name, date_of_birth, address) " +
                     "VALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, patient.getPatientId(), patient.getFirstName(), patient.getLastName(), patient.getDateOfBirth(), patient.getPatientAddress());
        return patient;
    }

    @Override
    public Patient updatePatientInformation(Patient patient) {
        String sql = "UPDATE patients SET first_name = ?,\n" +
                     "last_name = ?, date_of_birth = ?,\n" +
                     "address = ?, doctor_id = ?\n" +
                     "WHERE patient_id = ?;";
        jdbcTemplate.update(sql, patient.getFirstName(), patient.getLastName(), patient.getDateOfBirth(), patient.getPatientAddress(), patient.getDoctorId(), patient.getPatientId());
        return patient;
    }

    public Patient mapRowToPatient(SqlRowSet rs) {
        Patient patient = new Patient();
        patient.setPatientId(rs.getLong("patient_id"));
        patient.setFirstName(rs.getString("first_name"));
        patient.setLastName(rs.getString("last_name"));
        patient.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
        patient.setPatientAddress(rs.getString("address"));
        patient.setDoctorId(rs.getLong("doctor_id"));
        return patient;
    }
}
