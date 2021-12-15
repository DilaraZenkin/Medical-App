package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.DoctorAvailability;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAvailabilityDao implements AvailabilityDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAvailabilityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public DoctorAvailability getSingleDoctorAvailability(Long doctorId) {
        String sql = "SELECT da.availability_id, da.day_of_week, da.start_time, da.end_time, da.available, d.doctor_id, " +
                "d.doctor_last, d.office_id from doctor_availabilities da join doctors d using (doctor_id) WHERE da.doctor_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        if (results.next()) {
            return mapRowToDoctorAvailability(results);
        } else {
            throw new RuntimeException("Could not retrieve availability at this time, please try again later");
        }
    }

    @Override
    public List<DoctorAvailability> getAvailabilityForDoctor(Long doctorId) {
        List<DoctorAvailability> availabilities = new ArrayList<>();
        String sql = "SELECT da.availability_id, da.day_of_week, da.start_time, da.end_time, da.available, d.doctor_id, " +
                "d.doctor_last, d.office_id from doctor_availabilities da join doctors d using (doctor_id) WHERE da.doctor_id = ? " +
                " ORDER BY availability_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        while (results.next()) {
            DoctorAvailability availability = mapRowToDoctorAvailability(results);
            availabilities.add(availability);
        }
        return availabilities;
    }

    @Override
    public boolean setAvailableHours(DoctorAvailability availability) {
        String sql ="INSERT INTO doctor_availabilities (availability_id, doctor_id, day_of_week, start_time, end_time, available)\n" +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, availability.getDoctor().getDoctorId(), availability.getDayOfWeek(), availability.getStartTime(), availability.getEndTime(), availability.isAvailable());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateAvailability(DoctorAvailability availability) {
        String sql = "UPDATE doctor_availabilities SET day_of_week = ?, start_time = ?, end_time = ?, available = ? \n" +
                "WHERE availability_id = ?;";
         try {
             jdbcTemplate.update(sql, availability.getDayOfWeek(), availability.getStartTime(), availability.getEndTime(), availability.isAvailable(), availability.getAvailabilityId());
             return true;
         } catch (Exception e) {
             System.out.println(e.getMessage());
             return false;
         }
    }

    public DoctorAvailability mapRowToDoctorAvailability(SqlRowSet rs) {
        DoctorAvailability availability = new DoctorAvailability();
        Doctor doctor = new Doctor();
        availability.setAvailabilityId(rs.getLong("availability_id"));
        availability.setDayOfWeek(rs.getDate("day_of_week").toLocalDate());
        availability.setStartTime(rs.getTime("start_time").toLocalTime());
        availability.setEndTime(rs.getTime("end_time").toLocalTime());
        availability.setAvailable(rs.getBoolean("available"));
        doctor.setDoctorId(rs.getLong("doctor_id"));
        doctor.setLastName(rs.getString("doctor_last"));
        doctor.setOfficeId(rs.getLong("office_id"));
        availability.setDoctor(doctor);
        return availability;
    }
}
