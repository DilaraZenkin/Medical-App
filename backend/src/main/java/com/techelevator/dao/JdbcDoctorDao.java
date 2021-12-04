package com.techelevator.dao;

import com.techelevator.model.Doctor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public Doctor getDoctorByUserId(Long userId) {
        return null;
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
    public Doctor findDoctorByFullName(String firstName, String lastName) {
        for (Doctor doctor : this.findAllDoctors()) {
            if (doctor.getFirstName().toLowerCase().equals(firstName.toLowerCase()) &&
            doctor.getLastName().toLowerCase().equals(lastName.toLowerCase())) {
                return doctor;
            }
        }
        throw new RuntimeException("Doctor " + firstName + " " + lastName + " was not found.");
    }

    @Override
    public Long findDoctorIdByFullName(String firstName, String lastName) {
        String sql = "SELECT * FROM doctors where first_name = ? and last_name = ?;";
        return jdbcTemplate.queryForObject(sql, Long.class, firstName, lastName);
    }

    @Override
    public boolean register(Long userId, Long doctorId) {
        return false;
    }

    private Doctor mapRowToDoctor(SqlRowSet rs) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(rs.getLong("doctor_id"));
        doctor.setFirstName(rs.getString("first_name"));
        doctor.setLastName(rs.getString("last_name"));
        doctor.setDateOfBirth((LocalDate) rs.getObject("date_of_birth"));
        doctor.setClinicAddress(rs.getString("clinic_address"));
        return doctor;
    }
}
