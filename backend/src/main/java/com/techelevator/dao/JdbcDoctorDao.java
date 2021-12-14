package com.techelevator.dao;

import com.techelevator.model.Doctor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.SQLErrorCodes;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDoctorDao implements DoctorDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcDoctorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Doctor> findAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "select d.*, office_address from doctors d JOIN offices USING (office_id);";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Doctor doctor = mapRowToDoctor(results);
            doctors.add(doctor);
        }
        return doctors;
    }

    @Override
    public Doctor getDoctorByDoctorId(Long doctorId) {
        String sql = "SELECT d.*, office_address FROM doctors d JOIN offices USING (office_id) WHERE doctor_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        if (results.next()) {
            return mapRowToDoctor(results);
        } else {
            throw new RuntimeException("DoctorId" + doctorId + "was not found.");
        }
    }

    @Override
    public List<Doctor> getAllDoctorsAtOffice(Long officeId) {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT d.*, office_address FROM doctors d JOIN offices USING (office_id) WHERE office_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        while(results.next()) {
            Doctor doctor = mapRowToDoctor(results);
            doctors.add(doctor);
        }
        return doctors;
    }

    @Override
    public Doctor register(Doctor doctor) {
        String sql = "INSERT INTO doctors (doctor_id, doctor_first, doctor_last, date_of_birth, office_id) " +
                "VALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, doctor.getDoctorId(), doctor.getFirstName(), doctor.getLastName(), doctor.getDateOfBirth(), doctor.getOfficeId());
        return doctor;
    }

    private Doctor mapRowToDoctor(SqlRowSet rs) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(rs.getLong("doctor_id"));
        doctor.setFirstName(rs.getString("doctor_first"));
        doctor.setLastName(rs.getString("doctor_last"));
        doctor.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
        doctor.setOfficeId(rs.getLong("office_id"));
        doctor.setOfficeAddress(rs.getString("office_address"));
        return doctor;
    }
}
