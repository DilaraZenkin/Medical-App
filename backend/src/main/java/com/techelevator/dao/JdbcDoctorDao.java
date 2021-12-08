package com.techelevator.dao;

import com.techelevator.model.Doctor;
import org.springframework.jdbc.core.JdbcTemplate;
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
        String sql = "select * from doctors";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Doctor doctor = mapRowToDoctor(results);
            doctors.add(doctor);
        }
        return doctors;
    }

    @Override
    public Doctor getDoctorByDoctorId(Long doctorId) {
        String sql = "SELECT * FROM doctors WHERE doctor_id = ?;";
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
        String sql = "select * from doctors WHERE office_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        while(results.next()) {
            Doctor doctor = mapRowToDoctor(results);
            doctors.add(doctor);
        }
        return doctors;
    }

    @Override
    public Doctor register(Doctor doctor) {
        String sql = "INSERT INTO doctors (doctor_id, first_name, last_name, date_of_birth, office_id) " +
                "VALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, doctor.getDoctorId(), doctor.getFirstName(), doctor.getLastName(), doctor.getDateOfBirth(), doctor.getOfficeId());
        return doctor;
    }

    private Doctor mapRowToDoctor(SqlRowSet rs) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(rs.getLong("doctor_id"));
        doctor.setFirstName(rs.getString("first_name"));
        doctor.setLastName(rs.getString("last_name"));
        doctor.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
        doctor.setOfficeId(rs.getLong("office_id"));
        return doctor;
    }
}
