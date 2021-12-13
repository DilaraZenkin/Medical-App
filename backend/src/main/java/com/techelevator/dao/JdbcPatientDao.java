package com.techelevator.dao;

import com.techelevator.model.Patient;
import com.techelevator.model.PatientDTO;
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
    public PatientDTO getPatientByPatientId(Long patientId) {
        String sql = "SELECT patient_id, first_name, last_name, p.date_of_birth, address, doctor_first, doctor_last\n" +
                "FROM patients p FULL OUTER JOIN doctors d USING (doctor_id) WHERE p.patient_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        if (results.next()) {
            return mapRowToPatientDTO(results);
        } else {
            throw new RuntimeException("PatientId " + patientId + " was not found.");
        }
    }

    @Override
    public List<Patient> getPatientListByDoctorId(Long doctorId) {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients WHERE doctor_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        while(results.next()) {
            Patient patient = mapRowToPatient(results);
            patients.add(patient);
        }
        return patients;
    }

    @Override
    public Patient register(Patient patient) {
        String sql = "INSERT INTO patients (patient_id, first_name, last_name, date_of_birth, address) " +

                     "VALUES (?, ?, ?, ?, ?);";

        jdbcTemplate.update(sql, patient.getPatientId(), patient.getFirstName(), patient.getLastName(), patient.getDateOfBirth(), patient.getPatientAddress());
        return patient;
    }

    @Override
    public PatientDTO updatePatientInformation(PatientDTO patient) {
        String sql = "UPDATE patients SET first_name = ?, last_name = ?, date_of_birth = ?,\n" +
                     "address = ?, doctor_id = (SELECT doctor_id FROM doctors WHERE doctor_first ILIKE ?) \n" +
                     "WHERE patient_id = ?;";
        jdbcTemplate.update(sql, patient.getFirstName(), patient.getLastName(), patient.getDateOfBirth(), patient.getPatientAddress(),
                "%" + patient.getDoctorFirstName() + "%", patient.getPatientId());
        return getPatientByPatientId(patient.getPatientId());
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

    public PatientDTO mapRowToPatientDTO(SqlRowSet rs) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setPatientId(rs.getLong("patient_id"));
        patientDTO.setFirstName(rs.getString("first_name"));
        patientDTO.setLastName(rs.getString("last_name"));
        patientDTO.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
        patientDTO.setPatientAddress(rs.getString("address"));
        patientDTO.setDoctorFirstName(rs.getString("doctor_first"));
        patientDTO.setDoctorLastName(rs.getString("doctor_last"));
        return patientDTO;
    }
}
